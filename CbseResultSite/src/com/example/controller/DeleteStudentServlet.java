package com.example.controller;

import java.io.IOException;

import com.example.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

	private StudentDao studentDao;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDao = new StudentDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		studentDao.deleteStudent(studentID);
		response.sendRedirect("index.jsp");
	}
}
