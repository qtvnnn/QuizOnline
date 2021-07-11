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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Check login status and verify user permissions
 *
 * @author Dung
 */
public abstract class BaseAuthenticationController extends HttpServlet {

    /**
     * Check login status
     *
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @return boolean
     */
    private boolean checkLogin(HttpServletRequest req) {
        Account account = (Account) req.getSession().getAttribute("acc");
        return account != null;
    }

    /**
     * Check permissions and which pages the user has permission to use
     *
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkLogin(req)) {
            Account account = (Account) req.getSession().getAttribute("acc");
            if (requiredTeacher() && account.getUserType().getType().equals("Student")) {
                req.getRequestDispatcher("accessDenied.jsp").forward(req, resp);
            } else {
                processGet(req, resp);
            }
        } else {
            resp.sendRedirect("login");
        }
    }

    /**
     *
     * @param req. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param resp. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException
     * @throws IOException
     */
    protected abstract void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * Pages used by teachers only
     *
     * @return boolean
     */
    public abstract boolean requiredTeacher();
}
