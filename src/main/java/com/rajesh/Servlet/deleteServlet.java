package com.rajesh.Servlet;

import java.io.IOException;

import com.rajesh.dao.StudentDaoImp;
import com.rajesh.dao.Studentdao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/student/delete"}, loadOnStartup = 1)

public class deleteServlet extends HttpServlet {

    private Studentdao sdo;

    public deleteServlet() {
        sdo = new StudentDaoImp(); // Initialize the DAO implementation
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get the student ID from the request
            int sid = Integer.parseInt(req.getParameter("sid"));

            // Call the deleteById method in the DAO
            boolean isDeleted = sdo.deleteById(sid);

            // Respond based on the result
            if (isDeleted) {
                resp.getWriter().write("Student deleted successfully.");
            } else {
                resp.getWriter().write("Failed to delete student. Please check the ID.");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid student ID format.");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("An error occurred while processing the request.");
        }
    }
}
