package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.Validation;
import model.enity.User;
import model.exception.AlreadyExistsUserException;
import model.exception.InvalidDataException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.UserService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RegistrationCommand implements Command {
    private static Logger log = Logger.getLogger(RegistrationCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("-----------Registration-----------");
        var serviceFactory = ServiceFactory.getInstance();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Objects.nonNull(email) && Objects.nonNull(password)) {
            try {

/*                if (!Validation.isEmailValid(email) || !Validation.isPasswordValid(password)) {
                    throw new InvalidDataException();
                }*/

                UserService userService = serviceFactory.getUserService();

                String name = req.getParameter("name");

                var user = userService.getByLogin(email);

                if (Objects.nonNull(user)) {
                    throw new AlreadyExistsUserException();
                } else {
                    user = new User.UserBuilderImpl()
                            .setName(name)
                            .setEmail(email)
                            .build();
                    var encrypt = CommandUtil.encrypt(password);

                    user.setPasswd(encrypt.orElseThrow(Exception::new));

                    user.setAccessLevel(2);
                    userService.add(user);

                    req.getSession().setAttribute("person", user);

                    String page = CommandUtil.getUserPageByRole(user.getAccessLevel());

                    CommandUtil.goToPage(req, resp, page);

                    log.info(user.toString());

                    log.info("successful registration");

                    return;
                }
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
                log.error(e.getMessage());
                req.setAttribute("not found", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (InvalidDataException e) {
                System.out.println(e.getMessage());
                req.setAttribute("wrongData", true);
                log.error("Incorrect login or password");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (AlreadyExistsUserException e) {
                System.out.println(e.getMessage());
                req.setAttribute("alreadyExist", true);
                log.error("person already exist");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getMessage());
                log.error(e.getMessage());
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
    }
}
