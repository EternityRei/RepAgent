package controller.command.customer;

import controller.command.Command;
import controller.command.admin.OrdersListCommand;
import controller.command.utils.CommandUtil;
import controller.command.utils.Utils;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

public class OrdersListCustomerCommand implements Command {
    private static final Logger log = Logger.getLogger(OrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Orders List Customer Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        var userService = serviceFactory.getUserService();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("person");
        int userId = user.getId();
        List<Order> list = orderService.getAllOrderByUserID(userId);
        req.setAttribute("orders", list);
        Utils.sortOrders(list);
        String btn = req.getParameter("btn");
        if(Objects.nonNull(btn)){
            try{
                if(btn.equals("Pay")){
                    float userMoney = user.getMoney();
                    float price = Float.parseFloat(req.getParameter("price"));
                    if(userMoney < price){
                        log.error("You don't have enough money on your account to pay the bill");
                        throw new ServiceException();
                    }
                    float userMoneyLeft = userMoney - price;
                    user.setMoney(userMoneyLeft);
                    userService.update(user);
                    int orderId = Integer.parseInt(req.getParameter("id"));
                    Order order = orderService.getEntity(orderId);
                    order.setPaymentStatus(2);
                    orderService.update(order);
                }
                if(btn.equals("Cancel")){
                    int orderId = Integer.parseInt(req.getParameter("id"));
                    Order order = orderService.getEntity(orderId);
                    if(order.getWorkStatus() == 1 && order.getPaymentStatus() == 1){
                        order.setPaymentStatus(3);
                        orderService.update(order);
                    } else if(order.getWorkStatus() == 1 && order.getPaymentStatus() == 2){
                        float price = (Float.parseFloat(req.getParameter("price"))) / 2;
                        float moneyToReturn = user.getMoney() + price;
                        user.setMoney(moneyToReturn);
                    } else {
                        log.error("You cannot cancel the order, which was started and paid");
                        throw new ServiceException();
                    }
                }
            } catch (ServiceException | DatabaseException e) {
                throw new RuntimeException(e);
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/ordersList.jsp");
    }
}
