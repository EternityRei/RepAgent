package model.dao;

import model.enity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<Integer, User> {
    List<User> getAll(); //tested

    User getByLoginAndPass(String login, String password); //no point in testing
    User getByLogin(String email); //tested

    int getCountBlocked(List<User> person); //deprecated

    List<User> getAllEmpl(); //tested
}
