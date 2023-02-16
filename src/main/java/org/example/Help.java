package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Help extends Student {
    // method to check and retrieve points
    public static int checkPoints() {
     boolean key = true;
     while (key) {
         try {
             Scanner pointsIn = new Scanner(System.in);
             System.out.println("Enter points");
             int points = pointsIn.nextInt();
             key = false;
             return points;
         } catch (InputMismatchException e) {
             System.out.println("Please enter valid numbers😾");

         }
     }
        return 0;
 }
    // method to check and retrieve student ID
    public static int perfectId(int studentId){
        boolean con = true;
        while (con) {
            if (("" + studentId).length() == 9) {
                con = false;
                return studentId;
            } else {
                try {
                    System.out.println("The ID number consists of 9 digits. Type it again😾");
                    Scanner id=new Scanner(System.in);
                    studentId = id.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Please enter valid numbers😾");

                }

            }
        }
        return 0;

    }
    // method to search for the student index in the studentGetData array list
    public static int searchStudentIndex(int id) {
        for (int i = 0; i < studentGetData.size(); i++) {
            UniversityClub student = studentGetData.get(i);
            if (student.getStudentId() == id) {
                return i;
            }
        }
        return -1;
    }

    // method to retrieve order number
    public int orderNumber() {
        boolean key = true;
        while (key) {
            System.out.println("Enter the order number");
            try {
                Scanner number = new Scanner(System.in);
                int oNumber=number.nextInt();
                return oNumber;
            }catch (InputMismatchException e){
                return 0;
            }
        }
        return 0;
    }
}
