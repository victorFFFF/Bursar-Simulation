/* Victor Li
   CISC 3810
   Professor Benjamin Colven
   12 / 9 / 19
   Final Project 
//   This program is a class that contains method to create and delete table, insert,delete, and modify a row, print the table.


import java.sql.*;

public class Course
{
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String username = "system";
    private String password = "51139115";



    public void createCourseTable()
    {
        try{
            //step1 load the driver class  
            Class.forName(driver);  
            //step2 create  the connection object  
            Connection connection = DriverManager.getConnection( url, username, password);  
            //step3 create the statement object  
            Statement statement = connection.createStatement();  

             //step4 execute query  
             statement.executeQuery("Create table course( " +
                                    " Class varchar(20) PRIMARY KEY," +
                                    " Instructor varchar(30)," +
                                    " Begin date," +
                                    " End date)");
            System.out.println("Course table created.");

            connection.close();  
            statement.close();  
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
    }

    public void deleteTable()
    {
     try{   
                     //step1 load the driver class  
                     Class.forName(driver);  
                     //step2 create  the connection object  
                     Connection connection = DriverManager.getConnection( url, username, password);  
                     //step3 create the statement object  
                     Statement statement = connection.createStatement(); 

                     statement.executeUpdate("drop table course");
                     System.out.println("course table deleted.");

                     connection.close();  
                     statement.close();  
        }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
    }

    public void insertRow(String course, String instructor, String begin, String end)
    {
        try{
                     //step1 load the driver class  
                     Class.forName(driver);  
                     //step2 create  the connection object  
                     Connection connection = DriverManager.getConnection( url, username, password);  
                     //step3 create the statement object  
                     Statement statement = connection.createStatement();  

                     statement.executeUpdate("Insert into course values( '"+
                                             course + "' , '" + 
                                             instructor + "' , '" + 
                                             begin + "' , '" + 
                                             end + "' )" );

                             System.out.println(course +" class has been added to course table.");
                             connection.close();  
                             statement.close();  
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
    }


            public void deleteRow(String className)
            {
                try{
                //step1 load the driver class  
                Class.forName(driver);  
                //step2 create  the connection object  
                Connection connection = DriverManager.getConnection( url, username, password);  
                //step3 create the statement object  
                Statement statement = connection.createStatement();  
                statement.executeUpdate("Delete from course " +
                                        "Where Class = '" + className + "'"); 

                                        connection.close();  
                                        statement.close();   
                System.out.println(className + " has been deleted from the table.");       
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
    


    //Identifier = class name
    public void modifyRow(String column, String change, String Identifier)
    {
        try{
                //step1 load the driver class  
                Class.forName(driver);  
                //step2 create  the connection object  
                Connection connection = DriverManager.getConnection( url, username, password);  
                //step3 create the statement object  
                Statement statement = connection.createStatement(); 

                statement.executeUpdate("Update course " + 
                                       "SET " + column + " = " + "'" + change + "'" +
                                         " Where Class = '" + Identifier + "'");

                                         connection.close();  
                                         statement.close();   
        }
                catch(Exception e)
                    {
                        e.printStackTrace();
                    }
    }


    public void displayCourseTable()
    {
        try{
                //step1 load the driver class  
                Class.forName(driver);  
                //step2 create  the connection object  
                Connection connection = DriverManager.getConnection( url, username, password);  
                //step3 create the statement object  
                Statement statement = connection.createStatement(); 
                
                String sql = "Select * from course";

                ResultSet rs = statement.executeQuery(sql);

                //Array containing column name
                String array[] = new String[12];
                array[1] = "Class : ";
                array[2] = "Instructor : ";
                array[3] = "Begin Date : ";
                array[4] = "End Date : " ;
             
                //print table
                System.out.println("\n\n\nCourse table");
                System.out.println("---------------------------------------------------------------------------------------------");
                 while(rs.next())
                 {
                    for(int i = 1; i <= 4; i++)
                    {
                        System.out.println(array[i] + rs.getString(i) + "\t\t");
                    }
                    System.out.println("----------------------------------------");
                 }
                 connection.close();  
                 statement.close();   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }




}

