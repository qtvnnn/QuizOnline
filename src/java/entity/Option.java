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
 * This class uses to contain attributes and methods getter, setter of <code>Option</code> object
 * This class represents the <code>Option</code> table in database
 *
 * @author nangnnhe130538
 */
public class Option {

    /**
     * <code>Option</code> id
     */
    private int id;
    /**
     * <code>Option</code> content
     */
    private String content;
    /**
     * <code>Option</code> question
     */
    private Question question;
    /**
     * <code>Option</code> status
     */
    private boolean status;

    /**
     * Constructor with no parameter
     */
    public Option() {
    }

    /**
     * Constructor with parameter
     *
     * @param id it is an <code>int</code>
     * @param content it is a <code>java.lang.String</code>
     * @param question it is an <code>entity.Question</code> object
     * @param status it is a <code>boolean</code>
     */
    public Option(int id, String content, Question question, boolean status) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.status = status;
    }

    /**
     * Get value from id attribute of <code>Option</code> class. <br>
     *
     * @return id it is an <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Option</code> class
     *
     * @param id it is an <code>int</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from content attribute of <code>Option</code> class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value to content attribute of <code>Option</code> class
     *
     * @param content it is a <code>java.lang.String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get value from question attribute of <code>Option</code> class. <br>
     *
     * @return question it is an <code>entity.Question</code> object
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Set value to question attribute of <code>Option</code> class
     *
     * @param question it is an <code>entity.Question</code> object
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Get value from status attribute of <code>Option</code> class. <br>
     *
     * @return status it is a <code>boolean</code>
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Set value to status attribute of <code>Option</code> class
     *
     * @param status it is a <code>boolean</code> 
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
