package controller.command.admin;

import controller.command.utils.CommandUtil;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomersListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(CustomersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("---------------Customers List---------------");
        var serviceFactory = ServiceFactory.getInstance();
        try{
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/customersList.jsp");
            log.info("redirect success");
        } catch (Exception e) {
            log.info("something went wrong " + e.getMessage());
        }

    }
}
