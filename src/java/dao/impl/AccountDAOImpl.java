/**
 * Copyright (C) 2021, FPT University
 * J3.L.P0001
 * Online Quiz.
 *
 * Record of change:
 * DATE         VERSION         Author
 * 2021-02-23   1.0             DungHT
 *
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
 * This class implements from class interface AccountDAO.
 * This class contains method to query select data from the table Account.
 There are get Account by username,check mail exist and add account new account.
 * 
 * @author Dung
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    /**
     * Search and retrieve account data according to the username entered by the user
     * 
     * @param user. It is account <code>java.lang.String</code>
     * @return account <code>Account</code> object
     * @throws Exception 
     */
    @Override
    public Account getAccountByUser(String user) throws Exception {
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
            statement.setString(1, user);
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
     * Check to see if the email address when registered user already exists in the database
     * 
     * @param email. It is account <code>java.lang.String</code>
     * @return boolean
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
     * Add account new user account to the database
     * 
     * @param a. It is account Account
     * @throws Exception 
     */
    @Override
    public void addAcount(Account a) throws Exception {
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
            statement.setString(1, a.getUserName());
            statement.setString(2, a.getPassword());
            statement.setString(3, a.getEmail());
            statement.setInt(4, a.getUserType().getId());
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
