package model.dao.implementation;

import model.dao.UserDAO;
import model.dao.connection.Connector;
import model.dao.constant.Constants;
import model.enity.User;
import model.exception.DatabaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabaseDAO implements UserDAO {

    private static Logger log = Logger.getLogger(UserDatabaseDAO.class);

    public UserDatabaseDAO(){}

    @Override
    public boolean add(User user) throws DatabaseException, SQLException, NamingException {
        Connection con = Connector.getInstance().getConnection();
        con.setAutoCommit(false);
        try(PreparedStatement pstmt = con.prepareStatement(Constants.INSERT_USER)){
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPasswd());
            pstmt.setFloat(4, user.getMoney());
            pstmt.setInt(5, user.getAccessLevel());
            pstmt.execute();
            log.info("User was added successful");
            con.commit();
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            con.rollback();
            throw new DatabaseException("Cannot add person", e);
        }
    }

    @Override
    public User getById(Integer id) throws DatabaseException {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_BY_USER_ID)){
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            log.info("successful getById user");
            return new User.UserBuilderImpl()
                    .setId(id)
                    .setName(resultSet.getString("name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("passwd"))
                    .setAccessLevel(resultSet.getInt("role_access_level"))
                    .setMoney(resultSet.getFloat("money"))
                    .build();

        } catch (SQLException e){
            throw new DatabaseException(String.format("Cannot get person by id = %d", id), e);
        }
    }

    @Override
    public boolean deleteEntity(Integer id) throws NamingException, SQLException {
        Connection con = Connector.getInstance().getConnection();
        try(PreparedStatement pstmt = con.prepareStatement(Constants.DELETE_USER)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            log.info("User was deleted successful");
            con.commit();
            return true;
        } catch (SQLException e){
            con.rollback();
            throw new RuntimeException("Cannot delete user ", e);
        }
    }

    @Override
    public User updateEntity(User user) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.UPDATE_USER)){
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPasswd());
            pstmt.setString(3, user.getName());
            pstmt.setInt(4, user.getAccessLevel());
            pstmt.setInt(5, user.getId());
            pstmt.setFloat(6, user.getMoney());
            pstmt.executeUpdate();
            log.info("User was updated successful");
            return user;
        } catch (SQLException e){
            throw new RuntimeException("Cannot update user ", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> outputUsers = new ArrayList<>();
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.ALL_USERS)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPasswd(resultSet.getString(4));
                user.setMoney(resultSet.getFloat(5));
                user.setAccessLevel(resultSet.getInt(6));
                outputUsers.add(user);
            }
            log.info("All users were found successful");
            return outputUsers;
        } catch (SQLException e){
            throw new RuntimeException("Cannot find all users ", e);
        }
    }

    @Override
    public User getByLoginAndPass(String login, String password) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_USER_BY_LOGIN_AND_PASSWD)){
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            User user = null;
            if (resultSet.next()){
                user = new User.UserBuilderImpl()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("passwd"))
                        .setAccessLevel(resultSet.getInt("role_access_level"))
                        .setMoney(resultSet.getFloat("money"))
                        .build();
            }
            log.info("User was found successful by login and password");
            return user;
        } catch (SQLException e){
            throw new RuntimeException("Cannot find user by login and password ", e);
        }
    }

    @Override
    public User getByLogin(String email) {
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_USER_BY_LOGIN)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            User person = null;
            if (resultSet.next()) {
                person = new User.UserBuilderImpl()
                        .setId(resultSet.getInt("id"))
                        .setName(resultSet.getString("name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("passwd"))
                        .setAccessLevel(resultSet.getInt("role_access_level"))
                        .build();
            }
            log.info("successful getByLogin person");
            return person;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Cannot getByLogin person", e);
        }
    }

    @Override
    public int getCountBlocked(List<User> person) {
        return 0;
    }

}
