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

import entity.Question;
import dao.OptionDAO;
import dao.QuestionDAO;
import dao.impl.OptionDAOImpl;
import dao.impl.QuestionDAOImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * This class uses functions in <code>QuestionDAO</code> to get the list of questions, delete a question by Id
 * and <code>OptionDAO</code> to delete the options of the question you want to delete.
 * Then redirects the user to the <code>managerQuiz.jsp</code> page.
 *
 * @author nangnnhe130538
 */
public class ManagerQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>POST</code> method.
     * Use <code>deleteOption</code> function in <code>OptionDAO</code> class to delete the options of the 
     * question you want to delete by question ID.
     * Use <code>deleteQuestionById</code> function in <code>QuestionDAO</code> class to delete a question 
     * by question ID.
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
            int questionId = Integer.parseInt(request.getParameter("delete"));
            //get id to delete question
            int numberInPage = 4;
            OptionDAO optionDAO = new OptionDAOImpl();
            optionDAO.deleteOption(questionId);
            QuestionDAO questionDAO = new QuestionDAOImpl();
            questionDAO.deleteQuestionById(questionId);
            int count = questionDAO.countQuestion();
            String currentPage = request.getParameter("id");
            if (currentPage == null) {
                currentPage = "1";
            }
            int page = Integer.parseInt(currentPage);
            int pagecount = (count % numberInPage == 0) ? count / numberInPage : count / numberInPage + 1;
            ArrayList<Question> listQuestion = questionDAO.getListQuestionsPaging(page, numberInPage);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            request.setAttribute("df", dateFormat);
            request.setAttribute("count", count);
            request.setAttribute("listQ", listQuestion);
            request.setAttribute("pagecount", pagecount);
            response.sendRedirect("./manager?id=" + page);

        } catch (Exception e) {
            Logger.getLogger(ManagerQuizController.class.getName()).log(Level.SEVERE, null, e);
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
     * Use <code>getListQuestionsPaging</code> function in <code>QuestionDAO</code> class to get list 
     * all of question in the database.     * 
     * Then forward them to the page <code>managerQuiz.jsp</code>.
     * 
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuestionDAO questionDAO = new QuestionDAOImpl();
            int count = questionDAO.countQuestion();
            int numberInPage = 4;
            String currentPage = request.getParameter("id");
            if (currentPage == null) {
                currentPage = "1";
            }
            int page = Integer.parseInt(currentPage);
            ArrayList<Question> listQuestion = questionDAO.getListQuestionsPaging(page, numberInPage);
            //load list on page
            int pagecount = (count % numberInPage == 0) ? count / numberInPage : count / numberInPage + 1;
            //caculate munber of page
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            request.setAttribute("df", dateFormat);
            request.setAttribute("count", count);
            request.setAttribute("pagecount", pagecount);
            request.setAttribute("listQ", listQuestion);
            request.getRequestDispatcher("managerQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            Logger.getLogger(ManagerQuizController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
