package service.imlp;

import model.dao.UserDAO;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.impl.UserServiceImpl;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    public UserDAO userDAOMock;
    @InjectMocks
    public UserServiceImpl userServiceTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getByLogin() {
        when(userDAOMock.getByLogin(any())).thenReturn(new User());
        User result = userServiceTest.getByLogin("test@gmail.com");
        assertEquals(new User.UserBuilderImpl()
                .setId(0)
                .setName(null)
                .setEmail(null)
                .setPassword(null)
                .setMoney(0)
                .setAccessLevel(0)
                .build(), result);
    }

    @Test
    void getEntity() throws DatabaseException, ServiceException {
        when(userDAOMock.getById(any())).thenReturn(new User());
        User result = userServiceTest.getEntity(0);
        assertEquals(new User.UserBuilderImpl()
                .setId(0)
                .setName(null)
                .setEmail(null)
                .setPassword(null)
                .setMoney(0)
                .setAccessLevel(0)
                .build(), result);
    }

    @Test
    void add() throws DatabaseException, ServiceException, SQLException, NamingException {
        when(userDAOMock.add(any())).thenReturn(true);
        boolean result = userServiceTest.add(new User.UserBuilderImpl()
                .setId(0)
                .setName(null)
                .setEmail(null)
                .setPassword(null)
                .setMoney(0)
                .setAccessLevel(0)
                .build());
        assertTrue(result);
    }

    @Test
    void update() {
        when(userDAOMock.updateEntity(any())).thenReturn(new User());
        User result = userServiceTest.update(new User.UserBuilderImpl()
                .setId(0)
                .setName(null)
                .setEmail(null)
                .setPassword(null)
                .setMoney(0)
                .setAccessLevel(0)
                .build());
        assertEquals(new User.UserBuilderImpl()
                .setId(0)
                .setName(null)
                .setEmail(null)
                .setPassword(null)
                .setMoney(0)
                .setAccessLevel(0)
                .build(), result);
    }

    @Test
    void delete() throws SQLException, NamingException {
        when(userDAOMock.deleteEntity(any())).thenReturn(true);
        boolean result = userServiceTest.delete(0);
        assertTrue(result);
    }

    @Test
    void getAll() throws ServiceException {
        when(userDAOMock.getAll()).thenReturn(Collections.singletonList(new User()));
        List<User> result = userServiceTest.getAllUsers();
        assertFalse(result.isEmpty());
    }

    @Test
    void getAllEmpl() throws ServiceException {
        when(userDAOMock.getAllEmpl()).thenReturn(Collections.singletonList(new User()));
        List<User> result = userServiceTest.getAllEmployees();
        assertFalse(result.isEmpty());
    }

}
