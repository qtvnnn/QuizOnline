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

import entity.Option;
import java.util.ArrayList;

/**
 * The interface of <code>OptionDAOImpl</code> class defines methods to help us 
 * manipulate <code>Option</code> object from <code>Option</code> tables in database.
 *
 * @author nangnnhe130538
 */
public interface OptionDAO {
    /**
     * Get options according to the id of the question in the required question list
     * 
     * @param arrQuestionId it is a <code>java.util.ArrayList</code> of <code>int</code>
     * @return a list of <code>Option</code> object. It is a <code>java.util.List</code> object
     * 
     * @throws Exception 
     */
    public ArrayList<Option> getListOptionsByQuestionId(int[] arrQuestionId) throws Exception;
    /**
     * Get all Options from <code>Option</code> table by id of a question
     * 
     * @param questionId it is <code>int</code> number
     * @return a list of <code>Option</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    public ArrayList<Option> getListOptions(int questionId) throws Exception;
    /**
     * Delete all of records options from <code>Option</code> table by question id in the database
     * 
     * @param questionId it is <code>int</code> number
     * @throws Exception 
     */
    public void deleteOption(int questionId) throws Exception;
    /**
     * Insert a new record option to <code>Option</code> table in the database
     * 
     * @param option it is an <code>Option</code> object
     * @throws Exception 
     */
    public void addOption(Option option) throws Exception;
}
