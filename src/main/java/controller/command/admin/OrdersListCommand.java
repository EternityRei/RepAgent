package controller.command.admin;

import model.enity.Order;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrdersListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(OrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Orders List Command--------------");

        Order order;
        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();

        String button = req.getParameter("button");


    }
}
