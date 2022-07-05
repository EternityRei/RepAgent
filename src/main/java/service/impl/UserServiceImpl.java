package service.impl;

import model.dao.UserDAO;
import model.dao.factory.DAOFactory;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.InvalidDataException;
import model.exception.NotFoundUserException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.UserService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    private final DAOFactory DaoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = DaoFactory.getUserDAO();


    @Override
    public User getByLoginAndPasswd(String login, String password) throws NotFoundUserException, InvalidDataException {
        User user = userDAO.getByLoginAndPass(login, password);
        if(Objects.isNull(user)){
            throw new NotFoundUserException();
        }
        return user;
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public int getAllBlocked() {
        return userDAO.getCountBlocked(userDAO.getAll());
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> all = userDAO.getAll();

        return all.stream()
                .filter(p -> p.getAccessLevel() == 2)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllEmployees() {
        List<User> allEmpl = userDAO.getAllEmpl();

        return allEmpl.stream()
                .filter(p -> p.getAccessLevel() == 3)
                .collect(Collectors.toList());
    }

    @Override
    public User getEntity(Integer id) throws DatabaseException, ServiceException {
        try{
            User user = userDAO.getById(id);
            return user;
        } catch (DatabaseException e){
            log.error(e);
            throw new ServiceException("Cannot get user in service", e);
        }
    }

    @Override
    public boolean add(User entity) throws ServiceException {
        try {
            userDAO.add(entity);
            return true;
        } catch (DatabaseException | NamingException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User update(User entity) {
        return userDAO.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            flag = userDAO.deleteEntity(id);
        } catch (SQLException | NamingException e) {
            log.error(e.getMessage());
        }
        return flag;
    }
}
