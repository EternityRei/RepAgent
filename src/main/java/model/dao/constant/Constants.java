package model.dao.constant;

public final class Constants {
    private Constants(){}
    public static final String INSERT_USER = "INSERT INTO \"Person\" (\"name\", \"email\", \"passwd\", \"money\", \"role_access_level\") VALUES (?,?,?,?,?)";
    public static final String INSERT_ORDER = "INSERT INTO \"ORDER\" (\"title\", \"description\", \"cost\", \"payment_id\", \"work_status_id\", \"person_id\", \"person_role_access_level\") VALUES (?,?,?,?,?,?,?)";
    public static final String INSERT_REVIEW = "INSERT INTO \"REVIEW\" (\"content\", \"rating\", \"date_work_done\", \"person_id\", \"order_id\") VALUES (?,?,?,?,?)";

    public static final String SELECT_BY_USER_ID = "SELECT * FROM \"Person\" WHERE \"id\" = ?";
    public static final String SELECT_BY_ORDER_ID = "SELECT * FROM \"ORDER\" WHERE \"id\" = ?";
    public static final String SELECT_BY_REVIEW_ID = "SELECT * FROM \"REVIEW\" WHERE \"review_id\" = ?";

    public static final String DELETE_USER = "DELETE FROM \"Person\" WHERE \"id\" = ?";
    public static final String DELETE_ORDER = "DELETE FROM \"ORDER\" WHERE \"id\" = ?";

    public static final String UPDATE_USER = "UPDATE \"Person\" SET \"name\" = ?, \"email\" = ?, \"passwd\" = ?, \"money\" = ?, \"role_access_level\" = ? WHERE \"id\" = ?";
    public static final String UPDATE_ORDER = "UPDATE \"Order\" SET \"title\" = ?, \"description\" = ?, \"cost\" = ?, \"payment_id\" = ?, \"work_status_id\" = ?, \"person_id\", \"person_role_access_level\" WHERE \"id\" = ?";

    public static final String ALL_USERS = "SELECT * FROM \"Person\"";
    public static final String ALL_ORDERS = "SELECT * FROM \"Order\"";
    public static final String ALL_REVIEWS = "SELECT * FROM \"Review\"";

    public static final String SELECT_USER_BY_LOGIN_AND_PASSWD = "SELECT * FROM \"Person\" WHERE \"email\" = ? AND \"passwd\" = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM \"Person\" WHERE \"email\" = ?";
    public static final String SELECT_REVIEW_BY_USER_ID = "SELECT * FROM \"Review\" WHERE \"person_id\" = ?";
    public static final String SELECT_REVIEW_BY_ORDER_ID = "SELECT * FROM \"Review\" WHERE \"order_id\" = ?";
    public static final String SELECT_REVIEW_BY_USER_AND_ORDER_ID = "SELECT * FROM \"Review\" WHERE \"person_id\" = ? AND \"order_id\" = ?";

    public static final String ALL_ORDER_USER_ID = "SELECT * FROM \"Order\" WHERE \"work_status_id\" = 1 and \"payment_id = 2\" and \"person_id\" = ? AND \"person_role_access_level\" = 2";
    public static final String ALL_ORDER_WORKER_ID = "SELECT * FROM \"Order\" WHERE \"work_status_id\" = 1 and \"payment_id = 2\" and \"person_id\" = ? and \"person_role_access_level\" = 3";
    public static final String ALL_ORDER_IN_PROCESS = "SELECT * FROM \"Order\" WHERE \"work_status_id\" = 1 and \"payment_id = 2\" and \"person_id\" = ?";
}
