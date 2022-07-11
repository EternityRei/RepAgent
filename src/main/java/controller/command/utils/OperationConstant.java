package controller.command.utils;

public interface OperationConstant {
    String HOME = "/view/home";
    String MANAGER = "/view/manager";
    String LOGOUT = "/view/logout";
    String CUSTOMER = "/view/customer";
    String EMPLOYEE = "/view/employee";
    String LOGIN = "/view/login";
    String REGISTRATION = "/view/registration";

    /*
    * Manager Constants
    */
    String CUSTOMERS_LIST = "/view/managerPack/customersList";
    String ORDERS_LIST = "/view/managerPack/ordersList";
    String EMPLOYEES_LIST = "/view/managerPack/employeesList";
    String REVIEWS_LIST = "/view/managerPack/reviewsList";
    String ADD_EMPLOYEE = "/view/managerPack/addEmployee";
    String SUCCESS_ADD_EMPLOYEE = "/view/managerPack/successAddEmployee";

    String INCREASE_MONEY = "/view/managerPack/increaseMoney";

    String EDIT_ORDER = "/view/managerPack/editOrderData";

    /*
    * Customer Constants
    */
    String ORDERS_LIST_CUSTOMER = "/view/customerPack/ordersList";
    String MAKE_AN_ORDER = "/view/customerPack/makeOrder";
    String SUCCESS_MAKE_ORDER = "/view/customerPack/successMakeOrder";

    String LEAVE_REVIEW = "/view/customerPack/leaveReview";
    String CANNOT_LEAVE_REVIEW = "/view/customerPack/cannotLeaveReview";

    String EMPL_ORDERS_LIST = "/view/employeePack/ordersList";

    String EMPL_SET_WORK_STATUS = "/view/employeePack/editOrderData";

}
