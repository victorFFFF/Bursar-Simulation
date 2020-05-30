/* Victor Li
   CISC 3810
   Professor Benjamin Colven
   12 / 9 / 19
   Final Project 
   This program is the main program that tests all the other java programs to manipulate the Oracle database */

import java.sql.*;

public class MainProgram{

    public static void main (String [] args)
    {
        try{
             Student student = new Student();
             //create table
             student.createStudentTable();  
             //insert 
             student.insertRow("Victor","Li", 23377805,"Computer Science", 3.2,"M",90,"CS","MATH","PHYSICS","ENGINEERING");
             student.insertRow("Jessica","Fleurissaint", 22334477,"Education", 2.2,"F",40,"PSYCHOLOGY","MATH","SPEECH","ENG");
             student.insertRow("Linda", "Li", 12345678, "Nurse", 3.1, "F", 112, "NURSING", "MATH", "ENG", "PSYCHOLOGY");
             //print 
             student.displayStudentTable();
             //delete row
             student.deleteRow(23377805);
             //modify
             student.modifyRow("Credits", 69, 12345678);
             student.modifyRow("StudentID", 12121212, 12345678);
             student.modifyRow("GPA", 2.2, 12345678);
             student.displayStudentTable();
             //student.deleteTable();

            

             Course course = new Course();
             //Create Course table
             course.createCourseTable();
             //insert
             course.insertRow("ENG", "Professor BEN", "01-JAN-01","01-MAY-01");
             course.insertRow("MATH", "Professor LEE", "01-JAN-01","01-MAY-01");
             course.insertRow("NURSING", "Professor ZWICK", "01-JAN-01","01-MAY-01");
             course.insertRow("ENGINEERING", "Professor MUHAMMED", "01-JUN-01","01-NOV-01");
             course.insertRow("PSYCHOLOGY", "Professor Lin", "01-JUN-01","01-NOV-01");
             course.insertRow("PHYSICS", "Professor JAMES", "01-FEB-02","01-JULY-02");
             course.insertRow("CS", "Professor CONNIE", "01-FEB-02","01-JULY-02");
             course.insertRow("SPEECH", "Professor THOMAS", "01-FEB-02","01-JULY-02");
             //modify
             course.modifyRow("Instructor", "Professor Gomez", "NURSING");
             //delete
             course.deleteRow("CS");
             //print
             course.displayCourseTable();
             //course.deleteTable();

            

            Bursar bursar = new Bursar();
            //create bursar table
            bursar.createBursarTable();
            //insert
            bursar.insertRow(6000, 1500, "Credit Card", 23377805);
            bursar.insertRow(4500, 325, "Cash", 12345678);
            //print
            bursar.displayBursarTable();
            //modify
            bursar.modifyRow("remainingBalance", 123 , 23377805);
            //print
            bursar.displayBursarTable();
            //bursar.deleteTable();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
