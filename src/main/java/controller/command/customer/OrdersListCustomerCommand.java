package controller.command.customer;

import controller.command.Command;
import controller.command.utils.CommandUtil;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrdersListCustomerCommand implements Command {
    private static final Logger log = Logger.getLogger(OrdersListCustomerCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("---------------Orders Customer List---------------");
        var serviceFactory = ServiceFactory.getInstance();
        try{
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/ordersList.jsp");
            log.info("redirect success");
        } catch (Exception e) {
            log.info("something went wrong " + e.getMessage());
        }
    }
}
