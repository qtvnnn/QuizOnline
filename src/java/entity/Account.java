/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
 */
package entity;

/**
 * This class uses to contain attributes and methods getter, setter of <code>Account</code> object
 * This class represents the <code>Account</code> table in database
 *
 * @author nangnnhe130538
 */
public class Account {

    /**
     * <code>Account</code> userName
     */
    private String userName;
    /**
     * <code>Account</code> password
     */
    private String password;
    /**
     * <code>Account</code> userType
     */
    private UserType userType;
    /**
     * <code>Account</code> email
     */
    private String email;
    
    /**
     * Constructor with no parameter
     */
    public Account() {
    }

    /**
     * Constructor with parameter
     *
     * @param userName it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param userType it is an <code>entity.UserType</code> object
     * @param email it is a <code>java.lang.String</code>
     */
    public Account(String userName, String password, UserType userType, String email) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.email = email;
    }

    /**
     * Get value from userName attribute of <code>Account</code> class. <br>
     *
     * @return userName it is a <code>java.lang.String</code>
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set value to userName attribute of <code>Option</code> class
     *
     * @param userName it is a <code>java.lang.String</code>
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get value from password attribute of <code>Account</code> class. <br>
     *
     * @return password it is a <code>java.lang.String</code>
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value to password attribute of <code>Option</code> class
     *
     * @param password it is a <code>java.lang.String</code>
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get value from userType attribute of <code>Account</code> class. <br>
     *
     * @return userType it is a <code>entity.UserType</code>
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Set value to userType attribute of <code>Option</code> class
     *
     * @param userType it is a <code>entity.UserType</code>
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Get value from email attribute of <code>Account</code> class. <br>
     *
     * @return email it is a <code>java.lang.String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to email attribute of <code>Option</code> class
     *
     * @param email it is a <code>java.lang.String</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
