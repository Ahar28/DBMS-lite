package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Authentication {
    String filepath = "D:\\#Sem 2 Summer\\DATA\\Assignment 2\\Solution\\Datagitlab\\Assignment2\\User_Credentials.txt";

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean checkAuthentication(String username,String password){
        try {
             FileReader fileReader = new FileReader(filepath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             String line;

             while ((line=bufferedReader.readLine())!=null){
                 String[] usersTokens = line.split(";");
                 for (String usersToken: usersTokens) {
                     String[] userCredentialParts =  usersToken.split("~");

                     String storedUsername = userCredentialParts[0].trim().substring("Username:".length());
                     String storedPassword = userCredentialParts[1].trim().substring("Password:".length());

                     if (username.equals(storedUsername) && password.equals(storedPassword)) {
                         System.out.println("Successfully logged in ");
                         return true;
                     }
                 }
             }
        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
            return false;
    }
}