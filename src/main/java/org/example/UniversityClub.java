package org.example;



public class UniversityClub {

    // Private fields to store the student information
    private String studentName; // Student name
    private int studentId;         // Student ID number
    private int studentPoints;     // Number of points earned by the student in the club

    // Public getter and setter methods for the private fields
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentPoints() {
        return studentPoints;
    }

    public UniversityClub setStudentPoints(int studentPoints) {
        this.studentPoints = studentPoints;
        return null;
    }

}
