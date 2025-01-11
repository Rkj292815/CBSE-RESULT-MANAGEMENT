package com.example.controller;

import java.io.IOException;
import java.util.HashMap;

import com.example.dao.StudentDao;
import com.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");

        // Fetch the student object
        Student student = studentDao.getStudent(studentID);

        if (student != null) {
            // Calculate total marks and percentage
            HashMap<String, Integer> marks = student.getMarks();
            int totalMarks = calculateTotalMarks(marks);
            double percentage = calculatePercentage(totalMarks, marks.size());

            // Set attributes for JSP
            request.setAttribute("student", student);
            request.setAttribute("totalMarks", totalMarks);
            request.setAttribute("percentage", percentage);
            request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
        } else {
            // If student not found
            request.setAttribute("errorMessage", "Student not found.");
            request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
        }
    }

    private int calculateTotalMarks(HashMap<String, Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0; // Return 0 if marks are null or empty
        }
        int totalMarks = 0;
        for (int mark : marks.values()) {
            totalMarks += mark; // Sum all the marks
        }
        return totalMarks;
    }

    private double calculatePercentage(int totalMarks, int subjectCount) {
        if (subjectCount > 0) {
            return (double) totalMarks / subjectCount;
        }
        return 0.0; // Return 0 if there are no subjects
    }
}
