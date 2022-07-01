package controller.command.admin;

import controller.command.Command;
import controller.command.utils.CommandUtil;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class IncreaseMoneyCommand implements controller.command.Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        var serviceFactory = ServiceFactory.getInstance();
        User user;
        int id;
        var userService = serviceFactory.getUserService();
        String button = req.getParameter("btn");
        String checkbox = req.getParameter("checkbox");
        if(Objects.nonNull(button) && Objects.nonNull(checkbox)){
            try{
                if(button.equals("Top up") && checkbox.equals("on")){
/*                    String path = req.getRequestURI();
                    System.out.println(path);
                    path = path.substring(path.indexOf("id"));
                    System.out.println(path);
                    path = path.substring(path.indexOf("&")+5);
                    HttpSession session = req.getSession();*/
                    id = Integer.parseInt(req.getParameter("user.id"));
                    user = userService.getEntity(id);
                    float money = Float.parseFloat(req.getParameter("sum"));
                    float existingMoney = user.getMoney();
                    float moneyToAdd = money + existingMoney;
                    user.setMoney(moneyToAdd);
                    userService.update(user);
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/customersList.jsp");
                }
            }catch (ServiceException | DatabaseException e) {
                throw new RuntimeException(e);
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/increaseMoney.jsp");
    }
}
