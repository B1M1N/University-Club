package org.example;

import java.util.Collections;

public class Print extends Help {
    // A method to print all the student data stored in the studentGetData list
    public void printAllElements() {
        // Loop through the studentGetData list and print each student's data
        for (int i = 0; i < studentGetData.size(); i++) {
            UniversityClub student = studentGetData.get(i);
            System.out.println("----------------------------------------------------");
            System.out.println("Name: " + student.getStudentName());
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Points: " + student.getStudentPoints());
        }
    }
    // A method to print a single student's data
    public void printStudent() {
        // Get the student's ID
        int id =addId();
        // Check if the student is registered
        if (Help.searchStudentIndex(id)>=0) {
            System.out.println("The student is registered✅,");
            // Loop through the studentGetData list to find the student with the matching ID
            for (UniversityClub club : studentGetData) {
                if (club.getStudentId() == id) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("Student Name: " + club.getStudentName());
                    System.out.println("Student ID: " + club.getStudentId());
                    System.out.println("Student Points: " + club.getStudentPoints());
                    break;
                }
                }
            }else {
            // If the student is not registered, print a message
            System.out.println("The student is not registered🙀");
        }
    }
    // An overloaded method to print a single student's data based on the ID
    public void printStudent(int id ) {
        // Check if the student is registered
        if (Help.searchStudentIndex(id)>=0) {
            // Loop through the studentGetData list to find the student with the matching ID
            for (UniversityClub club : studentGetData) {
                if (club.getStudentId() == id) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("Student Name: " + club.getStudentName());
                    System.out.println("Student ID: " + club.getStudentId());
                    System.out.println("Student Points: " + club.getStudentPoints());
                    break;
                }
            }
        }
    }


    // A method to print a table of all the students' data sorted by their points
public void printStudentTableAdmin(){
    System.out.println("----------------------------------------------------");
    int maxNameLength = 0;
    // Find the length of the longest name in the studentGetData list
    for (UniversityClub student : studentGetData) {
        maxNameLength = Math.max(maxNameLength, student.getStudentName().length());
    }
    System.out.print("Rank.|Name");
    // Add spaces to align the names in the table
    for (int j = 0; j < maxNameLength; j++) {
        System.out.print(" ");
    }
    System.out.println("|ID\t\t\t|Points " );
    // Sort the studentGetData list by student points in descending order
    Collections.sort(studentGetData, (UniversityClub o1, UniversityClub o2) -> o2.getStudentPoints() - o1.getStudentPoints());
    // Print the table of students with their rank, name, ID, and points
    for (int i = 0; i < studentGetData.size(); i++) {
        UniversityClub student = studentGetData.get(i);
        System.out.print((i + 1) + "\t | " + student.getStudentName());
        // Add spaces to align the names in the table
        for (int j = 0; j < maxNameLength - student.getStudentName().length(); j++) {
            System.out.print(" ");
        }
        System.out.println("   | " + student.getStudentId() + "\t| " + student.getStudentPoints());
    }
}
    public void printStudentTable(){
        System.out.println("----------------------------------------------------");
        int maxNameLength = 0;
        // Find the length of the longest name in the studentGetData list
        for (UniversityClub student : studentGetData) {
            maxNameLength = Math.max(maxNameLength, student.getStudentName().length());
        }
        System.out.print("Rank |Name");
        // Add spaces to align the names in the table
        for (int j = 0; j < maxNameLength; j++) {
            System.out.print(" ");
        }
        System.out.println("|Points " );
        // Sort the studentGetData list by student points in descending order
        Collections.sort(studentGetData, (UniversityClub o1, UniversityClub o2) -> o2.getStudentPoints() - o1.getStudentPoints());
        // Print the table of students with their rank, name, and points
        for (int i = 0; i < studentGetData.size(); i++) {
            UniversityClub student = studentGetData.get(i);
            System.out.print((i + 1) + "\t | " + student.getStudentName());
            // Add spaces to align the names in the table
            for (int j = 0; j < maxNameLength - student.getStudentName().length(); j++) {
                System.out.print(" ");
            }
            System.out.println("   |" + student.getStudentPoints());
        }
    }

    //This method prints the main menu commands
    public void printCommands(){
         System.out.println("----------------------------------------------------");
         System.out.println("1-Admin");
         System.out.println("2-Student");
         System.out.println("3-Exit");
     }
    //This method prints the menu commands for students
    public void printCommandsStudent(){
         System.out.println("----------------------------------------------------");
         System.out.println("1-Currently a member");
         System.out.println("2-A New member");
         System.out.println("3-Exit");

     }
    //This method prints the menu commands for admin
    public void printCommandsAdmin(){
         System.out.println("----------------------------------------------------");
         System.out.println("1-Add points");
         System.out.println("2-Points deduction");
         System.out.println("3-Print a specific student");
         System.out.println("4-Print all students");
         System.out.println("5-Print all students in order of points");
         System.out.println("6-Delete a student from the club");
         System.out.println("7-Exit");

     }
    //This method prints the menu commands for available students
    public void printCommandsStudentِAvailable(){
         System.out.println("----------------------------------------------------");
         System.out.println("1-Print your information");
         System.out.println("2-Print the highest score for the students");
         System.out.println("3-Exit");
     }
}


