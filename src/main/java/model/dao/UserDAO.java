package model.dao;

import model.enity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<Integer, User> {
    List<User> getAll();

    User getByLoginAndPass(String login, String password);

    User getByLogin(String email);

    int getCountBlocked(List<User> person);
}
