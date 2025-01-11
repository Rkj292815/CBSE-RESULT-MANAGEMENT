package com.example.controller;

import com.example.dao.StudentDao;
import com.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDao = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String studentAddress = request.getParameter("studentAddress");
        String studentMobile = request.getParameter("studentMobile");

        // Creating student object
        Student student = new Student(studentID, studentName, studentAddress, studentMobile);
        
        // Creating marks hashmap
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("computer", Integer.parseInt(request.getParameter("computer")));
        marks.put("physics", Integer.parseInt(request.getParameter("physics")));
        marks.put("chemistry", Integer.parseInt(request.getParameter("chemistry")));
        marks.put("biology", Integer.parseInt(request.getParameter("biology")));
        marks.put("english", Integer.parseInt(request.getParameter("english")));
        marks.put("math", Integer.parseInt(request.getParameter("math")));

        // Setting marks for student
        student.setMarks(marks);

        // No photo upload logic here
        // Save student data to database
        studentDao.addStudent(student);

        // Redirect to index page after adding student
        response.sendRedirect("index.jsp");
    }
}
