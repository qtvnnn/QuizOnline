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

import entity.Account;
import entity.UserType;
import dao.AccountDAO;
import dao.UserTypeDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.UserTypeDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * This class uses functions in <code>AccountDAO</code> to create account for user
 * Create Account success redirects to <code>login</code> controller.
 *
 * @author nangnnhe130538
 */
public class RegisterController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Redirects the user to the <code>registration.jsp</code> page.
     * 
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. 
     * Use <code>getAccountByUser</code> function in <code>AccountDAO</code> class to create a account for user.
     * Register success redirects to <code>login</code> controller.
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
            AccountDAO accountDAO = new AccountDAOImpl();
            String username = request.getParameter("user");
            String pass = request.getParameter("pass");
            String email = request.getParameter("email");
            String idUserType = request.getParameter("type");
            //get infomation of account
            String notification = null;

            if (username == null) {
                username = "";
            }
            if (email == null) {
                email = "";
            }
            if (idUserType == null) {
                idUserType = "";
            }

            Account accountCheck = accountDAO.getAccountByUser(username);
            // accountCheck username exist
            if (accountCheck != null) {
                notification = "Username is aready exist ! Please choose one new.";         
                UserType userType = new UserType();
                userType.setId(Integer.parseInt(idUserType));
                Account accountFail = new Account(username, pass, userType, email);
                request.setAttribute("accountFail", accountFail);
                request.setAttribute("notification", notification);
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            } else if (!accountDAO.checkEmail(email)) {
                //check mail exist
                notification = "Email is aready exist ! Please check again.";
                UserType userType = new UserType();
                userType.setId(Integer.parseInt(idUserType));
                Account accountFail = new Account(username, pass, userType, email);
                request.setAttribute("accountFail", accountFail);
                request.setAttribute("notification", notification);
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            } else {
                UserTypeDAO userTypeDAO = new UserTypeDAOImpl();
                UserType userType = userTypeDAO.getUserTypeById(Integer.parseInt(idUserType));
                Account account = new Account(username, pass, userType, email);
                accountDAO.addAcount(account);
                //add account
                request.getRequestDispatcher("login").forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, e);
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
