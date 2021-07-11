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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends from abstract class BaseAuthenticationController.
 * Processes: - Log out of the page
 *
 * Exception: - If on/output failed, it will return to error page.
 *
 * @author Dung
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
     * reset the session and redirect to the login page
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("login").forward(req, resp);
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
