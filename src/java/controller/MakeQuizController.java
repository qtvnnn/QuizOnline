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
import dao.QuestionDAO;
import dao.impl.QuestionDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * This class uses functions in <code>QuestionDAO</code> and <code>OptionDAO</code> to create question
 * and list options of this question.
 * Create Quiz success redirects to <code>manager</code> controller.
 *
 * @author nangnnhe130538
 */
public class MakeQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>POST</code> method. 
     * Use <code>addQuestionOption</code> function in <code>QuestionDAO</code> class to create 
     * a question and list of options of this question from user input data.
     * Create Quiz success redirects to <code>manager</code> controller.
     * 
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            // get time current from laptop
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            //get infomation question and answers from jsp
            String question = request.getParameter("question").trim();
            ArrayList<String> option = new ArrayList<>();
            String option1 = request.getParameter("option1").trim();
            String option2 = request.getParameter("option2").trim();
            String option3 = request.getParameter("option3").trim();
            String option4 = request.getParameter("option4").trim();
            option.add(option1);
            option.add(option2);
            option.add(option3);
            option.add(option4);
            ArrayList<String> comboboxResult = new ArrayList<>();
            String result1 = request.getParameter("cbxo1");
            String result2 = request.getParameter("cbxo2");
            String result3 = request.getParameter("cbxo3");
            String result4 = request.getParameter("cbxo4");

            String message = "";
            boolean flaq = true;
            if (result1 == null && result2 == null && result3 == null && result4 == null) {
                message = "Your question don't have any answers ! ";
                flaq = false;
                request.setAttribute("message", message);
                request.setAttribute("question", question);
                request.setAttribute("listOption", option);
                request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
            } else {
                if (result1 == null) {
                    result1 = "";
                }
                if (result2 == null) {
                    result2 = "";
                }
                if (result3 == null) {
                    result3 = "";
                }
                if (result4 == null) {
                    result4 = "";
                }
                comboboxResult.add(result1);
                comboboxResult.add(result2);
                comboboxResult.add(result3);
                comboboxResult.add(result4);
            }
            if (result1.equals("true") && result2.equals("true") && result3.equals("true") && result4.equals("true")) {
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
                ArrayList<Option> listOpions = new ArrayList<>();
                //add option to database
                for (int i = 0; i < 4; i++) {
                    Option options = new Option();
                    //set content for option
                    options.setContent(option.get(i));
                    //set question number
                    if (comboboxResult.get(i).equals("true")) {
                        //set value of satatus
                        options.setStatus(true);
                    } else {
                        options.setStatus(false);
                    }
                    listOpions.add(options);
                }
                questionDAO.addQuestionOption(question1, listOpions);
                //redirect to managerpage
                response.sendRedirect("manager");
            }
        } catch (Exception e) {                       
            Logger.getLogger(MakeQuizController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
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
     * Redirects the user to the <code>makeQuiz.jsp</code> page.
     *
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
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
