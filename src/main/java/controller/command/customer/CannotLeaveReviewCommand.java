package controller.command.customer;

import controller.command.utils.CommandUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CannotLeaveReviewCommand implements controller.command.Command {

    private static final Logger log = Logger.getLogger(CannotLeaveReviewCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        log.info("-------------Cannot Leave Review Command-------------");
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/customerPack/cannotLeaveReview.jsp");
    }
}
