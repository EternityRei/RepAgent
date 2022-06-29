package controller.command.admin;

import controller.command.utils.CommandUtil;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessAddEmployeeCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(SuccessAddEmployeeCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("---------------Success Add Employee Command---------------");
        var serviceFactory = ServiceFactory.getInstance();
        try{
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/successAddEmployee.jsp");
            log.info("redirect success");
        } catch (Exception e) {
            log.info("something went wrong " + e.getMessage());
        }
    }
}
