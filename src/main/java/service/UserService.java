package service;

import model.enity.User;
import model.exception.InvalidDataException;
import model.exception.NotFoundUserException;
import model.exception.ServiceException;
import service.factory.ItemService;

import java.util.List;

public interface UserService extends ItemService<Integer, User> {
    User getByLoginAndPasswd(String login, String password) throws NotFoundUserException, InvalidDataException;

    User getByLogin(String login);

    int getAllBlocked();

    List<User> getAllUsers() throws ServiceException;

    List<User> getAllEmployees();

}
