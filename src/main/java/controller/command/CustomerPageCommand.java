package controller.command;

import controller.command.utils.CommandUtil;
import model.enity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("person");
        float balance = user.getMoney();
        String name = user.getName();
        req.setAttribute("username", name);
        req.setAttribute("balance", balance);
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customer.jsp");
    }
}
