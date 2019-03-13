package com.sda.servlets;

import com.sda.authentication.Credentials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sda.servlets.AuthServlet.html;

@WebServlet(urlPatterns = "/credentialscheck")
public class FormPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("error message", "<html>" +
                "<body><h1>Error: this page cannot be accessed directly</h1></body>" +
                "</html>");
        resp.sendRedirect("/error");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("firstname");
        String password = request.getParameter("password");


        if (Credentials.credentialsCheck(name, password)) {
            PrintWriter out = response.getWriter();

            out.println(html +
                    "<h2>Provide your personal information</h2>" +
                    "<form action=\"results\" method=\"post\" align=\"center\">" +
                    " <input type=\"text\" name=\"firstname\" placeholder=\"First name\" >" +
                    "<br>" +
                    "<input type=\"text\" name=\"lastname\" placeholder=\"Last name\">" +
                    "<br>" +
                    "<input type=\"text\" name=\"empstat\" placeholder=\"Employment status\">" +
                    "<br>" +
                    "<input type=\"text\" name=\"favartist\" placeholder=\"Favorite musical artist\">" +
                    "<br>" +
                    "<input type=\"text\" name=\"hobby\" placeholder=\"Hobby\">" +
                    "<br>" +
                    "<input type=\"text\" name=\"marstatus\" placeholder=\"Marital status\">" +
                    "<br>" +
                    "<input type=\"submit\" name=\"Click here to submit\" >" +
                    "</form> " +
                    "</div>" +
                    "</body>" +
                    "</html>");

        } else {
            request.getSession().setAttribute("error message", "<h1>Incorrect login or password</h1>");
            response.sendRedirect("/error");
        }
    }
}