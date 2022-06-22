package controller.command.factory;

import controller.command.*;
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
