package model.dao.constant;

public final class Constants {
    private Constants(){}
    public static final String INSERT_USER = "INSERT INTO PERSON (email, passwd, name, level, role) VALUES (?,?,?,?,?)";
    public static final String INSERT_ORDER = "INSERT INTO ORDER (cost, description, work_status, payment_status, user_id) VALUES (?,?,?,?,?)";
    public static final String INSERT_REVIEW = "INSERT INTO REVIEW (reviewId, content, dateWorkDone, rating, userId, orderId) VALUES (?,?,?,?,?,?)";

    public static final String SELECT_BY_USER_ID = "SELECT * FROM PERSON WHERE id = ?";
    public static final String SELECT_BY_ORDER_ID = "SELECT * FROM ORDER WHERE id = ?";
    public static final String SELECT_BY_REVIEW_ID = "SELECT * FROM REVIEW WHERE reviewId = ?";

    public static final String DELETE_USER = "DELETE FROM PERSON WHERE id = ?";
    public static final String DELETE_ORDER = "DELETE FROM ORDER WHERE id = ?";

    public static final String UPDATE_USER = "UPDATE PERSON SET EMAIL = ?, PASSWD = ?, NAME = ?, ACCESS_LEVEL = ?, ROLE = ? WHERE ID = ?";
    public static final String UPDATE_ORDER = "UPDATE ORDER SET ... WHERE ID = ?";

    public static final String ALL_USERS = "SELECT * FROM PERSON";
    public static final String ALL_ORDERS = "SELECT * FROM ORDER";
    public static final String ALL_REVIEWS = "SELECT * FROM REVIEW";

    public static final String SELECT_USER_BY_LOGIN_AND_PASSWD = "SELECT * FROM PERSON WHERE email = ? AND passwd = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM PERSON WHERE email = ?";
    public static final String SELECT_REVIEW_BY_USER_ID = "SELECT * FROM REVIEW WHERE userId = ?";
    public static final String SELECT_REVIEW_BY_ORDER_ID = "SELECT * FROM REVIEW WHERE orderId = ?";

    public static final String ALL_ORDER_USER_ID = "SELECT * FROM ORDER WHERE work_status = 1 and payment_status = 2 and user_id = ? and user_role = 2";
    public static final String ALL_ORDER_WORKER_ID = "SELECT * FROM ORDER WHERE work_status = 1 and payment_status = 2 and user_id = ? and user_role = 3";
    public static final String ALL_ORDER_IN_PROCESS = "SELECT * FROM ORDER WHERE work_status = 1 and payment_status = 2 and user_id = ?";
}
