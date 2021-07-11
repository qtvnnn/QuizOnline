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
package controller;

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Processes: - Get username input and compare it with username data in the
 * database to perform login
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
 */
public class LoginController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response servlet response. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if account servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. 
     * 
     * Get the username and password entered by the username to compare it with the data in the database
     *
     * @param request servlet request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response servlet response. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if account servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AccountDAO accountDAO = new AccountDAOImpl();
            String username = request.getParameter("user");
            String pass = request.getParameter("pass");
            // create session to save account
            HttpSession sessionAcc = request.getSession();

            //check username exist
            if (username != null) {
                Account account = accountDAO.getAccountByUser(username);
                //check password is correct and save to session
                if (account != null && pass.equals(account.getPassword())) {
                    sessionAcc.setAttribute("acc", account);
                    response.sendRedirect("HomeController");
                } else {
                    //username is not exist send notification to jsp
                    String notification = "Login Fail";
                    request.setAttribute("notification", notification);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /**
     * Returns account short description of the servlet.
     *
     * @return account String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
