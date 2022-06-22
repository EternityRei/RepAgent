package controller.command;

import controller.command.utils.CommandUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    private static Logger log = Logger.getLogger(LogoutCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("-----------Logout-----------");

        request.getSession().invalidate();

        CommandUtil.goToPage(request, response, "/home.jsp");
    }
}
