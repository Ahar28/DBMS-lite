package org.example;

import org.example.Regex.Regex;
import org.example.Table.Table;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserServices {

    private CurrentUser currentUser;

    Table t1;

    /**
     * Constructor
     * @param currentUser
     */
    public UserServices(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * method
     */
    public void UserInterface() {
        createTableStructure();
    }


    /**
     * creating the structure for the table
     */
    private void createTableStructure(){
        try {
            Path path = Paths.get("src/main/resources/Database/" + currentUser.getCurrentusername() + "/" + currentUser.getCurrentusername() + "Tables.txt");
            FileReader fileReader = new FileReader(path.toFile());
            Scanner scn = new Scanner(System.in);
            System.out.println("Write your Query to create table: ");
            // String query = scn.nextLine();
            String query = "create table testtable (int id,String name,String name 2,int no);";
            System.out.println(query);
       /*   CreateTable createTable = new CreateTable();
            createTable.createTable();   */
            Regex regex = new Regex(query);
            t1 = regex.checkCreate();

            creatingTable(t1);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * creating table
     * @param t1
     */
    private void creatingTable(Table t1) {
        Path pathtoCreateTable = Paths.get("src/main/resources/Database/" + currentUser.getCurrentusername());
        File filenewTables = new File(pathtoCreateTable + "/" + t1.getTableName() + ".txt");
        if (!filenewTables.exists()) {
            try {
                filenewTables.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filenewTables));
                for (int i = 0; i < t1.getColumnsListTable().size(); i++) {
                    bufferedWriter.write(t1.getColumnsListTable().get(i).getColumnName());
                    bufferedWriter.write("\t\t");
                }
                bufferedWriter.newLine();
                bufferedWriter.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * creating Insert Structure
     * @throws IOException
     */
    public void createInsertStructure() throws IOException {
        System.out.println("Write your Query to Insert data into table: ");
        Scanner scn = new Scanner(System.in);
        String query = scn.nextLine();
        String insertQuery = "insert into testtable (46,valentino,rossi,93);";

        Regex regexInsert = new Regex();
        if (regexInsert.checkInsert(insertQuery)){
            System.out.println("Insert query is proper");
            String extractedInsertValues = regexInsert.extractInsertValues(insertQuery);
            InsertrowviaString(extractedInsertValues);
        }
    }


    /**
     * inserting row in the tables
     * @param extractedValues
     * @throws IOException
     */
    private void InsertrowviaString(String extractedValues) throws IOException {
        Path pathtoInsertInTable = Paths.get("src/main/resources/Database/" + currentUser.getCurrentusername()+"/"+t1.getTableName()+".txt");

        BufferedWriter dataToWriteInFile = new BufferedWriter(new FileWriter(pathtoInsertInTable.toFile(),true));
        String[] insertValues = extractedValues.split(",");
        for (int i = 0; i < insertValues.length; i++) {

            dataToWriteInFile.write(insertValues[i]+"\t\t");
        }
        dataToWriteInFile.newLine();
        dataToWriteInFile.close();

    }

    /**
     * select statement
     */
    public void selectSatement() {
        System.out.println("Write your Query to See data from the table: ");
        Scanner scn = new Scanner(System.in);
        String query = scn.nextLine();
        String selectQuery = "select * from testtable   ;";

        Regex regexSelect = new Regex();
        if(regexSelect.checkSelect(selectQuery)){
            System.out.println("Select Query is Proper");
        }

    }

    /**
     * showing table data
     * @param tableName
     * @throws IOException
     */
    public void ShowTableData(String tableName) throws IOException {
        Path pathtoGetfromTable = Paths.get("src/main/resources/Database/" + currentUser.getCurrentusername()+"/"+ tableName +".txt");

        FileReader fileReader = new FileReader(pathtoGetfromTable.toFile());

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while ((line = bufferedReader.readLine())!=null){
            System.out.println("Line"+line);
        }
    }
}