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
package dao;

import entity.Question;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Question objects in the database.
 * 
 * @author Dung
 */
public interface QuestionDAO {
    /**
     * Get random questions according to the number of questions that the user needs
     * 
     * @param top. It is int number.
     * @return a list <code>Question</code> object
     * @throws Exception 
     */
    public ArrayList<Question> getListQuestionsTop(int top) throws Exception;
    /**
     * Get all questions in the database and paging
     * 
     * @param currentPage. It is int number.
     * @param numberQuesInPage. It is int number.
     * @return a list <code>Question</code> object
     * @throws Exception 
     */
    public ArrayList<Question> getListQuestionsPadding(int currentPage, int numberQuesInPage) throws Exception;
    /**
     * Count the number of all questions in the database
     * 
     * @return count
     * @throws Exception 
     */
    public int countQuestion() throws Exception;
    /**
     * Get a question in the database by question id
     * 
     * @param questionId. It is int number.
     * @return a <code>Question</code> object
     * @throws Exception 
     */
    public Question getQuestionById(int questionId) throws Exception;
    /**
     * Delete a question in the database by question id
     * 
     * @param questionId. It is int number.
     * @throws Exception 
     */
    public void deleteQuestionById(int questionId) throws Exception;
    /**
     * Add a new question to the database.
     * 
     * @param q <code>Question</code> object
     * @throws Exception 
     */
    public void addQuestion(Question q) throws Exception;
    /**
     * Returns the last identifier generated for question table
     * 
     * @return id number
     * @throws Exception 
     */
    public int getIdQuestion() throws Exception;
}
