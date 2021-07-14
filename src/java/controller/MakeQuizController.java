/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
 */
package controller;

import entity.Option;
import entity.Question;
import dao.OptionDAO;
import dao.QuestionDAO;
import dao.impl.OptionDAOImpl;
import dao.impl.QuestionDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * Processes: - Get the data of the question and check according to the
 * conditions in the function
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
 */
public class MakeQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>POST</code> method. Get the data the user enters
     * to create a question and add options to the question
     *
     * @param request servlet request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response servlet response. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get time current from laptop
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            //get infomation question and answers from jsp
            String question = request.getParameter("question");
            ArrayList<String> option = new ArrayList<>();
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            option.add(option1);
            option.add(option2);
            option.add(option3);
            option.add(option4);
            ArrayList<String> cbx = new ArrayList<>();
            String cbxo1 = request.getParameter("cbxo1");
            String cbxo2 = request.getParameter("cbxo2");
            String cbxo3 = request.getParameter("cbxo3");
            String cbxo4 = request.getParameter("cbxo4");

            String message = "";
            boolean flaq = true;
            if (cbxo1 == null && cbxo2 == null && cbxo3 == null && cbxo4 == null) {
                message = "Your question don't have any answers ! ";
                flaq = false;
                request.setAttribute("message", message);
                request.setAttribute("question", question);
                request.setAttribute("listOption", option);
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            } else {
                if (cbxo1 == null) {
                    cbxo1 = "";
                }
                if (cbxo2 == null) {
                    cbxo2 = "";
                }
                if (cbxo3 == null) {
                    cbxo3 = "";
                }
                if (cbxo4 == null) {
                    cbxo4 = "";
                }
                cbx.add(cbxo1);
                cbx.add(cbxo2);
                cbx.add(cbxo3);
                cbx.add(cbxo4);
            }
            if (cbxo1.equals("true") && cbxo2.equals("true") && cbxo3.equals("true") && cbxo4.equals("true")) {
                flaq = false;
                message = "Your question have all answers is right ! ";
                request.setAttribute("message", message);
                request.setAttribute("question", question);
                request.setAttribute("listOption", option);
                boolean flaqcbx = false;
                request.setAttribute("flaqcbx", flaqcbx);
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            }
            if (flaq) {
                // add question to database 
                QuestionDAO questionDAO = new QuestionDAOImpl();
                Question question1 = new Question();
                question1.setContent(question);
                question1.setDateCreate(date);
                questionDAO.addQuestion(question1);
                int questionId = questionDAO.getIdQuestion();
                OptionDAO optionDAO = new OptionDAOImpl();
                //add option to database
                for (int i = 0; i < 4; i++) {
                    Option options = new Option();
                    //set content for option
                    options.setContent(option.get(i));
                    //set question number
                    options.setQuestion(questionDAO.getQuestionById(questionId));
                    if (cbx.get(i).equals("true")) {
                        //set value of satatus
                        options.setStatus(true);
                    } else {
                        options.setStatus(false);
                    }
                    optionDAO.addOption(options);
                }
                //redirect to managerpage
                request.getRequestDispatcher("manager").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Redirect to the make quiz page
     *
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("makeQuiz.jsp").forward(req, resp);
    }
    /**
     * Pages used by teachers only
     *
     * @return boolean
     */
    @Override
    public boolean requiredTeacher() {
        return true;
    }

}
