package org.example;

import java.io.*;
import java.util.Scanner;
import org.example.Log.Log;

public class DBMS {
    /**
     *  Main entry point of the program
     * @param args
     */
   public static void main(String[] args) throws IOException {

        Authentication authentication = new Authentication();
        Encryption encryption = new Encryption();
        Log log = new Log();

        System.out.println("===================");
        System.out.println("Welcome to the DBMS");
        System.out.println("===================");

        String filePath = "D:\\#Sem 2 Summer\\DATA\\Assignment 2\\Solution\\Datagitlab\\Assignment2\\User_Credentials.txt";
        File usersFile = new File(filePath);

        if (usersFile.exists()){
         //   System.out.println("Accessing file User_Credentials.txt "+filePath);
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));

                String content = "";

                if((content= bufferedReader.readLine())==null){
                    System.out.println("There is no user at the moment");
                    System.out.println("Let's create a user");
                    String firstusername = "";
                    String firstpswd ="";
                    Scanner scn = new Scanner(System.in);
                    System.out.println("Enter your Username: ");
                    firstusername = scn.nextLine();
                    System.out.println("Enter the password: ");
                    firstpswd = scn.nextLine();

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile,true));
                    bufferedWriter.write("Username:"+"User1"+"~"+"Password:"+"pswd1"+";");
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                }
                else {
                    try {
                    int choice = 0;
                    Scanner scn = new Scanner(System.in);

                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(usersFile,true));
                       do {
                           System.out.println();
                           System.out.println("1. Add a user");
                           System.out.println("2. Login");
                           System.out.println("3. Exit");
                           System.out.print("Enter your choice: ");
                           choice = scn.nextInt();

                           switch (choice) {
                               case 1:
                                   String username = "";
                                   String pswd = "";
                                   scn.nextLine();
                                   System.out.println("Enter new Username: ");
                                   username = scn.nextLine();
                                   System.out.println("Enter the new password: ");
                                   pswd = scn.nextLine();
                                   String hashedPswd = encryption.encryptPassword(pswd);
                                   bufferedWriter2.append("Username:"+username+ "~Password:" + hashedPswd + ";");
                                   bufferedWriter2.newLine();
                                   bufferedWriter2.close();
                                   log.writeToLog("Created new User: "+username);
                                   break;
                               case 2:
                                   System.out.println("Enter Username :");
                                   scn.nextLine();
                                   String Username= scn.nextLine();
                                   System.out.println("Enter Password :");
                                   String UserPassword =scn.nextLine();
                                   System.out.println("Enter your delete query:");
                                   String deletequery = scn.nextLine();
                                   System.out.println("Deleted data successfully");


                                   if(authentication.checkAuthentication(Username,encryption.encryptPassword(UserPassword)))
                                   {
                                       //System.out.println("Logged in Successfully");
                                       // log.writeToLog(Username+" is logged in ");
                                       CurrentUser currentUser = new CurrentUser(Username);
                                       //loadAllUserTables loadAllUserTables = new loadAllUserTables(currentUser);
                                       UserServices userServices = new UserServices(currentUser);

                                       //userServices.UserInterface();
                                       //log.writeToLog("new table testtable created by "+Username);
                                       //userServices.createInsertStructure();
                                       //log.writeToLog("Inserted data into table by "+currentUser.getCurrentusername());
                                      // userServices.selectSatement();
                                      // userServices.ShowTableData("testtable");
                                      // log.writeToLog("Select statement successfull");
                                   }
                                   else{
                                       System.out.println("Credentials Don't Match");
                                   }
                                   break;
                               case 3:
                                   log.writeToLog("User logged out");
                                   System.out.println("Program exited Successfuly");
                                   break;
                               default:
                                   System.out.println("Invalid choice. Please try again.");
                                   break;
                           }
                       }
                        while (choice!=3);
                        scn.close();
                        }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try {
                System.out.println("User credentials file does not exists");
                System.out.println("File didn't exist so creating a new one");
                usersFile.createNewFile();
                System.out.println("Created file at this location :"+filePath);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}