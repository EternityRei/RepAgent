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
import java.util.Objects;

public class LoginCommand implements Command {
    Logger log = Logger.getLogger(LoginCommand.class);
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("LoginCommand");

        log.info("-------------Login-------------");

        ServiceFactory factory = ServiceFactory.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (Objects.nonNull(login) && Objects.nonNull(password)) {
            UserService userService = factory.getUserService();

            try {
                var encrypt = CommandUtil.encrypt(password);
                User user = userService.getByLoginAndPasswd(login, encrypt.orElseThrow(Exception::new));

                if (Objects.nonNull(user)) {
                    req.getSession().setAttribute("user", user);

                    String page = CommandUtil.getUserPageByRole(user.getAccessLevel());

                    CommandUtil.goToPage(req, resp, page);
                } else {
                    req.setAttribute("errorMessage", true);
                }

            } catch (NotFoundUserException e) {
                req.setAttribute("notFound", true);
                log.error("not found person");
                CommandUtil.goToPage(req, resp, "/login.jsp");
            } catch (InvalidDataException e) {
                req.setAttribute("wrongData", true);
                log.error("Incorrect login or password");
                CommandUtil.goToPage(req, resp, "/login.jsp");
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        CommandUtil.goToPage(req, resp, "/login.jsp");
    }
}
