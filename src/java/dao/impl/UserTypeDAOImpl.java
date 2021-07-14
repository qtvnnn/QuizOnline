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

import entity.UserType;
import context.DBContext;
import dao.UserTypeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements functions of the <code>UserTypeDAO</code> interface.<br>
 * This class contains methods to query select data from the table <code>UserType</code>.<br>
 * There are get all quantity of <code>UserType</code>, get <code>UserType</code> By ID.
 *
 * @author nangnnhe130538
 */
public class UserTypeDAOImpl extends DBContext implements UserTypeDAO{
 
    /**
     * Get a list of all the number types of users in the database
     * 
     * @return a list of <code>UserType</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    @Override
    public ArrayList<UserType> getListUserType() throws Exception {
        ArrayList listType = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {

            String sql = "SELECT [t_id]\n"
                    + "      ,[Type]\n"
                    + "  FROM [dbo].[UserType]";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                UserType userType = new UserType();
                userType.setId(rs.getInt("t_id"));
                userType.setType(rs.getString("Type"));
                listType.add(userType);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return listType;
    }
    /**
     * Get a record of <code>UserType</code> object by id in the database
     * 
     * @param id. It is an <code>int</code>  number
     * @return userType it is an <code>UserType</code> object
     * @throws Exception 
     */
    @Override
    public UserType getUserTypeById(int id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            UserType userType = new UserType();
            String sql = "SELECT [t_id]\n"
                    + "      ,[Type]\n"
                    + "  FROM [dbo].[UserType]\n"
                    + "  where t_id = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                userType.setId(rs.getInt("t_id"));
                userType.setType(rs.getString("Type"));
                return userType;
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
    
}
