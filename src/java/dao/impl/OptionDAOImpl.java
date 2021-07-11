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
 * This class implements from class interface OptionDAO.
 * This class contains method to query select data from the table Option.
 * There are get list option by id question, delete option and add new options.
 * 
 * @author Dung
 */
public class OptionDAOImpl extends DBContext implements OptionDAO {

    /**
     * Get options according to the id of the question in the required quantity list
     * 
     * @param arrN. It is an array int
     * @return a list <code>Option</code> objects.
     * 
     * @throws Exception 
     */
    @Override
    public ArrayList<Option> getListOptionsByQuestionId(int[] arrN) throws Exception {
        QuestionDAO questionDAO = new QuestionDAOImpl();
        ArrayList listOption = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "SELECT o_id, O_content, q_id, status\n"
                    + "FROM     [Option] where q_id in (";
            for (int i = 0; i < arrN.length - 1; i++) {
                sql = sql + "?,";
            }
            sql = sql + "?)";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            for (int i = 0; i < arrN.length; i++) {
                statement.setInt(i + 1, arrN[i]);
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
     * Get options according to the id of a question
     * 
     * @param questionId. it is a number int
     * @return a list <code>Option</code> objects.
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
     * Delete all options related to the question deleted
     * 
     * @param questionId. it is a number int
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
     * Add new options to the database
     * 
     * @param o. it is a Option
     * @throws Exception 
     */
    @Override
    public void addOption(Option o) throws Exception {
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
            statement.setString(1, o.getContent());
            statement.setInt(2, o.getQuestion().getId());
            statement.setBoolean(3, o.isStatus());
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
