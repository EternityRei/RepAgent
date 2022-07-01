package controller.command.admin;

import controller.command.utils.CommandUtil;
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

public class CustomersListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(CustomersListCommand.class);


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("---------------Customers List---------------");
        var serviceFactory = ServiceFactory.getInstance();
        var userService = serviceFactory.getUserService();
        try{
            List<User> list = userService.getAllUsers();
            req.setAttribute("people", list);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/customersList.jsp");
        } catch (ServiceException e) {
            log.error(e.getMessage());
             CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/customersList.jsp");
        }
    }
}
