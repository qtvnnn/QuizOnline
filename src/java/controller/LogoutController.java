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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * This class uses <code>invalidate()</code> method to cancel all saved sessions
 * Redirects the user to the <code>login.jsp</code> page.
 *
 * @author nangnnhe130538
 */
public class LogoutController extends BaseAuthenticationController {

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
     * Uses <code>invalidate()</code> method to cancel all saved sessions, then redirects 
     * the user to the <code>login.jsp</code> page.
     * 
     * @param request it is an object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is an object of <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("login").forward(request, response);
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
