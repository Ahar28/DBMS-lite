package org.example.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Log{

    public Log() throws IOException {
        makeLogFolder();
    }






    public void makeLogFolder() throws IOException {
        Path path = (Path) Paths.get("src/main/resources");
        File theDir = new File(path + "/Database");

        if (!theDir.exists()) {
            theDir.mkdirs();
        }else{
        makeLogFile();
        }
    }

    public  void makeLogFile() throws IOException {
        Path filepath = Paths.get("src/main/resources/");
        File logFile = new File(filepath+"/Log.txt");


        if(!logFile.exists()){
            logFile.createNewFile();
        }
    }


    public  void writeToLog(String loggingContent) throws IOException {
        Path filepath = Paths.get("src/main/resources/");
        File logFile = new File(filepath+"/Log.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile,true));
            bufferedWriter.append(loggingContent);
            bufferedWriter.newLine();
            bufferedWriter.close();
        //System.out.println(loggingContent);
    }
}