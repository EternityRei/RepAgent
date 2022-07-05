package controller.command.customer;

import controller.command.Command;
import controller.command.admin.OrdersListCommand;
import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.User;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrdersListCustomerCommand implements Command {
    private static final Logger log = Logger.getLogger(OrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Orders List Customer Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("person");
        int userId = user.getId();
        List<Order> list = orderService.getAllOrderByUserID(userId);
        req.setAttribute("orders", list);
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/ordersList.jsp");
    }
}
