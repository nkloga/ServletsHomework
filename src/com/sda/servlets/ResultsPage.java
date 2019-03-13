package com.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sda.servlets.AuthServlet.html;

@WebServlet(urlPatterns = "/results")
public class ResultsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("error message", "<h1>Error: this page cannot be accessed directly</h1></body>");
        resp.sendRedirect("/error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String employeeStatus = req.getParameter("empstat");
        String favArtist = req.getParameter("favartist");
        String hobby = req.getParameter("hobby");
        String marStatus = req.getParameter("marstatus");

        if(firstname.length()<2
                || lastname.length()<2
                || employeeStatus.length()<2
                || favArtist.length()<2
                || hobby.length()<2
                || marStatus.length()<2) {
            req.getSession().setAttribute("error message", "<h1>Incorrect data has been provided, some input field has too short entry</h1>");
            resp.sendRedirect("/error");
        } else {

            PrintWriter out = resp.getWriter();
            out.println(html +
                    "  <h2>Summary</h2>" +
                    "<table>" +
                    "  <tr>" +
                    "    <td>First name</td>" +
                    "    <td>" + firstname + "</td>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td>Last name</td>" +
                    "    <td>" + lastname + "</td>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td>Employment</td>" +
                    "    <td>" + employeeStatus + "</td>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td>Favorite artist</td>" +
                    "    <td>" + favArtist + "</td>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td>Hobby</td>" +
                    "    <td>" + hobby + "</td>" +
                    "  </tr>" +
                    "  <tr>" +
                    "    <td>Marital status</td>" +
                    "    <td>" + marStatus + "</td>" +
                    "  </tr>" +
                    "</table>" +
                    "</div>" +
                    "</body>" +
                    "</html>");

        }
    }
}

