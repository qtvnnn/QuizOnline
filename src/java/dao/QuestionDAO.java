/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
 */
package dao;

import entity.Question;
import java.util.ArrayList;

/**
 * The interface of <code>QuestionDAOImpl</code> class defines methods to help us 
 * manipulate <code>Question</code> object from <code>Question</code> tables in database.
 *
 * @author nangnnhe130538
 */
public interface QuestionDAO {
    /**
     * Get a number of the latest questions from <code>Question</code> table in the database
     * 
     * @param top it is an <code>int</code> number  
     * @return a list of <code>Question</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    public ArrayList<Question> getListQuestionsTop(int top) throws Exception;
    /**
     * Get all questions from <code>Question</code> table in database and paging
     * 
     * @param currentPage it is an<code>int</code> number
     * @param numberQuesInPage it is an<code>int</code> number
     * @return a list of <code>Question</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    public ArrayList<Question> getListQuestionsPaging(int currentPage, int numberQuesInPage) throws Exception;
    /**
     * Get all the number of questions records in the database
     * 
     * @return count it is an<code>int</code> number
     * @throws Exception 
     */
    public int countQuestion() throws Exception;
    /**
     * Get a record question from <code>Question</code> table by id in the database
     * 
     * @param questionId it is an<code>int</code> number
     * @return question it is a <code>Question</code> object
     * @throws Exception 
     */
    public Question getQuestionById(int questionId) throws Exception;
    /**
     * Delete a record question from <code>Question</code> table by id in the database
     * 
     * @param questionId it is an<code>int</code> number
     * @throws Exception 
     */
    public void deleteQuestionById(int questionId) throws Exception;
    /**
     * Insert a new record question to <code>Question</code> table in the database
     * 
     * @param question it is an <code>Question</code> object
     * @throws Exception 
     */
    public void addQuestion(Question question) throws Exception;
    /**
     * Returns the last Question id generated from <code>Question</code> table in the database
     * 
     * @return id it is an<code>int</code> number
     * @throws Exception 
     */
    public int getIdQuestion() throws Exception;
}
