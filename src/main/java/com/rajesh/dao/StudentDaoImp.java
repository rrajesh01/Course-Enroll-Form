package com.rajesh.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rajesh.model.Student;

public class StudentDaoImp implements Studentdao {

    // Save Student
    public boolean save(Student st) {
        String sql = "INSERT INTO student VALUES(?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, st.getSid());
            ps.setString(2, st.getSname());
            ps.setString(3, st.getEmail());
            ps.setString(4, st.getCourse());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update Student
    public boolean update(Student newst) {
        String sql = "UPDATE student SET sname = ?, email = ?, course = ? WHERE sid = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newst.getSname());
            ps.setString(2, newst.getEmail());
            ps.setString(3, newst.getCourse());
            ps.setInt(4, newst.getSid());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Student by ID
    public boolean deleteById(int sid) {
        String sql = "DELETE FROM student WHERE sid = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read All Students
    public List<Student> readAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                String email = rs.getString("email");
                String course = rs.getString("course");

                students.add(new Student(sid, sname, email, course));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
