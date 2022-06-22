package model.dao.constant;

public final class Constants {
    private Constants(){}
    public static final String INSERT_USER = "INSERT INTO USERS (email, passwd, name, level, role) VALUES (?,?,?,?,?)";
    public static final String INSERT_ORDER = "INSERT INTO ORDERS (cost, description, work_status, payment_status, user_id) VALUES (?,?,?,?,?)";

    public static final String SELECT_BY_USER_ID = "SELECT * FROM USERS WHERE id = ?";
    public static final String SELECT_BY_ORDER_ID = "SELECT * FROM ORDERS WHERE id = ?";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE id = ?";
    public static final String DELETE_ORDER = "DELETE FROM ORDERS WHERE id = ?";

    public static final String UPDATE_USER = "UPDATE USERS SET EMAIL = ?, PASSWD = ?, NAME = ?, ACCESS_LEVEL = ?, ROLE = ? WHERE ID = ?";
    public static final String UPDATE_ORDER = "UPDATE ORDERS SET ... WHERE ID = ?";

    public static final String ALL_USERS = "SELECT * FROM USERS";
    public static final String ALL_ORDERS = "SELECT * FROM ORDERS";

    public static final String SELECT_USER_BY_LOGIN_AND_PASSWD = "SELECT * FROM USERS WHERE email = ? AND passwd = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM USERS WHERE email = ?";

    public static final String ALL_ORDER_USER_ID = "SELECT * FROM ORDERS WHERE work_status = 1 and payment_status = 2 and user_id = ? and user_role = 2";
    public static final String ALL_ORDER_WORKER_ID = "SELECT * FROM ORDERS WHERE work_status = 1 and payment_status = 2 and user_id = ? and user_role = 3";
    public static final String ALL_ORDER_IN_PROCESS = "SELECT * FROM ORDERS WHERE work_status = 1 and payment_status = 2 and user_id = ?";
}
