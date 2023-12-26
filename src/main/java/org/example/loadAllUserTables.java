package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class loadAllUserTables {

    private CurrentUser currentUser;
    private List<String> allUserTables= new ArrayList<String>();

    /**
     * constructor
     * @param currentUser
     */
    public loadAllUserTables(CurrentUser currentUser) {
        this.currentUser=currentUser;
        loadUsers(currentUser);
    }

    /**
     * loads all the user tables from the text file
     * @param currentUser
     * @return allUserTables
     */
    public  List<String> loadUsers(CurrentUser currentUser){
        try
        {
            Path path= Paths.get("src/main/resources/Database/"+currentUser.getCurrentusername()+"/"+currentUser.getCurrentusername()+"Tables.txt");

            FileReader fileReader = new FileReader(path.toFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line=bufferedReader.readLine())!=null){
                String[] userTables = line.split(";");
                for (String userTableinfo : userTables) {
                    //String[] userTable = userTableinfo.split("Table:");
                    String tablename = userTableinfo.trim().substring("Table:".length());
                    allUserTables.add(tablename);
                }
            }

            for (int i = 0; i <allUserTables.size() ; i++) {
            System.out.println(allUserTables.get(i));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return allUserTables;
    }
}