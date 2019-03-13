package com.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sda.servlets.AuthServlet.html;

@WebServlet(urlPatterns = "/error")
public class ErrorPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String result = (String) req.getSession().getAttribute("error message");
        if (result == null) {
            result = "Error: this page cannot be accessed directly";
        }

        out.println(html + "<h2>Authorization page</h2>" +
                    "<p>" + result + "</p>" +
                "</div>" +
                "</body>" +
                "</html>");
    }
}
