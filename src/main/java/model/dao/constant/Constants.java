package model.dao.constant;

public final class Constants {
    private Constants(){}
    public static final String INSERT_USER = "INSERT INTO \"Person\" (\"name\", \"email\", \"passwd\", \"money\", \"role_access_level\") VALUES (?,?,?,?,?)";
    public static final String INSERT_ORDER = "INSERT INTO \"Order\" (\"title\", \"description\", \"cost\", \"payment_id\", \"work_status_id\", \"person_id\", \"employee_id\", \"date\") VALUES (?,?,?,?,?,?,?,?)";
    public static final String INSERT_REVIEW = "INSERT INTO \"Review\" (\"content\", \"rating\", \"date_work_done\", \"person_id\", \"order_id\") VALUES (?,?,?,?,?)";

    public static final String SELECT_BY_USER_ID = "SELECT * FROM \"Person\" WHERE \"id\" = ?";
    public static final String SELECT_BY_ORDER_ID = "SELECT * FROM \"Order\" WHERE \"id\" = ?";
    public static final String SELECT_BY_REVIEW_ID = "SELECT * FROM \"Review\" WHERE \"review_id\" = ?";
    public static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM \"Order\" WHERE \"person_id\" = ?";

    public static final String DELETE_USER = "DELETE FROM \"Person\" WHERE \"id\" = ?";
    public static final String DELETE_ORDER = "DELETE FROM \"Order\" WHERE \"id\" = ?";

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
    public static final String SELECT_MANAGER_NAME_TO_JSP = "SELECT FROM \"Person\" WHERE \"role_access_level\" = 4";


    /*
    * Constants for JSP pages
    */
    public static final String SELECT_USERS = "Select * from \"Person\" where \"role_access_level\" = 2";
}

