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
package filter;

import entity.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class helps check if the url is valid or not
 * 
 * @author Dung
 */
public class MyFilter implements Filter {

    /**
     * 
     * @param request servlet request. It is <code>javax.servlet.http.HttpServletRequest</code>
     * @param response servlet response. It is <code>javax.servlet.http.HttpServletResponse</code>
     * @param chain. It is <code>javax.servlet.FilterChain</code>
     * @throws IOException
     * @throws ServletException 
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getServletPath();
        Account acc = (Account) req.getSession().getAttribute("acc");
        if (acc == null) {
            if (path.endsWith(".jsp")) {
                req.getRequestDispatcher("login").forward(req, resp);
            }
        } else {
            if (path.endsWith(".jsp")) {
                path = path.replaceAll(".jsp", "").replace("/", "");
                if (path.equals("makeQuiz") || path.equals("takeQuiz") || path.equals("HomeController") || path.equals("manager") || path.endsWith("takeQuiz2")) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else {
                    req.getRequestDispatcher("HomeController").forward(req, resp);
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
