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

public class ManagerPageCommand implements Command {
    Logger logger = Logger.getLogger(ManagerPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("person");
        float balance = user.getMoney();
        String name = user.getName();
        req.setAttribute("balance", balance);
        req.setAttribute("username", name);
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/manager.jsp");
    }
}
