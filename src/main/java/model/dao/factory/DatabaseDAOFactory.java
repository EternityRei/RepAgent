package model.dao.factory;

import model.dao.OrderDAO;
import model.dao.UserDAO;
import model.dao.implementation.OrderDatabaseDAO;
import model.dao.implementation.UserDatabaseDAO;
import org.apache.log4j.Logger;

public class DatabaseDAOFactory extends DAOFactory {
    private static Logger log = Logger.getLogger(DatabaseDAOFactory.class);

    private UserDAO userDAO = new UserDatabaseDAO();
    private OrderDAO orderDAO = new OrderDatabaseDAO();


    @Override
    public UserDAO getUserDAO() {
        log.info("Get UserDatabaseDAO");
        return userDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        log.info("Get OrderDatabaseDAO");
        return orderDAO;
    }
}
