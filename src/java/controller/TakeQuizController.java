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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * This class uses functions in <code>QuestionDAO</code> to get a list of random questions 
 * and <code>OptionDAO</code> to get a list of option of those questions.
 * Then redirects the user to the <code>doQuiz.jsp</code> page.
 *
 * @author nangnnhe130538
 */
public class TakeQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>POST</code> method.
     * Use <code>getListQuestionsTop</code> function in <code>QuestionDAO</code> class to get list of random question.
     * Use <code>getListOptionsByQuestionId</code> function in <code>OptionDAO</code>to get a list of option of 
     * those questions by question ID.
     * 
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int number = Integer.parseInt(request.getParameter("numberQ"));
            long millis = System.currentTimeMillis();
            HttpSession sessionArrN = request.getSession();
            HttpSession sessionTime = request.getSession();

            //get number user input
            QuestionDAO questionDAO = new QuestionDAOImpl();
            ArrayList<Question> listQuestions = questionDAO.getListQuestionsTop(number); //random
            //check number question in bank and compare with number question user input 
            int countQuestion = questionDAO.countQuestion();
            if (number > countQuestion) {
                String notification = "Not enough question for you";
                request.setAttribute("notification", notification);
                request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
            } else {
                int[] arrN = new int[number];
                for (int i = 0; i < number; i++) {
                    //take id of question in bank
                    arrN[i] = listQuestions.get(i).getId();
                }
                sessionArrN.setAttribute("arrN", arrN);
                OptionDAO optionDAO = new OptionDAOImpl();
                ArrayList<Option> listOptions = optionDAO.getListOptionsByQuestionId(arrN);
                //get list question
                request.setAttribute("listQ", listQuestions);
                request.setAttribute("listO", listOptions);
                request.setAttribute("number", number);
                sessionTime.setAttribute("time", millis);
                request.getRequestDispatcher("doQuiz.jsp").forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, e);
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
     * Redirects the user to the <code>takeQuiz.jsp</code> page.
     * 
     * @param req it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("takeQuiz.jsp").forward(req, resp);
    }
    /**
     * Pages used by teachers only
     *
     * @return boolean
     */
    @Override
    public boolean requiredTeacher() {
        return false;
    }

}
