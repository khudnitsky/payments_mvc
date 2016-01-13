package by.pvt.khudnitsky.payments.dao.implementations;

import by.pvt.khudnitsky.payments.entities.Account;
import org.junit.*;

import java.sql.*;

/**
 * Copyright (c) 2016, Khudnitsky. All rights reserved.
 */
public class AccountDaoTest {
    private static Connection connection;
    @BeforeClass
    public static void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/payments",
                "root", "1208");
        if (connection == null) {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        try{
            if (connection != null){
                connection.close();
            }
        }
        catch (SQLException e){
            //TODO logger
        }
    }

    /**
     * Utility method, creates entity <b>Account</b>
     * @param id - account id
     * @param currency - account currency (BYR, USD, EUR)
     * @param amount - amount value
     * @param status - account status (1 - admin, 0 - client)
     * @return Account
     */
    private Account createAccountForTest(int id, String currency, double amount, int status){
        Account account = new Account();
        account.setId(id);
        account.setCurrency(currency);
        account.setAmount(amount);
        account.setStatus(status);
        return account;
    }

    @Test
    public void testGetById() throws Exception {
        Account expected = createAccountForTest(1, "ADMIN", 0, 0);
        Account actual = AccountDao.INSTANCE.getById(connection, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreate() throws Exception{
        Account expected = createAccountForTest(100, "TEST", 100, 0);
        AccountDao.INSTANCE.create(connection, expected);
        Account actual = AccountDao.INSTANCE.getById(connection, expected.getId());
        Assert.assertEquals(expected, actual);
        AccountDao.INSTANCE.deleteById(connection, expected.getId());
    }

    @Test
    public void testDeleteById() throws Exception{
        Account account = createAccountForTest(100, "TEST", 100, 0);
        AccountDao.INSTANCE.create(connection, account);
        AccountDao.INSTANCE.deleteById(connection, account.getId());
        Account actual = AccountDao.INSTANCE.getById(connection, account.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void testUpdateAmount() throws Exception {
        Account expected = createAccountForTest(100, "TEST", 100, 0);
        AccountDao.INSTANCE.create(connection, expected);
        double adding = 100;
        expected.setAmount(expected.getAmount() + adding);
        AccountDao.INSTANCE.updateAmount(connection, adding, expected.getId());
        Account actual = AccountDao.INSTANCE.getById(connection, expected.getId());
        Assert.assertEquals(expected, actual);
        AccountDao.INSTANCE.deleteById(connection, expected.getId());
    }
}