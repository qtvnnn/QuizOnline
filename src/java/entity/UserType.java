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
 * This class represents the UserType table in Database
 *
 * @author Dung
 */
public class UserType {

    /**
     * UserType id
     */
    private int id;
    /**
     * UserType type
     */
    private String type;

    /**
     * Constructor
     *
     * @param id
     * @param type
     */
    public UserType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Constructor
     */
    public UserType() {
    }

    /**
     * Get id from the UserType object
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id to the Question object
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get type from the UserType object
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set type to the Question object
     *
     * @param Type
     */
    public void setType(String Type) {
        this.type = Type;
    }

}
