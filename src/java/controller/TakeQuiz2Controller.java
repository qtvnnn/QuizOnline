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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Processes: - Get the questions in the database and the answers of the users to compare and notify the user scores.
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
 */
@WebServlet(name = "takeQuiz2", urlPatterns = {"/takeQuiz2"})
public class TakeQuiz2Controller extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response. It is <code>javax.servlet.http.HttpServletResponse</code>
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
     *
     * @param request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response. It is <code>javax.servlet.http.HttpServletResponse</code>
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
            if (timeSubmit - (number * 5 * 1000 + 800) <= timeStart) {
                int count = 0;
                int[] arrN = new int[number];
                arrN = (int[]) session.getAttribute("arrN");
                OptionDAO optionDAO = new OptionDAOImpl();
                for (int i = 0; i < arrN.length; i++) {
                    boolean flaq = true;
                    ArrayList<Option> listOptions = optionDAO.getListOptions(arrN[i]);
                    //get question in bank with number of user
                    for (int j = 0; j < listOptions.size(); j++) {
                        String takeO = request.getParameter(listOptions.get(j).getId() + "");
                        //get option of question to compare with answer of user
                        boolean check;
                        if (takeO == null) {
                            //user no choose answer
                            check = false;
                        } else {
                            check = true;
                        }
                        if (!listOptions.get(j).isStatus() == check) {
                            //compare answers
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
                //result of user
                String fomatScore = String.format("%.1f", (float) count / number * 10);
                String yourScore = fomatScore + " (" + percent + "%) - " + checkPass;
                //format result and send to web
                request.setAttribute("yourScore", yourScore);
                request.setAttribute("color", color);
                request.getRequestDispatcher("takeQuiz3.jsp").forward(request, response);
            } else {
                request.setAttribute("reject", "reject");
                request.getRequestDispatcher("takeQuiz3.jsp").forward(request, response);
            }

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

}
