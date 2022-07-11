package controller.command.admin;

import controller.command.Command;
import controller.command.utils.CommandUtil;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class IncreaseMoneyCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(IncreaseMoneyCommand.class);
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("-----------Increase Money Command-----------");
        var serviceFactory = ServiceFactory.getInstance();
        User user;
        int id;
        var userService = serviceFactory.getUserService();
        String button = req.getParameter("btn");
        String checkbox = req.getParameter("checkbox");
        if(Objects.nonNull(button) && Objects.nonNull(checkbox)){
            try{
                if(button.equals("Top up")){
                    id = Integer.parseInt(req.getParameter("id"));
                    user = userService.getEntity(id);
                    float money = Float.parseFloat(req.getParameter("sum"));
                    float existingMoney = user.getMoney();
                    float moneyToAdd = money + existingMoney;
                    user.setMoney(moneyToAdd);
                    userService.update(user);
                    log.info("Success Increase Money Command");
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/customersList.jsp");
                    return;
                }
            }catch (ServiceException | DatabaseException e) {
                log.error("Error in Increase Money Command " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/increaseMoney.jsp");
    }
}
