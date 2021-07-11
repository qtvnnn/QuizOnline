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

import entity.UserType;
import context.DBContext;
import dao.UserTypeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface UserTypeDAO.
 * This class contains method to query select data from the table UserType.
 * There are get list UserType and get a UserType by id UserType.
 * 
 * @author Dung
 */
public class UserTypeDAOImpl extends DBContext implements UserTypeDAO{
 
    /**
     * Get a list of all types of users
     * 
     * @return a list <code>UserType</code> object.
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
     * Get UserType by UserType id.
     * 
     * @param id. It is a int number
     * @return <code>UserType</code> object
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
