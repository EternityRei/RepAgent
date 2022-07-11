package controller.command.customer;

import com.thoughtworks.qdox.model.expression.Or;
import controller.command.Command;
import controller.command.utils.CommandUtil;
import controller.command.utils.Validation;
import model.enity.Order;
import model.enity.User;
import model.exception.AlreadyExistsUserException;
import model.exception.InvalidDataException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.OrderService;
import service.UserService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class MakeAnOrderCommand implements Command {

    private static final Logger log = Logger.getLogger(MakeAnOrderCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("-----------Make An Order-----------");

        var serviceFactory = ServiceFactory.getInstance();

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        if (Objects.nonNull(title) && Objects.nonNull(description)) {
            try {
                OrderService orderService = serviceFactory.getOrderService();

                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("person");
                int userId = user.getId();

                //var order = orderService.getByUserId(userId);


                Order order;
                    order = new Order.OrderBuilderImpl()
                            .setTitle(title)
                            .setDescription(description)
                            .setUserId(userId)
                            .build();

                    orderService.add(order);

                    req.getSession().setAttribute("order", order);
                    log.info(order.toString());

                    log.info("successful add order");

                    return;
                }
            catch (ServiceException e) {
                System.out.println(e.getMessage());
                log.error(e.getMessage());
                req.setAttribute("cannot add order", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/makeOrder.jsp");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getMessage());
                log.error(e.getMessage());
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/makeOrder.jsp");
    }
}
