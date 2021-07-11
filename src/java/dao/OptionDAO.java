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

import entity.Option;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Option objects in the database.
 * 
 * @author Dung
 */
public interface OptionDAO {
    /**
     * Get options according to the id of the question in the required quantity list
     * 
     * @param arrN. It is an array int
     * @return a list <code>Option</code> objects.
     * 
     * @throws Exception 
     */
    public ArrayList<Option> getListOptionsByQuestionId(int[] arrN) throws Exception;
    /**
     * Get options according to the id of a question
     * 
     * @param questionId. it is a number int
     * @return a list <code>Option</code> objects.
     * @throws Exception 
     */
    public ArrayList<Option> getListOptions(int questionId) throws Exception;
    /**
     * Delete all options related to the question deleted
     * 
     * @param quesionId. it is a number int
     * @throws Exception 
     */
    public void deleteOption(int quesionId) throws Exception;
    /**
     * Add new options to the database
     * 
     * @param o. it is a Option
     * @throws Exception 
     */
    public void addOption(Option o) throws Exception;
}
