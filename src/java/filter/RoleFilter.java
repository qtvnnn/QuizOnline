/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0001<br>
 * Online Quiz<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-29    1.0        NangNN           First Version<br>
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
 * @author nangnnhe130538
 */
public class RoleFilter implements Filter {

    /**
     * 
     * @param request it is a object of <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of  <code>javax.servlet.http.HttpServletResponse</code>
     * @param chain it is a object of <code>javax.servlet.FilterChain</code>
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getServletPath();
        Account account = (Account) req.getSession().getAttribute("acc");
        if (account == null) {
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
