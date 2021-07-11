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

import entity.Account;

/**
 * This class contains methods to help us manipulate Account objects in the database.
 * 
 * @author Dung
 */
public interface AccountDAO {
    /**
     * Search and retrieve account data according to the username entered by the user
     * 
     * @param user. It is a <code>java.lang.String</code>
     * @return a <code>Account</code> object
     * @throws Exception 
     */
    public Account getAccountByUser(String user) throws Exception;
    /**
     * Check to see if the email address when registered user already exists in the database
     * 
     * @param email. It is a <code>java.lang.String</code>
     * @return boolean
     * @throws Exception 
     */
    public boolean checkEmail(String email) throws Exception;
    /**
     * Add a new user account to the database
     * 
     * @param a. It is a Account
     * @throws Exception 
     */
    public void addAcount(Account a) throws Exception;
}
