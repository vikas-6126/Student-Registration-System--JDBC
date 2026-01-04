package com.student.registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert student
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students(name, roll, dept) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getName());
            pstmt.setInt(2, s.getRoll());
            pstmt.setString(3, s.getDept());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // View all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getString("name"),
                    rs.getInt("roll"),
                    rs.getString("dept")
                );
                s.setId(rs.getInt("id"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}