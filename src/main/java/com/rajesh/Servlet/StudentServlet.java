package com.rajesh.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.rajesh.dao.StudentDaoImp;
import com.rajesh.dao.Studentdao;
import com.rajesh.model.Student;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/student/save"}, loadOnStartup = 1)

public class StudentServlet extends HttpServlet {

    private Studentdao sdo;

    public StudentServlet() {
        sdo = new StudentDaoImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Retrieve form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        // Create Student object
        Student student = new Student(name, email, course);

        // Attempt to save the student
        boolean isSaved = sdo.save(student);

        // Set the response content type
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (isSaved) {
            // If the student was successfully saved, show success message
            out.println("<html><body>");
            out.println("<h3>Registration Successful!</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        } else {
            // If saving failed, show error message
            out.println("<html><body>");
            out.println("<h3>Registration Failed. Please try again later.</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}
