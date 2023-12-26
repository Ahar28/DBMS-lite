package org.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Database {
    /**
     *
     * @param userName
     */
    public Database(String userName) {
    createDatabase(userName);
    UserTables userTables = new UserTables(userName);
    }

    /**
     *
     * @param databaseName
     */
    public void createDatabase(String databaseName){
        Path path = (Path) Paths.get("src/main/resources");
        File theDir = new File(path+"/Database/"+databaseName);
        if (!theDir.exists()){
            theDir.mkdirs();
        }

    }
}