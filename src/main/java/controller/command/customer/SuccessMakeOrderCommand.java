package controller.command.customer;

import controller.command.utils.CommandUtil;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessMakeOrderCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(SuccessMakeOrderCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("---------------Success Make Order Command---------------");
        var serviceFactory = ServiceFactory.getInstance();
        try{
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/successMakeOrder.jsp");
            log.info("redirect success");
        } catch (Exception e) {
            log.info("something went wrong " + e.getMessage());
        }
    }
}
