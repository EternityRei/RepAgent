package controller.command.utils;

import model.enity.Order;
import model.enity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Utils {

    private static final Logger log = Logger.getLogger(Utils.class);

    private Utils() {}

    public static void sortPeople(HttpServletRequest req, List<User> list){
        list.sort(new User.IdComparator());
        log.info("Sorting users by id");
    }

    public static void sortOrders(List<Order> list){
        list.sort(new Order.IdComparator());
        log.info("Sorting orders by id");
    }
}
