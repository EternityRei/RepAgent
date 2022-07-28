package service.imlp;

import model.dao.OrderDAO;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.impl.OrderServiceImpl;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    @Mock
    OrderDAO orderDAOMock;
    @InjectMocks
    OrderServiceImpl orderServiceTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getEntity() throws DatabaseException, ServiceException {
        when(orderDAOMock.getById(any())).thenReturn(new Order());
        Order result = orderServiceTest.getEntity(0);
        assertEquals(new Order.OrderBuilderImpl()
                .setId(0)
                .setTitle(null)
                .setDescription(null)
                .setPrice(0)
                .setPaymentStatus(0)
                .setWorkStatus(0)
                .setUserId(0)
                .setEmployeeId(0)
                .setDate(null)
                .build(), result);
    }

    @Test
    void add() throws DatabaseException, ServiceException, SQLException, NamingException {
        when(orderDAOMock.add(any())).thenReturn(true);
        boolean result = orderServiceTest.add(new Order.OrderBuilderImpl()
                .setId(0)
                .setTitle(null)
                .setDescription(null)
                .setPrice(0)
                .setPaymentStatus(0)
                .setWorkStatus(0)
                .setUserId(0)
                .setEmployeeId(0)
                .setDate(null)
                .build());
        assertTrue(result);
    }

    @Test
    void update() {
        when(orderDAOMock.updateEntity(any())).thenReturn(new Order());
        Order result = orderServiceTest.update(new Order.OrderBuilderImpl()
                .setId(0)
                .setTitle(null)
                .setDescription(null)
                .setPrice(0)
                .setPaymentStatus(0)
                .setWorkStatus(0)
                .setUserId(0)
                .setEmployeeId(0)
                .setDate(null)
                .build());
        assertEquals(new Order.OrderBuilderImpl()
                .setId(0)
                .setTitle(null)
                .setDescription(null)
                .setPrice(0)
                .setPaymentStatus(0)
                .setWorkStatus(0)
                .setUserId(0)
                .setEmployeeId(0)
                .setDate(null)
                .build(), result);
    }

    @Test
    void delete() throws SQLException, NamingException {
        when(orderDAOMock.deleteEntity(any())).thenReturn(true);
        boolean result = orderServiceTest.delete(0);
        assertTrue(result);
    }

    @Test
    void getAll() throws ServiceException {
        when(orderDAOMock.getAll()).thenReturn(Collections.singletonList(new Order()));
        List<Order> result = orderServiceTest.getAll();
        assertFalse(result.isEmpty());
    }
}
