package com.example.model;

import java.util.HashMap;

public class Student {
    
    private String studentID;
    private String studentName;
    private String studentAddress;
    private String studentMobile;
    private HashMap<String, Integer> marks = new HashMap<>();
    
    // Default constructor
    public Student(String studentID2, String studentName2, String studentAddress2, String studentMobile2, Object object, Object object2) { }

    // Constructor without photoPath (removed)
    public Student(String studentID, String studentName, String studentAddress, String studentMobile,
                   HashMap<String, Integer> marks) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentMobile = studentMobile;
        this.marks = marks;
    }

    // Constructor with photoPath removed
    public Student(String studentID, String studentName, String studentAddress, String studentMobile) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentMobile = studentMobile;
    }

    // Getter and Setter Methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public HashMap<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<String, Integer> marks) {
        this.marks = marks;
    }

    // Removed the photoPath getter and setter

    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentAddress=" + studentAddress
                + ", studentMobile=" + studentMobile + ", marks=" + marks + "]";
    }
}
