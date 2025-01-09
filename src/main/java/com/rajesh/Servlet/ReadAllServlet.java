package com.rajesh.Servlet;

import com.rajesh.dao.StudentDaoImp;
import com.rajesh.dao.Studentdao;
import com.rajesh.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/student/readall"}, loadOnStartup = 1)

public class ReadAllServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Studentdao sdo;

    public ReadAllServlet() {
        sdo = new StudentDaoImp(); // Initialize the DAO implementation
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetch all students from the DAO
        List<Student> students = sdo.readAll();

        // Check if students list is empty or null
        if (students == null || students.isEmpty()) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>No Students Found</h1>");
            out.println("</body></html>");
        } else {
            // Set response content type
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            // Build HTML response
            out.println("<html><body>");
            out.println("<h1>Student List</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>");

            // Iterate over students and display them in a table
            for (Student student : students) {
                out.println("<tr>");
                out.println("<td>" + student.getSid() + "</td>");
                out.println("<td>" + student.getSname() + "</td>");
                out.println("<td>" + student.getEmail() + "</td>");
                out.println("<td>" + student.getCourse() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
        }
    }
}
