package model.builder;

import model.enity.User;

public interface UserBuilder {
    UserBuilder setId(int id);
    UserBuilder setName(String name);
    UserBuilder setEmail(String email);
    UserBuilder setPassword(String password);
    UserBuilder setAccessLevel(int accessLevel);
    UserBuilder setMoney(float money);
    User build();
}
