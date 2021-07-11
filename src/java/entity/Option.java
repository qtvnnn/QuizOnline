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
 * This class represents the Option table in Database
 *
 * @author Dung
 */
public class Option {

    /**
     * Option id
     */
    private int id;
    /**
     * Option content
     */
    private String content;
    /**
     * entity Question
     */
    private Question question;
    /**
     * Option status
     */
    private boolean status;

    /**
     * Constructor
     */
    public Option() {
    }

    /**
     * Constructor
     *
     * @param id
     * @param content
     * @param question
     * @param status
     */
    public Option(int id, String content, Question question, boolean status) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.status = status;
    }

    /**
     * Get id from the Option object
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id to the Option object
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Content from the Option object
     *
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content to the Option object
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get Question from the Option object
     *
     * @return Question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Set Question to the Option object
     *
     * @param question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Get status from the Option object
     * 
     * @return status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Set status to the Option object
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
