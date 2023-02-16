package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

// This class provides methods for saving, retrieving, updating and deleting student data from a text file
public class StudentDataFile extends Student {
    // The name of the student data file
    private static final String FILE_NAME = "student_data.txt";

    // A method to save the student information to a file
    public static void saveStudentData(UniversityClub club) {
        try {
            // Open the file for appending
            FileWriter writer = new FileWriter(FILE_NAME, true);
            // Write the student information to the file
            writer.write(club.getStudentName() + "," + club.getStudentId() + "," + club.getStudentPoints() + "\n");
            // Close the file
            writer.close();
        } catch (IOException e) {
            // Print an error message if the data could not be saved to the file
            System.out.println("Error saving data to file.");
        }
    }



    // A method to retrieve all the student information from the file
    public static Vector<UniversityClub> getAllStudentData() {
        // Create a vector to store the student information
        Vector<UniversityClub> clubs = new Vector<UniversityClub>();
        try {
            // Open the file for reading
            Scanner scan = new Scanner(new File(FILE_NAME));
            // Read the data from the file line by line
            while (scan.hasNextLine()) {
                String[] data = scan.nextLine().split(",");
                UniversityClub club = new UniversityClub();
                club.setStudentName(data[0]);
                club.setStudentId(Integer.parseInt(data[1]));
                club.setStudentPoints(Integer.parseInt(data[2]));
                clubs.add(club);
            }
            // Close the file
            scan.close();
        } catch (IOException e) {
            // Print an error message if the data could not be retrieved from the file
            System.out.println("Error retrieving data from file.");
        }
        // Print an error message if the data could not be retrieved from the file
        return clubs;
    }

    // A method to add points to a student's record by ID
    public static boolean studentAddPointsById(int id, int Points) {
        // Iterate over the student data
        for (UniversityClub club : studentGetData) {
            // Check if the student ID matches the ID provided
            if (club.getStudentId() == id) {
                // Check if the student ID matches the ID provided
                club.setStudentPoints(club.getStudentPoints()+Points);
                try {
                    // Open the file for writing, overwriting the previous contents
                    PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME, false));
                    // Write the updated student data to the file
                    for (UniversityClub c : studentGetData) {
                        writer.println(c.getStudentName() + "," + c.getStudentId() + "," + c.getStudentPoints());
                    }
                    // Close the file
                    writer.close();
                    // Return true if the update was successful
                    return true;
                } catch (FileNotFoundException e) {
                    // Print an error message if the data
                    System.out.println("Error updating data in the file.");
                }
            }
        }
        // return false to indicate failure if the student was not found
        return false;
    }
    // function to subtract points from a student's record based on their id
    public static boolean studentDelPointsById(int id, int Points) {
        for (UniversityClub club : studentGetData) {
            if (club.getStudentId() == id) {
                // subtract the given number of points from the student's current points
                club.setStudentPoints(club.getStudentPoints()-Points);
                try {
                    // write the updated student data to the file
                    PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME, false));
                    for (UniversityClub c : studentGetData) {
                        writer.println(c.getStudentName() + "," + c.getStudentId() + "," + c.getStudentPoints());
                    }
                    writer.close();
                    // return true to indicate success
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("Error updating data in the file.");
                }
            }
        }
        // return false to indicate failure if the student was not found
        return false;
    }

    // function to delete a student's record based on their id
    public static boolean deleteStudent(int id) {
        Vector<UniversityClub> clubs = getAllStudentData();
        int index = -1;
        // find the index of the student with the given ID
        for (int i = 0; i < clubs.size(); i++) {
            if (clubs.get(i).getStudentId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Student not found.");
            return false;
        }
        // remove the student from the list
        clubs.remove(index);
        studentGetData.remove(Help.searchStudentIndex(id));
        try {
            // write the updated list of students to the file
            PrintWriter writer = new PrintWriter(new File(FILE_NAME));
            for (UniversityClub club : clubs) {
                writer.println(club.getStudentName() + "," + club.getStudentId() + "," + club.getStudentPoints());
            }
            writer.close();
            // return true to indicate success
            return true;
        } catch (IOException e) {
            System.out.println("Error deleting student.");
            // return false to indicate failure if the student was not found
            return false;
        }
    }



}
