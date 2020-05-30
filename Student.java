/* Victor Li
   CISC 3810
   Professor Benjamin Colven
   12 / 9 / 19
   Final Project 
   
   This program is a class that contains method to create and delete table, insert,delete, and modify a row, print the table.
   */

import java.sql.*;  
class Student{  

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String username = "system";
    private String password = "51139115";

        public void createStudentTable(){
        try{  
            //step1 load the driver class  
            Class.forName(driver);  
            //step2 create  the connection object  
            Connection connection = DriverManager.getConnection( url, username, password);  
            //step3 create the statement object  
            Statement statement = connection.createStatement();  

            //step4 execute query  
            statement.executeQuery("create table student (" +
                            " FirstName varchar(30)," + 
                            " LastName varchar(30)," +
                            " StudentID number(20) PRIMARY KEY," +
                            " Major varchar(30)," + 
                            " GPA BINARY_DOUBLE, " +
                            " Check (GPA >= 0.0 AND GPA <= 4.0 )," + 
                            " Gender varchar(10)," +
                            " Credits number(4)," +
                            " Check (Credits >= 0), " + 
                            " Class1 varchar(30)," +
                            " Class2 varchar(30)," +
                            " Class3 varchar(30)," +
                            " Class4 varchar(30) )");

            //step5 close the connection object  
            connection.close();  
            statement.close();   
            System.out.println("Student table has been created.");
            }
            catch(Exception e)
                { 
                System.out.println(e);
                }  
            }

            public void deleteTable()
                {
                    try
                    {
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement();
                        
                        statement.executeUpdate("Drop table student");
                        System.out.println("Student table has been deleted.");

                        connection.close();  
                        statement.close();   
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    } 
                }

            public void insertRow(String firstName, String lastName, int ID, String major, double gpa, String gender, int credits, String class1, String class2, String class3, String class4 )
            {
                try{      
                    //step1 load the driver class  
                    Class.forName(driver);  
                    //step2 create  the connection object  
                    Connection connection = DriverManager.getConnection( url, username, password);  
                    //step3 create the statement object  
                    Statement statement = connection.createStatement();  

                    //Execute sql statement
                    String sql =("insert into student values("+
                    "'" + firstName + "' ," +
                    "'" + lastName + "' ," +
                    ID + " ," +
                    "'" + major + "' ," +
                    gpa + " ," +
                    "'" + gender + "' ," +
                    credits + " ," +
                    "'" + class1 + "' ," +
                    "'" + class2 + "' ," +
                    "'" + class3 + "' ," +
                    "'" + class4 + "' )" );

                    statement.executeUpdate(sql);
                    System.out.println(firstName + " " + lastName + " has been added to Student table.");
                    connection.close();  
                    statement.close();   
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            public void deleteRow(int StudentID)
            {
                try{
                //step1 load the driver class  
                Class.forName(driver);  
                //step2 create  the connection object  
                Connection connection = DriverManager.getConnection( url, username, password);  
                //step3 create the statement object  
                Statement statement = connection.createStatement();  
                statement.executeUpdate("Delete from student " +
                                        "Where StudentID = " + StudentID); 

                                        connection.close();  
                                        statement.close();          
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            
            //Overloading modifyRow (String version)
            //change = the change they want to make
            //Identifier = which row are we making the changes (StudentID)
            public void modifyRow(String column, String change, int Identifier)
            {
                try{
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement(); 

                        statement.executeUpdate("Update student " + 
                                               "SET " + column + " = " + "'" + change + "'" +
                                                 " Where StudentID = " + Identifier);

                                                 connection.close();  
                                                 statement.close();   
                }
                catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            }

            //Overloading modifyRow (int version)
            //change = the change they want to make
            //Identifier = which row are we making the changes (StudentID)
            public void modifyRow(String column, int change, int Identifier)
            {
                try{
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement(); 

                        statement.executeUpdate("Update student " + 
                                               "SET " + column + " = "  + change  +
                                                 " Where StudentID = " + Identifier);
                connection.close();  
                statement.close();   
                }
                catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            }

            
            //Overloading modifyRow (double version)
            //change = the change they want to make
            //Identifier = which row are we making the changes (StudentID)
            public void modifyRow(String column, double change, int Identifier)
            {
                try{
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement(); 

                        statement.executeUpdate("Update student " + 
                                               "SET " + column + " = "  + change  +
                                                 " Where StudentID = " + Identifier);

                                        connection.close();  
                                        statement.close();   
                }
                catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            }

            public void displayStudentTable()
            {
                try{
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement(); 
                        
                        String sql = "Select * from student";

                        ResultSet rs = statement.executeQuery(sql);

                        //Array containing column name
                        String array[] = new String[12];
                        array[1] = "firstName : ";
                        array[2] = "lastName : ";
                        array[3] = "ID : ";
                        array[4] = "major : ";
                        array[5] = "GPA : "; 
                        array[6] = "gender : ";
                        array[7] = "credits : ";
                        array[8] = "class1 : ";
                        array[9] = "class2 : ";
                        array[10] = "class3 : ";
                        array[11] = "class4 : ";

                        //print table
                        System.out.println("\n\n\nStudent table");
                        System.out.println("---------------------------------------------------------------------------------------------");
                         while(rs.next())
                         {
                            for(int i = 1; i <= 11; i++)
                            {
                                if(i == 5)
                                System.out.println(array[i] + rs.getDouble(i) + "\t\t");
                                else
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