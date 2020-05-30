/* Victor Li
   CISC 3810
   Professor Benjamin Colven
   12 / 9 / 19
   Final Project 
//  This program is a class that contains method to create and delete table, insert,delete, and modify a row, print the table.


import java.sql.*;

    public class Bursar{

        private String driver = "oracle.jdbc.driver.OracleDriver";
        private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        private String username = "system";
        private String password = "51139115";
    

                public void createBursarTable()
                {
                    try{
                        //step1 load the driver class  
                        Class.forName(driver);  
                        //step2 create  the connection object  
                        Connection connection = DriverManager.getConnection( url, username, password);  
                        //step3 create the statement object  
                        Statement statement = connection.createStatement();  

                        statement.executeQuery("create table bursar ( "+
                                               "totalBalance number(10), " + 
                                               "remainingBalance number(10), " +
                                               "check (remainingBalance <= totalBalance), " + 
                                               "paymentType varchar(20), " +
                                               "StudentID number(20) PRIMARY KEY )");
                        System.out.println("Bursar table created.");
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

                                    statement.executeUpdate("drop table bursar");
                                    System.out.println("bursar table deleted.");

                                    connection.close();  
                                    statement.close();  
                        }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                    }

                                
                public void insertRow(int total, int remain, String payType, int studentID)
                {
                    try{
                                //step1 load the driver class  
                                Class.forName(driver);  
                                //step2 create  the connection object  
                                Connection connection = DriverManager.getConnection( url, username, password);  
                                //step3 create the statement object  
                                Statement statement = connection.createStatement();  

                                statement.executeUpdate("Insert into bursar values( "+
                                                        total + " , " + 
                                                        remain + " , '" + 
                                                        payType + "' , " + 
                                                        studentID + " )" );
                                        connection.close();  
                                        statement.close();  
                                System.out.println(studentID + " has been inserted into bursar table.");
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                }


                public void deleteRow(int stuID)
                {
                    try{
                    //step1 load the driver class  
                    Class.forName(driver);  
                    //step2 create  the connection object  
                    Connection connection = DriverManager.getConnection( url, username, password);  
                    //step3 create the statement object  
                    Statement statement = connection.createStatement();  
                    statement.executeUpdate("Delete from bursar " +
                                            "Where StudentID = " + stuID ); 
    
                                            connection.close();  
                                            statement.close();   
                    System.out.println(stuID + " has been deleted from the table.");       
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                
                //Identifier = student id
                public void modifyRow(String column, int change, int Identifier)
                {
                    try{
                            //step1 load the driver class  
                            Class.forName(driver);  
                            //step2 create  the connection object  
                            Connection connection = DriverManager.getConnection( url, username, password);  
                            //step3 create the statement object  
                            Statement statement = connection.createStatement(); 

                            statement.executeUpdate("Update bursar " + 
                                                "SET " + column + " = " + "'" + change + "'" +
                                                    " Where StudentID = '" + Identifier + "'");

                                                    connection.close();  
                                                    statement.close();   
                    }
                            catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                  }
        


                public void displayBursarTable()
                {
                    try{
                            //step1 load the driver class  
                            Class.forName(driver);  
                            //step2 create  the connection object  
                            Connection connection = DriverManager.getConnection( url, username, password);  
                            //step3 create the statement object  
                            Statement statement = connection.createStatement(); 
                            
                            String sql = "Select * from bursar";
            
                            ResultSet rs = statement.executeQuery(sql);
            
                            //Array containing column name
                            String array[] = new String[12];
                            array[1] = "totalBalance : ";
                            array[2] = "remainingBalance : ";
                            array[3] = "paymentType : ";
                            array[4] = "StudentID : " ;
                         
                            //print table
                            System.out.println("\n\n\nBursar table");
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
