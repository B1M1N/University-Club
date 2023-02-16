package org.example;

public class UniversityClubTest {
    public static void main(String[] args) {
        Print print1 = new Print();// create a new instance of the Print class
        Admin admin1 =new Admin();// create a new instance of the Admin class
        Help help1 = new Help();// create a new instance of the Help class
        Student student1 = new Student();// create a new instance of the Student class
        int order;
        System.out.println("Welcome to the university club 😎");
        do {
            print1.printCommands();// call the printCommands method to display available commands
            order=help1.orderNumber();// call the orderNumber method to get the user's selected command
            switch (order){
                case 1 -> {
                if (admin1.adminlogin()) { // if the admin successfully logs in
                    do {
                        print1.printCommandsAdmin(); // display available admin commands
                        order = help1.orderNumber(); // get the selected admin command
                        switch (order) {
                            case 1 -> {
                                admin1.addPoints(); // call the addPoints method to add points
                            }
                            case 2 -> {
                                admin1.pointsDeduction(); // call the pointsDeduction method to deduct points
                            }
                            case 3 -> {
                             print1.printStudent(); // call the printStudent method to display student information
                            }
                            case 4 -> {
                                print1.printAllElements(); // call the printAllElements method to display all elements
                            }
                            case 5 -> {
                                print1.printStudentTableAdmin(); // call the printStudentTableAdmin method to display the student table
                            }
                            case 6 -> {
                                admin1.deleteStudentAdmin(); // call the deleteStudentAdmin method to delete a student
                            }
                            case 7 -> {} // exit the loop
                            default -> {
                                // Error message for entering an invalid command
                                System.out.println("The order number is out of range😾.\n Please enter the application number mentioned in front of you");
                            }
                        }
                    } while (order != 7);
                    // Logout message for the admin
                    System.out.println("You have been logged out😿");
                    System.exit(0);
                }else {
                    // Error message for exceeding the login attempts limit
                    System.out.println("You have exceeded the attempts limit😾,\nYou will return to the previous menu");
                }

                }
                case 2 ->{
                    // Student menu options
                    do{
                    print1.printCommandsStudent(); // display available student commands
                    order=help1.orderNumber();  // get the selected student command
                    switch (order) {
                        case 1 -> {
                        int id= student1.searchStudentID(); // call the searchStudentID method to search for a student's ID
                        if (id>0){
                            // Sub-menu for the student after logging in
                            do {
                                print1.printCommandsStudentِAvailable();// display available student commands when a student's ID is found
                                order=help1.orderNumber();// get the selected student command
                                switch (order) {
                                    case 1 -> {
                                    print1.printStudent(id); // call the printStudent method to display the student information
                                    }
                                    case 2 -> {
                                        print1.printStudentTable();// call the printTeacherTable method to display the table of all teachers
                                    }
                                    case 3 -> {} // exit the loop
                                    default -> {
                                        System.out.println("The order number is out of range😾.\n Please enter the application number mentioned in front of you");
                                    }
                                }

                            }while (order!=3);
                            System.out.println("You have been logged out😿");
                            System.exit(0);
                        }

                        }
                        case 2 -> {
                            student1.studentData(); // call the studentData method to display student information
                        }
                        case 3 -> {}
                        default -> {
                            System.out.println("The order number is out of range😾.\n Please enter the application number mentioned in front of you");
                        }
                    }


                    }while (order!=3);
                    System.out.println("You have been logged out😿");
                        System.exit(0);

                    }
                case 3 -> {} // exit the loop

                default -> {
                    System.out.println("The order number is out of range😾.\n Please enter the application number mentioned in front of you");
                }
                }





        }while (order!=3);
        System.out.println("You have been logged out😿");

    }

}