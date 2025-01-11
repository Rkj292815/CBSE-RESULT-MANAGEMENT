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

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	private StudentDao studentDao;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDao = new StudentDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		Student student = studentDao.getStudent(studentID);

		if (student == null) {
			request.setAttribute("student", student);
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Student not found.");
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		String studentName = request.getParameter("studentName");
		String studentAddress = request.getParameter("studentAddress");
		String studentMobile = request.getParameter("studentMobile");

		// Fetching the existing student data
		Student student = studentDao.getStudent(studentID);

		// Update the attributes
		student.setStudentName(studentName);
		student.setStudentAddress(studentAddress);
		student.setStudentMobile(studentMobile);

		HashMap<String, Integer> marks = new HashMap<>();
		marks.put("computer", Integer.parseInt(request.getParameter("computer")));
		marks.put("physics", Integer.parseInt(request.getParameter("physics")));
		marks.put("chemistry", Integer.parseInt(request.getParameter("chemistry")));
		marks.put("biology", Integer.parseInt(request.getParameter("biology")));
		marks.put("english", Integer.parseInt(request.getParameter("english")));
		marks.put("math", Integer.parseInt(request.getParameter("math")));
		student.setMarks(marks);

		// No photo upload logic here

		studentDao.updateStudent(student);
		response.sendRedirect("index.jsp");
	}
}
