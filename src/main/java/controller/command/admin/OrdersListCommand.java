package controller.command.admin;

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
import java.util.List;
import java.util.Objects;

public class OrdersListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(OrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Orders List Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        var userService = serviceFactory.getUserService();
        int id;
        Order order;
        try{
            List<Order> list = orderService.getAll();
            req.setAttribute("orders", list);
            Utils.sortOrders(list);
            List<User> employeeList = userService.getAllEmployees();
            req.setAttribute("employees", employeeList);
            String button = req.getParameter("btn");
            if(Objects.nonNull(button)){
                if(button.equals("Submit")){
                    id = Integer.parseInt(req.getParameter("id"));
                    order = orderService.getEntity(id);
                    float price = Float.parseFloat(req.getParameter("price"));
                    order.setCost(price);
                    int paymentStatus = Integer.parseInt(req.getParameter("paymentStatus"));
                    order.setPaymentStatus(paymentStatus);
                    int employeeId = Integer.parseInt(req.getParameter("worker"));
                    order.setWorkerId(employeeId);
                    orderService.update(order);
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
                    return;
                }
            }
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        } catch (ServiceException | DatabaseException e) {
            log.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        }
    }
}
