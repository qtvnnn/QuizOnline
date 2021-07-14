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

import entity.Account;

/**
 * The interface of <code>AccountDAOImpl</code> class defines methods to help us 
 * manipulate <code>Account</code> object from <code>Account</code> tables in database.
 *
 * @author nangnnhe130538
 */
public interface AccountDAO {
    /**
     * Get a record account from <code>Account</code> table by username in the database
     * 
     * @param userName it is a <code>java.lang.String</code>
     * @return account it is an <code>Option</code> object
     * @throws Exception 
     */
    public Account getAccountByUser(String userName) throws Exception;
    /**
     * Check the email address when user registered already exists in the database
     * 
     * @param email it is a <code>java.lang.String</code>
     * @return true/false it is a <code>boolean</code>
     * @throws Exception 
     */
    public boolean checkEmail(String email) throws Exception;
    /**
     * Insert a new record account to <code>Account</code> table in the database
     * 
     * @param account it is an <code>Option</code> object
     * @throws Exception 
     */
    public void addAcount(Account account) throws Exception;
}
