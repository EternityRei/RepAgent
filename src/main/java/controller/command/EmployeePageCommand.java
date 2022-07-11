package controller.command;

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

public class EmployeePageCommand implements Command {

    Logger logger = Logger.getLogger(EmployeePageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("person");
        float balance = user.getMoney();
        req.setAttribute("balance", balance);

        var factory = ServiceFactory.getInstance();
        var orderService = factory.getOrderService();
        var userService = factory.getUserService();

        try {
            List<Order> byManagerID = orderService.getAllOrderByUserID(3);
            List<Order> orderList = orderService.getAllOrder();
            List<Order> allOrders = orderService.getAll();

            req.setAttribute("orders", allOrders.size());
            req.setAttribute("user_order", orderList.size());
            req.setAttribute("allOrdersForThatManager", byManagerID.size());

        } catch (ServiceException e) {
            logger.error("serviceException in page employee ");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/employee.jsp");
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/employee.jsp");
    }
}
