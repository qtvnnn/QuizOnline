/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
 */
package dao.impl;

import entity.Account;
import entity.UserType;
import context.DBContext;
import dao.AccountDAO;
import dao.UserTypeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements functions of the <code>AccountDAO</code> interface.<br>
 * This class contains methods to query select data from the table <code>Account</code>.<br>
 * There are get <code>Account</code> by username, check email exists, add <code>Account</code>.
 *
 * @author nangnnhe130538
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    /**
     * Get a record account from <code>Account</code> table by username in the database
     * 
     * @param userName it is a <code>java.lang.String</code>
     * @return account it is an <code>Option</code> object
     * @throws Exception 
     */
    @Override
    public Account getAccountByUser(String userName) throws Exception {
        UserTypeDAO userTypeDAO = new UserTypeDAOImpl();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;

        try {
            String sql = "SELECT Account.UserName, Account.PassWord, Account.Email, UserType.Type, UserType.t_id\n"
                    + "FROM     Account INNER JOIN\n"
                    + "                  UserType ON Account.t_id = UserType.t_id where Account.UserName = ?";

            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, userName);
            rs = statement.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUserName(rs.getString("UserName"));
                account.setPassword(rs.getString("PassWord"));
                account.setEmail(rs.getString("Email"));
                UserType userType = userTypeDAO.getUserTypeById(rs.getInt("t_id"));
                account.setUserType(userType);
                return account;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Check the email address when user registered already exists in the database
     * 
     * @param email it is a <code>java.lang.String</code>
     * @return true/false it is a <code>boolean</code>
     * @throws Exception 
     */
    @Override
    public boolean checkEmail(String email) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "select Email from account\n"
                    + "where email = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            rs = statement.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return true;
    }

    /**
     * Insert a new record account to <code>Account</code> table in the database
     * 
     * @param account it is an <code>Option</code> object
     * @throws Exception 
     */
    @Override
    public void addAcount(Account account) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([UserName]\n"
                    + "           ,[PassWord]\n"
                    + "           ,[Email]\n"
                    + "           ,[t_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, account.getUserName());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setInt(4, account.getUserType().getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }

}
