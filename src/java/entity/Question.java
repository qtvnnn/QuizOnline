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

import java.sql.Date;

/**
 * This class represents the Question table in Database
 *
 * @author Dung
 */
public class Question {

    /**
     * Question id
     */
    private int id;
    /**
     * Question content
     */
    private String content;
    /**
     * Question date create
     */
    private Date date_Create;

    /**
     * Constructor
     */
    public Question() {
    }

    /**
     * Constructor
     *
     * @param id
     * @param content
     * @param date_Create
     */
    public Question(int id, String content, Date date_Create) {
        this.id = id;
        this.content = content;
        this.date_Create = date_Create;
    }

    /**
     * Get date_create from the Question object
     *
     * @return date_create
     */
    public Date getDate_Create() {
        return date_Create;
    }

    /**
     * Set date_create to the Question object
     *
     * @param date_Create
     */
    public void setDate_Create(Date date_Create) {
        this.date_Create = date_Create;
    }

    /**
     * Get id from the Question object
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
     * Get content from the Question object
     *
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content to the Question object
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
