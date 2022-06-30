package controller.command.factory;

import controller.command.*;
import controller.command.admin.*;
import controller.command.customer.MakeAnOrderCommand;
import controller.command.customer.OrdersListCustomerCommand;
import controller.command.customer.SuccessMakeOrderCommand;
import controller.command.utils.OperationConstant;
import model.exception.NotFoundOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
         private static final Map<String, Command> commandMap = new HashMap<>();

        static {
                commandMap.put(OperationConstant.LOGIN, new LoginCommand());
                commandMap.put(OperationConstant.REGISTRATION, new RegistrationCommand());
                commandMap.put(OperationConstant.LOGOUT, new LogoutCommand());
                commandMap.put(OperationConstant.MANAGER, new ManagerPageCommand());
                commandMap.put(OperationConstant.CUSTOMER, new CustomerPageCommand());
                commandMap.put(OperationConstant.EMPLOYEE, new EmployeePageCommand());
                commandMap.put(OperationConstant.CUSTOMERS_LIST, new CustomersListCommand());
                commandMap.put(OperationConstant.ORDERS_LIST, new OrdersListCommand());
                commandMap.put(OperationConstant.EMPLOYEES_LIST, new EmloyeesListCommand());
                commandMap.put(OperationConstant.REVIEWS_LIST, new ReviewsListCommand());
                commandMap.put(OperationConstant.ADD_EMPLOYEE, new AddEmployeeCommand());
                commandMap.put(OperationConstant.MAKE_AN_ORDER, new MakeAnOrderCommand());
                commandMap.put(OperationConstant.ORDERS_LIST_CUSTOMER, new OrdersListCustomerCommand());
                commandMap.put(OperationConstant.SUCCESS_ADD_EMPLOYEE, new SuccessAddEmployeeCommand());
                commandMap.put(OperationConstant.SUCCESS_MAKE_ORDER, new SuccessMakeOrderCommand());
                commandMap.put(OperationConstant.INCREASE_MONEY, new IncreaseMoneyCommand());
                //commandMap.put(OperationConstant.HOME, new HomePageCommand());
        }


        public static Command getCommand(String url) throws NotFoundOperationException {
                Command command = commandMap.get(url);
                if (command == null) {
                        throw new NotFoundOperationException();
                }
                return command;
        }
}
