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
import dao.OptionDAO;
import dao.impl.OptionDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class uses functions in <code>OptionDAO</code> to check the correct answer of the question
 * and uses Session to calculate the test end time.
 * Then redirects the user to the <code>takeQuiz3.jsp</code> page to take score and show user's test results.
 *
 * @author nangnnhe130538
 */
@WebServlet(name = "takeQuiz2", urlPatterns = {"/takeQuiz2"})
public class TakeQuiz2Controller extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Redirects the user to the <code>takeQuiz</code> controller.
     *
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("takeQuiz").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Use <code>getListOptions</code> function in <code>OptionDAO</code> class to get list options of question 
     * and check status of this option. True is correct, false is not correct.
     * Use <code>HttpSession</code> to get time start to calculate the test end time then take score
     * Then forward them to the page <code>takeQuiz3.jsp</code> to show user's test results.
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
            HttpSession session = request.getSession();
            int number = Integer.parseInt(request.getParameter("number"));
            long timeSubmit = System.currentTimeMillis();
            long timeStart = (long) session.getAttribute("time");
            if (timeSubmit - (number * 10 * 1000 + 800) <= timeStart) {
                int count = 0;
                int[] arrN = new int[number];
                arrN = (int[]) session.getAttribute("arrN");
                OptionDAO optionDAO = new OptionDAOImpl();
                for (int i = 0; i < arrN.length; i++) {
                    boolean flaq = true;
                    ArrayList<Option> listOptions = optionDAO.getListOptions(arrN[i]);
                    for (int j = 0; j < listOptions.size(); j++) {
                        String takeO = request.getParameter(listOptions.get(j).getId() + "");
                        boolean check;
                        if (takeO == null) {
                            check = false;
                        } else {
                            check = true;
                        }
                        if (!listOptions.get(j).isStatus() == check) {
                            flaq = false;
                        }
                    }
                    if (flaq) {
                        count++;
                    }
                }

                float score = (float) count / number * 10;
                String percent = String.format("%.0f", score * 10);
                String checkPass;
                String color;
                if (score >= 5) {
                    checkPass = "Passed";
                    color = "blue";
                } else {
                    checkPass = "Not Passed";
                    color = "red";
                }
                String fomatScore = String.format("%.1f", (float) count / number * 10);
                String yourScore = fomatScore + " (" + percent + "%) - " + checkPass;
                request.setAttribute("yourScore", yourScore);
                request.setAttribute("color", color);
                request.getRequestDispatcher("takeQuiz3.jsp").forward(request, response);
            } else {
                request.setAttribute("reject", "reject");
                request.getRequestDispatcher("takeQuiz3.jsp").forward(request, response);
            }

        } catch (Exception e) {
            Logger.getLogger(TakeQuiz2Controller.class.getName()).log(Level.SEVERE, null, e);
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

}
