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
 * This class uses to contain attributes and methods getter, setter of <code>UserType</code> object
 * This class represents the <code>UserType</code> table in database
 *
 * @author nangnnhe130538
 */
public class UserType {

    /**
     * <code>UserType</code> id
     */
    private int id;
    /**
     * <code>UserType</code> type
     */
    private String type;

    /**
     * Constructor with no parameter
     */
    public UserType() {
    }

    /**
     * Constructor with parameter
     *
     * @param id it is an <code>int</code>
     * @param type it is a <code>java.lang.String</code>
     */
    public UserType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Get value from id attribute of <code>UserType</code> class. <br>
     *
     * @return id it is an <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>UserType</code> class
     *
     * @param id id it is an <code>int</code>
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from type attribute of <code>UserType</code> class. <br>
     *
     * @return type it is a <code>java.lang.String</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Set value to type attribute of <code>UserType</code> class
     *
     * @param type it is a <code>java.lang.String</code>
     *
     */
    public void setType(String type) {
        this.type = type;
    }

}
