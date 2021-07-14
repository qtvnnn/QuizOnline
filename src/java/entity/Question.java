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

import java.sql.Date;

/**
 * This class uses to contain attributes and methods getter, setter of <code>Question</code> object
 * This class represents the <code>Question</code> table in database
 *
 * @author nangnnhe130538
 */
public class Question {

    /**
     * <code>Question</code> id
     */
    private int id;
    /**
     * <code>Question</code> content
     */
    private String content;
    /**
     * <code>Question</code> dateCreate
     */
    private Date dateCreate;

    /**
     * Constructor with no parameter
     */
    public Question() {
    }

    /**
     * Constructor with parameter
     *
     * @param id it is an <code>int</code>
     * @param content it is a <code>java.lang.String</code>
     * @param dateCreate it is a <code>java.sql.Date</code>
     */
    public Question(int id, String content, Date dateCreate) {
        this.id = id;
        this.content = content;
        this.dateCreate = dateCreate;
    }

    /**
     * Get value from dateCreate attribute of <code>Question</code> class. <br>
     *
     * @return dateCreate it is an <code>java.sql.Date</code>
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * Set value to dateCreate attribute of <code>Question</code> class
     *
     * @param dateCreate it is a <code>java.sql.Date</code>
     *
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * Get value from id attribute of <code>Question</code> class. <br>
     *
     * @return id it is an <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Question</code> class
     *
     * @param id it is an <code>int</code>
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from content attribute of <code>Question</code> class. <br>
     *
     * @return content it is an <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value to content attribute of <code>Question</code> class
     *
     * @param content it is a <code>java.lang.String</code>
     *
     */
    public void setContent(String content) {
        this.content = content;
    }

}
