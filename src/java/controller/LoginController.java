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

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import entity.Account;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class uses functions in <code>DigitalDAO</code> to get username input and compare it with 
 * username data in the database to perform login.
 * Login success redirects to <code>HomeController</code> controller.
 *
 * @author nangnnhe130538
 */
public class LoginController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Redirects the user to the <code>login.jsp</code> page.
     *
     * @param request it is a object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of <code>javax.servlet.http.HttpServletResponse</code>
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
     * Use <code>getAccountByUser</code> function in <code>AccountDAO</code> class to compare username input
     * with username data in the database to perform login
     * Login success redirects to <code>HomeController</code> controller.
 
    *
     * @param request it is a object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if account servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AccountDAO accountDAO = new AccountDAOImpl();
            String username = request.getParameter("user").trim();
            String pass = request.getParameter("pass");
            // create session to save account
            HttpSession sessionAccount = request.getSession();

            //check username exist
            if (username != null) {
                Account account = accountDAO.getAccountByUser(username);
                //check password is correct and save to session
                if (account != null && pass.equals(account.getPassword())) {
                    sessionAccount.setAttribute("acc", account);
                    response.sendRedirect("HomeController");
                } else {
                    //username is not exist send notification to jsp
                    String notification = "Incorrect account or password";
                    request.setAttribute("username", username);
                    request.setAttribute("notification", notification);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
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
