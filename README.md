# University-Club

About

The code defines a Java class named "UniversityClub" which represents a student club at a university. The class has three private fields to store student information: "studentName" (for the student's name), "studentId" (for the student's ID number), and "studentPoints" (for the number of points earned by the student in the club).

To access and modify these fields, the class provides three public getter and setter methods (getStudentName, setStudentName, getStudentId, setStudentId, getStudentPoints, and setStudentPoints). These methods allow other classes or code to retrieve or modify the student information stored in the UniversityClub object.

The "setStudentPoints" method returns a "UniversityClub" object, but it does not need to since it only updates the "studentPoints" field and does not return anything useful. It would be more appropriate to change the return type to "void".
