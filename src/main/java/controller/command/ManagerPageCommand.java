package controller.command;

import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.User;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ManagerPageCommand implements Command {
    Logger logger = Logger.getLogger(ManagerPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        CommandUtil.goToPage(req,resp,"/WEB-INF/view/manager.jsp");
/*        var factory = ServiceFactory.getInstance();
        var orderService = factory.getOrderService();
        var userService = factory.getUserService();

        try {

            List<User> userList = userService.getAllUsers();
            List<Order> orderList = orderService.getAllOrder();
            List<Order> allOrders = orderService.getAll();

            req.setAttribute("users", userList.size());
            req.setAttribute("active", userList.size() - factory.getUserService().getAllBlocked());
            req.setAttribute("blocked", factory.getUserService().getAllBlocked());
            req.setAttribute("orders", allOrders.size());
            req.setAttribute("user_order", orderList.size());

        } catch (ServiceException e) {
            logger.error("serviceException in page admin ");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/manager.jsp");
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/manager.jsp");*/
    }
}
