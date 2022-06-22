package service.factory;

import model.enity.Model;
import model.exception.DatabaseException;
import model.exception.ServiceException;

import java.util.List;

public interface ItemService <K, T extends Model> {

    T getEntity(K id) throws DatabaseException, ServiceException, DatabaseException, ServiceException;

    boolean add(T entity) throws ServiceException;

    T update(T entity);

    boolean delete(K id);

    //List<T> getAllFree() throws ServiceException;

}