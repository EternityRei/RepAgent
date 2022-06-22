package model.dao;

import model.enity.Model;
import model.exception.DatabaseException;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface CrudDAO<K, T extends Model> {

    boolean add(T entity) throws DatabaseException, SQLException, NamingException;

    T getById(K id) throws DatabaseException;

    boolean deleteEntity(K id) throws NamingException, SQLException;

    T updateEntity(T entity);


}
