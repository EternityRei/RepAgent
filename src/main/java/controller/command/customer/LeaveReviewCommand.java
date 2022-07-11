package controller.command.customer;

import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.Review;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LeaveReviewCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(LeaveReviewCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("------------Leave Review Command------------");

        var serviceFactory = ServiceFactory.getInstance();

        String content = req.getParameter("content");
        String btn = req.getParameter("btn");
        String rating = req.getParameter("rate");

        if(Objects.nonNull(content) && Objects.nonNull(btn) && Objects.nonNull(rating)){
            try{
                var reviewService = serviceFactory.getReviewService();

                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("person");
                int userId = user.getId();
                int orderId = Integer.parseInt(req.getParameter("id"));

                Review review = new Review.ReviewBuilderImpl()
                        .setContent(content)
                        .setRating(Float.parseFloat(rating))
                        .setUserId(userId)
                        .setOrderId(orderId)
                        .build();

                reviewService.add(review);

                req.getSession().setAttribute("review", review);

                log.info("successful add review");

                return;

            } catch (ServiceException e) {
                log.error(e.getMessage());
                req.setAttribute("cannot add order", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/leaveReview.jsp");
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/leaveReview.jsp");
    }
}
