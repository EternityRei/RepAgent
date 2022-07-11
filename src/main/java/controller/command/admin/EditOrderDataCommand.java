package controller.command.admin;

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

public class EditOrderDataCommand implements Command {

    private static final Logger log = Logger.getLogger(EditOrderDataCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("-----------Edit Order Data Command-----------");
        var serviceFactory = ServiceFactory.getInstance();
        Order order;
        int id;
        var orderService = serviceFactory.getOrderService();
        var userService = serviceFactory.getUserService();
        String button = req.getParameter("btn");
        List<User> employeeList = userService.getAllEmployees();
        req.setAttribute("employees", employeeList);
        if(Objects.nonNull(button)){
            try{

                if(button.equals("Submit")){
                    id = Integer.parseInt(req.getParameter("id"));
                    order = orderService.getEntity(id);
                    log.info("id returned from jsp: " + id);
                    log.info("order id to check: "+ order.getId());
                    log.info("All order log: " + order.toString());
                    float price = Float.parseFloat(req.getParameter("price"));
                    order.setCost(price);
                    int payment = Integer.parseInt(req.getParameter("paymentStatus"));
                    order.setPaymentStatus(payment);
                    int worker = Integer.parseInt(req.getParameter("worker"));
                    order.setWorkerId(worker);
                    orderService.update(order);
                    log.info(order.toString());
                    log.info("Success Edit Order Data Command");
                    CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/editOrderData.jsp");
                    return;
                }
            }catch (ServiceException | DatabaseException e) {
                log.error("Error in Edit Order Data Command " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/editOrderData.jsp");
    }
}
