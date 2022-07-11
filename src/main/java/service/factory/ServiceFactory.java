package service.factory;

import org.apache.log4j.Logger;
import service.OrderService;
import service.ReviewService;
import service.UserService;
import service.impl.OrderServiceImpl;
import service.impl.ReviewServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
    private  static Logger log = Logger.getLogger(ServiceFactory.class);

    private UserService userService = new UserServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private ReviewService reviewService = new ReviewServiceImpl();

    private static ServiceFactory instance;

    public static ServiceFactory getInstance() {
        if (instance == null) {
            log.info("-------------Create ServiceFactory-------------");
            instance = new ServiceFactory();
        }
        return instance;
    }

    private ServiceFactory() {}

    public UserService getUserService(){
        return userService;
    }

    public OrderService getOrderService(){
        return orderService;
    }
    public ReviewService getReviewService(){
        return reviewService;
    }
}
