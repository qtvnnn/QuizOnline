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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * Processes: - Get a list of all questions in the database and paging the
 * question list.
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
 */
@WebServlet(name = "managerQuizController", urlPatterns = {"/manager"})
public class ManagerQuizController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>POST</code> method.
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
            response.sendRedirect("error.jsp");
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
     * 
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            QuestionDAO questionDAO = new QuestionDAOImpl();
            int count = questionDAO.countQuestion();
            int numberInPage = 4;
            String currentPage = req.getParameter("id");
            if (currentPage == null) {
                currentPage = "1";
            }
            int page = Integer.parseInt(currentPage);
            ArrayList<Question> listQuestion = questionDAO.getListQuestionsPaging(page, numberInPage);
            //load list on page
            int pagecount = (count % numberInPage == 0) ? count / numberInPage : count / numberInPage + 1;
            //caculate munber of page
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            req.setAttribute("df", dateFormat);
            req.setAttribute("count", count);
            req.setAttribute("pagecount", pagecount);
            req.setAttribute("listQ", listQuestion);
            req.getRequestDispatcher("managerQuiz.jsp").forward(req, resp);

        } catch (Exception e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
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
