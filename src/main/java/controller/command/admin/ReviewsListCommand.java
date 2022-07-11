package controller.command.admin;

import controller.command.utils.CommandUtil;
import model.enity.Order;
import model.enity.Review;
import model.enity.User;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReviewsListCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(ReviewsListCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("--------------Reviews List Command--------------");

        var serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        var userService = serviceFactory.getUserService();
        var reviewService = serviceFactory.getReviewService();

        try{
            List<Review> reviewList = reviewService.getAll();
            req.setAttribute("reviews", reviewList);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/managerPack/reviewsList.jsp");
        } catch (Exception e){
            log.error("Something went wrong " + e);
        }
    }
}
