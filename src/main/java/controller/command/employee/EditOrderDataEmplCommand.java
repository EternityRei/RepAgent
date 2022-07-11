package controller.command.employee;

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

public class EditOrderDataEmplCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(EditOrderDataEmplCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("------------Edit Order Data Employee Command------------");
        var serviceFactory = ServiceFactory.getInstance();
        Order order;
        int id;
        var orderService = serviceFactory.getOrderService();
        String button = req.getParameter("btn");
        if(Objects.nonNull(button)){
            try{

                if(button.equals("Submit")){
                    id = Integer.parseInt(req.getParameter("id"));
                    order = orderService.getEntity(id);
                    int workStatus = Integer.parseInt(req.getParameter("workStatus"));
                    order.setWorkStatus(workStatus);
                    orderService.update(order);
                    log.info(order.toString());
                    log.info("Success Edit Order Data Command");
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/employeePack/editOrderData.jsp");
                    return;
                }
            }catch (ServiceException | DatabaseException e) {
                log.error("Error in Edit Order Data Employee Command " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/employeePack/editOrderData.jsp");
    }
}
