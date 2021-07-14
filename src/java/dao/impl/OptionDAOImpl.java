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

import entity.Option;
import entity.Question;
import context.DBContext;
import dao.OptionDAO;
import dao.QuestionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements functions of the <code>OptionDAO</code> interface.<br>
 * This class contains methods to query select data from the table <code>Option</code>.<br>
 * There are get list of <code>Option</code> by Question Id, get all quantity of <code>UserType</code>, 
 * get <code>UserType</code> By ID.
 *
 * @author nangnnhe130538
 */
public class OptionDAOImpl extends DBContext implements OptionDAO {

    /**
     * Get options according to the id of the question in the required question list
     * 
     * @param arrQuestionId it is a <code>java.util.ArrayList</code> of <code>int</code>
     * @return a list of <code>Option</code> object. It is a <code>java.util.List</code> object
     * 
     * @throws Exception 
     */
    @Override
    public ArrayList<Option> getListOptionsByQuestionId(int[] arrQuestionId) throws Exception {
        QuestionDAO questionDAO = new QuestionDAOImpl();
        ArrayList listOption = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "SELECT o_id, O_content, q_id, status\n"
                    + "FROM     [Option] where q_id in (";
            for (int i = 0; i < arrQuestionId.length - 1; i++) {
                sql = sql + "?,";
            }
            sql = sql + "?)";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            for (int i = 0; i < arrQuestionId.length; i++) {
                statement.setInt(i + 1, arrQuestionId[i]);
            }
            rs = statement.executeQuery();
            while (rs.next()) {
                Option o = new Option();
                Question q = questionDAO.getQuestionById(rs.getInt("q_id"));
                o.setContent(rs.getString("O_content"));
                o.setId(rs.getInt("o_id"));
                o.setStatus(rs.getBoolean("status"));
                o.setQuestion(q);
                listOption.add(o);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return listOption;
    }

    /**
     * Get all Options from <code>Option</code> table by id of a question
     * 
     * @param questionId it is <code>int</code> number
     * @return a list of <code>Option</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    @Override
    public ArrayList<Option> getListOptions(int questionId) throws Exception {
        QuestionDAO dq = new QuestionDAOImpl();
        ArrayList listO = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        {
            try {
                String sql = "SELECT [o_id]\n"
                        + "      ,[O_content]\n"
                        + "      ,[q_id]\n"
                        + "      ,[status]\n"
                        + "  FROM [dbo].[Option] where q_id = ?";
                conn = getConnection();
                statement = conn.prepareStatement(sql);
                statement.setInt(1, questionId);
                rs = statement.executeQuery();
                while (rs.next()) {
                    Option option = new Option();
                    Question question = dq.getQuestionById(rs.getInt("q_id"));
                    option.setContent(rs.getString("O_content"));
                    option.setId(rs.getInt("o_id"));
                    option.setStatus(rs.getBoolean("status"));
                    option.setQuestion(question);
                    listO.add(option);
                }
            } catch (Exception ex) {
                throw ex;
            } finally {
                closeResultSet(rs);
                closePreparedStatement(statement);
                closeConnection(conn);
            }
        }
        return listO;
    }

    /**
     * Delete all of records options from <code>Option</code> table by question id in the database
     * 
     * @param questionId it is <code>int</code> number
     * @throws Exception 
     */
    @Override
    public void deleteOption(int questionId) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "DELETE FROM [dbo].[Option]\n"
                    + "      WHERE q_id = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, questionId);
            statement.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }

    /**
     * Insert a new record option to <code>Option</code> table in the database
     * 
     * @param option it is an <code>Option</code> object
     * @throws Exception 
     */
    @Override
    public void addOption(Option option) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "INSERT INTO [dbo].[Option]\n"
                    + "           ([O_content]\n"
                    + "           ,[q_id]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, option.getContent());
            statement.setInt(2, option.getQuestion().getId());
            statement.setBoolean(3, option.isStatus());
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
