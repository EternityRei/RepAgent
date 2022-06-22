package model.enity;

import model.builder.UserBuilder;

import java.util.Objects;

public class User extends Model{
    private String email;
    private String name;
    private String passwd;
    private int id;
    private int accessLevel;
    private int role;
    private float money;

    private User(UserBuilderImpl userBuilder){
        this.email = userBuilder.email;
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.passwd = userBuilder.passwd;
        this.role = userBuilder.role;
        this.money = userBuilder.money;
    }

    public static class UserBuilderImpl implements UserBuilder {

        private int id;
        private int accessLevel;
        private int role;
        private String name;
        private String email;
        private String passwd;
        private float money;

        @Override
        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public UserBuilder setPassword(String passwd) {
            this.passwd = passwd;
            return this;
        }

        @Override
        public UserBuilder setAccessLevel(int accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        @Override
        public UserBuilder setMoney(float money) {
            this.money = money;
            return this;
        }


        @Override
        public User build() {
            return new User(this);
        }
    }
    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId()
                && getAccessLevel() == user.getAccessLevel()
                && Float.compare(user.getMoney(), getMoney()) == 0
                && getEmail().equals(user.getEmail())
                && getName().equals(user.getName())
                && getPasswd().equals(user.getPasswd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getName(), getPasswd(),
                getId(), getAccessLevel(), getMoney());
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", id=" + id +
                ", accessLevel=" + accessLevel +
                ", money=" + money +
                '}';
    }
}
