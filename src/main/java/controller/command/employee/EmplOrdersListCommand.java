package controller.command.employee;

import controller.command.Command;
import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class EmplOrdersListCommand implements Command {

    private static final Logger log = Logger.getLogger(EmplOrdersListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Employee Orders List Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        int id;
        Order order;
        try{
            List<Order> list = orderService.getAll();
            req.setAttribute("orders", list);
            String button = req.getParameter("btn");
            if(Objects.nonNull(button)){
                if(button.equals("Submit")){
                    id = Integer.parseInt(req.getParameter("id"));
                    order = orderService.getEntity(id);
                    int workStatus = Integer.parseInt(req.getParameter("workStatus"));
                    order.setWorkStatus(workStatus);
                    orderService.update(order);
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
                    return;
                }
            }
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        } catch (ServiceException | DatabaseException e) {
            log.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/ordersList.jsp");
        }
    }
}
