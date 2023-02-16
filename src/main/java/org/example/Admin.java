package org.example;

import java.util.Scanner;

public class Admin extends StudentDataFile {
    // method to log in as admin
    public boolean adminlogin() {
        String password = "1234";
        // loop for 3 attempts to log in
        for (int i = 0; i < 3; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your password: ");
            String userPassword = input.nextLine();
            // check if the entered password is correct
            if (password.equals(userPassword)) {
                System.out.println("Login Successful✅,\nWelcome Admin😺");
                return true;
            } else {
                System.out.println("----------------------------------------------------");
                System.out.println("Incorrect password❌");
                System.out.println("The number of attempts remaining: " + (2-i));
            }
        }
        return false;
    }


    // method to search for a student by ID
    public int searchStudentID(){
       int id = addId();
        // check if the student is registered
        if(Help.searchStudentIndex(id)>=0){
           System.out.println("The student is registered✅,\n"+"The student Name is: "+studentGetData.get(Help.searchStudentIndex(id)).getStudentName());
           return id;
       }else {
           System.out.println("The student is not registered❌,");
       }
       return -1;
   }

    // method to add points to a student
    public void addPoints() {
        int id=searchStudentID();
        int idIndex = Help.searchStudentIndex(id);
        boolean key = false;
        // check if the student is registered
        if (idIndex >= 0) {
            key = true;
        }
        // if the student is registered
        if (key){
            int points = Help.checkPoints();
            studentAddPointsById(id,points);
            System.out.println("new point is: " + studentGetData.get(idIndex).getStudentPoints());

        }
    }
    // method to deduct points from a student
    public void pointsDeduction() {
        int id=searchStudentID();
        int idIndex = Help.searchStudentIndex(id);
        boolean key = false;
        // check if the student is registered
        if (idIndex >= 0) {
            key = true;
        }
        // if the student is registered
        if (key){

            int points = Help.checkPoints();
            studentDelPointsById(id,points);
            System.out.println("new point is: " + studentGetData.get(idIndex).getStudentPoints());

        }
    }

    // method to delete a student by admin
    public void deleteStudentAdmin() {
         int id = searchStudentID();
         boolean key = false;
        // check if the student is registered
        if (id >= 0) {
             key = true;
         }
        // if the student is registered
        if (key) {
          deleteStudent(id);
             System.out.println("Delete successfully✅");
         }
     }

    }


