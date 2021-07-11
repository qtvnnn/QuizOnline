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

import entity.UserType;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Question objects in the database.
 * 
 * @author Dung
 */
public interface UserTypeDAO {
    /**
     * Get a list of all types of users
     * 
     * @return a list <code>UserType</code> object.
     * @throws Exception 
     */
    public ArrayList<UserType> getListUserType() throws Exception;
    /**
     * Get UserType by UserType id.
     * 
     * @param id. It is a int number
     * @return <code>UserType</code> object
     * @throws Exception 
     */
    public UserType getUserTypeById(int id) throws Exception;
}
