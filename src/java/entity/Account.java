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
package entity;

/**
 * This class represents the Account table in Database
 *
 * @author Dung
 */
public class Account {

    /**
     * Account username
     */
    private String userName;
    /**
     * Account password
     */
    private String password;
    /**
     * entity UserType
     */
    private UserType userType;
    /**
     * Account email;
     */
    private String email;

    /**
     * Constructor
     *
     * @param userName
     * @param password
     * @param userType
     * @param email
     */
    public Account(String userName, String password, UserType userType, String email) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.email = email;
    }

    /**
     * Constructor
     */
    public Account() {
    }

    /**
     * Get Username from the Account object
     *
     * @return Username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set Username to the Account object
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get Password from the Account object
     *
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Password to the Account object
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get UserType from the Account object
     *
     * @return userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Set UserType to the Account object
     *
     * @param userType
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Get email from the Account object
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email to the Account object
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.email = Email;
    }

}
