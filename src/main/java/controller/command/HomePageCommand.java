package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

public class HomePageCommand implements Command{
    Logger logger = Logger.getLogger(HomePageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("----------Home page----------");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        var orderService = serviceFactory.getOrderService();
        

    }
}
