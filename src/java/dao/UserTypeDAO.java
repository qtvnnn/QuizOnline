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

import entity.UserType;
import java.util.ArrayList;

/**
 * The interface of <code>UserTypeDAOImpl</code> class defines methods to help us 
 * manipulate <code>UserType</code> object from <code>UserType</code> tables in database.
 *
 * @author nangnnhe130538
 */
public interface UserTypeDAO {
    /**
     * Get a list of all the number types of users in the database
     * 
     * @return a list of <code>UserType</code> object. It is a <code>java.util.List</code> object
     * @throws Exception 
     */
    public ArrayList<UserType> getListUserType() throws Exception;
    /**
     * Get a record of <code>UserType</code> object by id in the database
     * 
     * @param id. It is an <code>int</code>  number
     * @return userType it is an <code>UserType</code> object
     * @throws Exception 
     */
    public UserType getUserTypeById(int id) throws Exception;
}
