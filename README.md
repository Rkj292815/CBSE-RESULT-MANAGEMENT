# CBSE-RESULT-MANAGEMENT

Overview

The CBSE Result Management System is a web-based application that allows schools to manage and maintain student results. It calculates the total marks and percentage for each student. The system provides functionality for adding, updating, and deleting student results.

Features

Add New Results: Input student details and subject marks, and the system will automatically calculate the total and percentage. Update Results: Modify existing student results. Delete Results: Remove student results from the database. Total Marks & Percentage Calculation: Automatic calculation based on the marks entered for each subject.

Responsive Design

Built with HTML, CSS, and JSP for a user-friendly and attractive interface.

Technologies Used

Backend: Java 8, Servlet Frontend: HTML, CSS, JSP Database: MySQL Web Server: Apache Tomcat

How to Run the Project

Setup MySQL Database: Create the database and table as described above.

Import the Project into an IDE: Import the project into your favorite IDE (Eclipse, IntelliJ, etc.).

Configure Database Connection: Update your database connection details in the DatabaseConnection.java file.

Deploy on Apache Tomcat: Deploy the project on Apache Tomcat or any other servlet container.

Run the Application: Access the application in your browser at http://localhost:9090/CbseResultSite/ .

How to Use

Add New Result:

Navigate to "Add Result". Enter student name, roll number, and marks for each subject. The system will automatically calculate the total and percentage. Click "Submit" to add the result.

Update Result:

Navigate to "Update Result". Select the student by roll number and update marks. The system will recalculate the total and percentage. Click "Update" to save changes.

Delete Result:

Navigate to "Delete Result". Select the student by roll number and click "Delete".
