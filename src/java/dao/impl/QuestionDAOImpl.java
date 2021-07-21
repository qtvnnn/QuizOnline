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

import entity.Question;
import context.DBContext;
import dao.OptionDAO;
import dao.QuestionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class implements functions of the <code>QuestionDAO</code> interface.<br>
 * This class contains methods to query select data from the table <code>Question</code>.<br>
 * There are get Top of <code>Question</code>, get all quantity of <code>Question</code>, get 
 * <code>Question</code> by Id, delete <code>Question</code> by Id, insert <code>Question</code>,
 * get Id of last <code>Question</code>
 *
 * @author nangnnhe130538
 */
public class QuestionDAOImpl extends DBContext implements QuestionDAO{

    /**
     * Get a number of the latest questions from <code>Question</code> table in the database
     * 
     * @param top it is an <code>int</code> number  
     * @return a list of <code>Question</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    @Override
    public ArrayList<Question> getListQuestionsTop(int top) throws Exception {
        ArrayList listQ = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "SELECT top (?) q_id, [content], date_Create\n"
                    + "FROM     Question order by NEWID ( );";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, top);
            rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("q_id"));
                question.setContent(rs.getString("content"));
                question.setDateCreate(rs.getDate("date_Create"));
                listQ.add(question);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return listQ;
    }

    /**
     * Get all questions from <code>Question</code> table in database and paging
     * 
     * @param currentPage it is an <code>int</code> number
     * @param numberQuesInPage it is an <code>int</code> number
     * @return a list of <code>Question</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    @Override
    public ArrayList<Question> getListQuestionsPaging(int currentPage, int numberQuesInPage) throws Exception {
        ArrayList listQ = new ArrayList();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "select * from \n"
                    + "   (select ROW_NUMBER() over(order by q_id) as Number, * \n"
                    + "                          from Question  ) as data where Number between (?) and (?)";

            int from = currentPage * numberQuesInPage - (numberQuesInPage - 1);
            int to = from + numberQuesInPage - 1;
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, from);
            statement.setInt(2, to);
            rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("q_id"));
                question.setContent(rs.getString("content"));
                question.setDateCreate(rs.getDate("date_Create"));
                listQ.add(question);
            }
        } catch (Exception ex) {

            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return listQ;
    }

    /**
     * Get all the number of questions records in the database
     * 
     * @return count it is an <code>int</code> number
     * @throws Exception 
     */
    @Override
    public int countQuestion() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        int count = 0;
        try {
            String sql = "SELECT COUNT(q_id) as numberQ\n"
                    + "FROM Question";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return count;
    }

    /**
     * Get a record question from <code>Question</code> table by id in the database
     * 
     * @param questionId it is an <code>int</code> number
     * @return question it is a <code>Question</code> object
     * @throws Exception 
     */
    @Override
    public Question getQuestionById(int questionId) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "SELECT q_id, [content], date_Create\n"
                    + "FROM     Question where q_id = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, questionId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("q_id"));
                question.setContent(rs.getString("content"));
                question.setDateCreate(rs.getDate("date_Create"));
                return question;
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
     * Delete a record question from <code>Question</code> table by id in the database
     * 
     * @param id it is <code>int</code> number
     * @throws Exception 
     */
    @Override
    public void deleteQuestionById(int id) throws Exception {
        OptionDAO doo = new OptionDAOImpl();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            doo.deleteOption(id);
            String sql = "DELETE FROM [dbo].[Question]\n"
                    + "      WHERE q_id = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }

    /**
     * Insert a new record question to <code>Question</code> table in the database
     * 
     * @param question it is an <code>Question</code> object
     * @throws Exception 
     */
    @Override
    public void addQuestion(Question question) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            String sql = "INSERT INTO [dbo].[Question]\n"
                    + "           ([content]\n"
                    + "           ,[date_Create])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, question.getContent());
            statement.setDate(2, question.getDateCreate());
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
     * Returns the last Question id generated from <code>Question</code> table in the database
     * 
     * @return id it is <code>int</code> number
     * @throws Exception 
     */
    @Override
    public int getIdQuestion() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        int id = 0;
        try {
            String sql = "SELECT IDENT_CURRENT('Question') AS Current_Identity";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("Current_Identity");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return id;
    }
    
}
