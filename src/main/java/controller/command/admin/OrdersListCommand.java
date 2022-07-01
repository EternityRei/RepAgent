package controller.command.admin;

import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.User;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrdersListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(OrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Orders List Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        try{
            List<Order> list = orderService.getAll();
            req.setAttribute("orders", list);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        } catch (ServiceException e) {
            log.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        }
    }
}
