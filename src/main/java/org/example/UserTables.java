package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserTables {
    /**
     * constructor
     * @param userName
     */
    public UserTables(String userName) {
        createTables(userName);
    }

    /**
     * creating table file
     * @param userName
     */
    public void createTables(String userName){

        Path path = Paths.get("src/main/resources/Database/");
        File fileUserTables = new File(path+"/"+userName+"/"+userName+"Tables.txt");
        if (!fileUserTables.exists()){
           try {
               fileUserTables.createNewFile();
               BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileUserTables));
               bufferedWriter.write("Table:;");
               bufferedWriter.newLine();
               bufferedWriter.close();

           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        }
    }
}