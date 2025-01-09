package com.rajesh.Servlet;

import java.io.IOException;

import com.rajesh.dao.StudentDaoImp;
import com.rajesh.dao.Studentdao;
import com.rajesh.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/student/update"}, loadOnStartup = 1)
public class UpdateServlet extends HttpServlet {

    private Studentdao sdo;

    public UpdateServlet() {
        sdo = new StudentDaoImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set request encoding to handle special characters
        req.setCharacterEncoding("UTF-8");

        try {
            // Get parameters from request
            int sid = Integer.parseInt(req.getParameter("sid"));
            String sname = req.getParameter("sname");
            String email = req.getParameter("email");
            String course = req.getParameter("course");

            // Create a Student object with updated data
            Student newStudent = new Student(sid, sname, email, course);

            // Call update method
            boolean isUpdated = sdo.update(newStudent);

            // Set success or failure message
            if (isUpdated) {
                req.setAttribute("message", "Student updated successfully.");
            } else {
                req.setAttribute("message", "Failed to update student.");
            }

            // Forward the request to the JSP page
            RequestDispatcher dispatcher = req.getRequestDispatcher("updateSuccess.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            // Handle errors
            req.setAttribute("message", "An error occurred: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("updateSuccess.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
