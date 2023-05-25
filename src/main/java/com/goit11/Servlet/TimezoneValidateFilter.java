package com.goit11.Servlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;
public class TimezoneValidateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        String time = request.getParameter("timezone");
        String word = time.substring(0,3);
        TimeZone timeZone = TimeZone.getTimeZone(word);
        if(timeZone.getID().contains("UTC")){
            chain.doFilter(request, response);
        }else {
            response1.sendError(400,"Invalid timezone");
            response.getWriter().close();
        }
    }
    }
