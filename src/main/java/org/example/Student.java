package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import static org.example.StudentDataFile.getAllStudentData;

public class Student {
    // Object for saving student data to a file
    public static StudentDataFile studentSetData=new StudentDataFile();

    // Vector of UniversityClub objects to store student data
    public static Vector<UniversityClub> studentGetData=getAllStudentData();

    // Method to add a student to the Vector studentGetData
    public boolean addStudent(int id) {
        // Check if the student ID already exists
        for (UniversityClub uc : studentGetData) {
            if (uc.getStudentId() == id) {
                System.out.println("ID already exists!🙀");
                return false;
            }
        }
        return true;
    }
    // Method to gather student data and add it to the Vector studentGetData and file studentSetData
    public void studentData() {
        Scanner name = new Scanner(System.in);
        System.out.println("Pleas your name");
        String studentName = name.nextLine();

        int studentId = addId();
        boolean key=true;
        // Loop until a unique ID is entered
        while (key) {
            if (addStudent(studentId)) {
                UniversityClub club = new UniversityClub();
                club.setStudentName(studentName);
                club.setStudentId(studentId);
                club.setStudentPoints(0);
                studentSetData.saveStudentData(club);
                studentGetData.add(club);
                System.out.println("Welcome to the university club😻😻");
                key = false;
            }
            else {
                System.out.println("Please enter an unused ID number");
                studentId=addId();
            }
        }

    }
    // Method to get a valid 9-digit student ID
    public int addId(){
          boolean key=true;
          while (key) {
              try {
                  System.out.println("Enter the 9-digit ID number");
                  Scanner id = new Scanner(System.in);
                  int studentId = id.nextInt();
                  studentId= Help.perfectId(studentId);
                  key=false;
                  return studentId;
              }catch (InputMismatchException e){
                  System.out.println("Please enter valid numbers😾");
              }
          }
          return 0;
      }
    // Method to search for a student by their ID number
    public int searchStudentID(){
        int id = addId();
        if(Help.searchStudentIndex(id)>=0){
            System.out.println("Welcome back: "+studentGetData.get(Help.searchStudentIndex(id)).getStudentName()+"😻😻");
            return id;
        }else {
            System.out.println("You are not registered🙀,\nYou will return to the previous menu");
        }
        return -1;
    }



}




