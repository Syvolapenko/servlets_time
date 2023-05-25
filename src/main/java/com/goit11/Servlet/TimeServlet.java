package com.goit11.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("text/html; charset=utf-8");
            String utc = req.getParameter("timezone");
            String query = utc.substring(4);
            int number = Integer.parseInt((query));
            String initTime;
            if (utc.contains("UTC ")) {
                initTime = LocalDateTime.now()
                        .plusHours(number)
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss")) + " UTC+" + query;
            } else {
                initTime = LocalDateTime.now()
                        .minusHours(number)
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss")) + " UTC-" + query;
            }
            resp.getWriter().write(initTime);
            resp.getWriter().close();
        }
    }
