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
 * This class implements from class interface QuestionDAO.
 * This class contains method to query select data from the table Question.
 * There are get list question,count the number of questions,get question by id question,delete question by id, add new a question.
 * 
 * @author Dung
 */
public class QuestionDAOImpl extends DBContext implements QuestionDAO{

    /**
     * Get random questions according to the number of questions that the user needs
     * 
     * @param top. It is int number.
     * @return a list <code>Question</code> object
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
                question.setDate_Create(rs.getDate("date_Create"));
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
     * Get all questions in the database and paging
     * 
     * @param currentPage. It is int number.
     * @param numberQuesInPage. It is int number.
     * @return a list <code>Question</code> object
     * @throws Exception 
     */
    @Override
    public ArrayList<Question> getListQuestionsPadding(int currentPage, int numberQuesInPage) throws Exception {
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
                question.setDate_Create(rs.getDate("date_Create"));
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
     * Count the number of all questions in the database
     * 
     * @return count number 
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
     * Get a question in the database by question id
     * 
     * @param questionId. It is int number.
     * @return a <code>Question</code> object
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
                question.setDate_Create(rs.getDate("date_Create"));
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
     * Delete a question in the database by question id
     * 
     * @param q_id. It is int number.
     * @throws Exception 
     */
    @Override
    public void deleteQuestionById(int q_id) throws Exception {
        OptionDAO doo = new OptionDAOImpl();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            doo.deleteOption(q_id);
            String sql = "DELETE FROM [dbo].[Question]\n"
                    + "      WHERE q_id = ?";
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, q_id);
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
     * Add a new question to the database.
     * 
     * @param q <code>Question</code> object
     * @throws Exception 
     */
    @Override
    public void addQuestion(Question q) throws Exception {
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
            statement.setString(1, q.getContent());
            statement.setDate(2, q.getDate_Create());
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
     * Returns the last identifier generated for question table
     * 
     * @return id number
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
