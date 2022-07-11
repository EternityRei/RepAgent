package model.dao.factory;

import model.dao.*;

public abstract class DAOFactory {

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseDAOFactory();
        }
        return instance;
    }

    public abstract UserDAO getUserDAO();

    public abstract OrderDAO getOrderDAO();

    public abstract ReviewDAO getReviewDAO();

}