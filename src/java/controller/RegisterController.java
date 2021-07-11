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

import entity.Account;
import entity.UserType;
import dao.AccountDAO;
import dao.UserTypeDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.UserTypeDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 *
 * Processes: - Get username input and compare it with username data in the
 * database to make the registration.
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
 */
public class RegisterController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response servlet response. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. get information to create an
     * account for the username
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
