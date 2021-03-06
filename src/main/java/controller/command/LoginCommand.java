package controller.command;

import controller.command.utils.CommandUtil;
import model.enity.User;
import model.exception.InvalidDataException;
import model.exception.NotFoundUserException;
import org.apache.log4j.Logger;
import service.UserService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginCommand implements Command {
    Logger log = Logger.getLogger(LoginCommand.class);
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (Objects.nonNull(login) && Objects.nonNull(password)) {
            UserService personService = factory.getUserService();

            try {
                var encrypt = CommandUtil.encrypt(password);
                User person = personService.getByLoginAndPasswd(login, encrypt.orElseThrow(Exception::new));

                if (Objects.nonNull(person)) {
                    req.getSession().setAttribute("person", person);

                    String page = CommandUtil.getUserPageByRole(person.getAccessLevel());

                    CommandUtil.goToPage(req, resp, page);
                    return;
                } else {
                    req.setAttribute("errorMessage", true);
                }

            } catch (Exception e) {
                req.setAttribute("notFound", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/login.jsp");

            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/login.jsp");
    }
}
