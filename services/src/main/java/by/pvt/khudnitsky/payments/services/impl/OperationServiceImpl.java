package by.pvt.khudnitsky.payments.services.impl;

import by.pvt.khudnitsky.payments.dao.impl.OperationDaoImpl;
import by.pvt.khudnitsky.payments.entities.Operation;
import by.pvt.khudnitsky.payments.services.AbsractService;
import by.pvt.khudnitsky.payments.managers.PoolManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (c) 2016, Khudnitsky. All rights reserved.
 */
public class OperationServiceImpl extends AbsractService<Operation> {
    private static OperationServiceImpl instance;

    private OperationServiceImpl(){}

    public static synchronized OperationServiceImpl getInstance(){
        if(instance == null){
            instance = new OperationServiceImpl();
        }
        return instance;
    }

    /**
     * Calls Dao add() method
     *
     * @param entity - object of derived class Entity
     * @throws SQLException
     */
    @Override
    public void add(Operation entity) throws SQLException {
        Connection connection = PoolManager.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            OperationDaoImpl.getInstance().add(connection, entity);
            connection.commit();
        }
        catch(SQLException e){
            connection.rollback();
        }
        PoolManager.getInstance().releaseConnection(connection);
    }

    /**
     * Calls Dao getAll() method
     *
     * @return list of objects of derived class Entity
     * @throws SQLException
     */
    @Override
    public List<Operation> getAll() throws SQLException {
        List<Operation> operations = null;
        Connection connection = PoolManager.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            operations = OperationDaoImpl.getInstance().getAll(connection);
            connection.commit();
        }
        catch(SQLException e){
            connection.rollback();
        }
        PoolManager.getInstance().releaseConnection(connection);
        return operations;
    }

    /**
     * Calls Dao getById() method
     *
     * @param id - id of entity
     * @return object of derived class Entity
     * @throws SQLException
     */
    @Override
    public Operation getById(int id) throws SQLException {
        return null;
    }

    /**
     * Calls Dao update() method
     *
     * @param entity - object of derived class Entity
     * @throws SQLException
     */
    @Override
    public void update(Operation entity) throws SQLException {

    }

    /**
     * Calls Dao delete() method
     *
     * @param id - id of entity
     * @throws SQLException
     */
    @Override
    public void delete(int id) throws SQLException {

    }
}
