package org.example.Regex;

import org.example.Table.Columns;
import org.example.Table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    String createQuery;
    List<Columns> columnsList = new ArrayList<Columns>();
    String InsertRegex = "^(?i)(insert into)\\s+(\\w+)\\s*\\((.*)\\);$";
    String createRegex = "^(?i)(Create Table)\\s+(\\w+)\\s*\\((.*)\\);$";
    String selectRegex = "^(?i)(select \\* from) (\\w+)\\s*;$";

    /**
     * empty constructor
     */
    public Regex() {
    }

    /**
     * Constructor
     * @param query
     */
    public Regex(String query) {
        this.createQuery = query;
    }

    /**
     * checks if create query is in proper syntax
     * @return
     */
    public Table checkCreate(){

            Pattern pattern = Pattern.compile(createRegex);
            Matcher matcher = pattern.matcher(createQuery);

            if (matcher.matches()) {
                    System.out.println("Valid CREATE TABLE query.");
                    String tableName = matcher.group(2);
                    String columnDefinition = matcher.group(3);
                    System.out.println("THe table name fo creating table is " + tableName + "\n"+"The column definiations are: "+columnDefinition);

                    columnsList = extractColumnInfo(columnDefinition);
                    Table t1 = new Table(tableName,columnsList);
                    return  t1;

                } else {
                    System.out.println("Invalid CREATE TABLE query.");
                }
        return null;
    }

    /**
     * extracting info for columns
     * @param columnDef
     * @return
     */
    public  List<Columns> extractColumnInfo(String columnDef){

                String[] columns = columnDef.split(",\\s*");


                for(int i =0 ; i <columns.length;i++){
                String[] str = columns[i].split(" ");
                    String dataType = str[1];
                    String columnName = str[0];
                    Columns col = new Columns(dataType,columnName);
                    columnsList.add(col);

                }

                return columnsList;
            }

    /**
     * checks if data can be inserted or not
      * @param insertQuery
     * @return
     */
    public boolean checkInsert(String insertQuery) {

        Pattern pattern = Pattern.compile(InsertRegex);
        Matcher matcher = pattern.matcher(insertQuery);

        if(matcher.matches()){
            System.out.println("insert query matches");
            return true;
        }else{
            System.out.println("insert query not matching");
        }

        return false;
    }

    /**
     * checks for select query
     * @param selectQuery
     * @return
     */
    public boolean checkSelect(String selectQuery) {
        Pattern Selectpattern = Pattern.compile(selectRegex);
        Matcher Selectmatcher = Selectpattern.matcher(selectQuery);

        if(Selectmatcher.matches()){
            System.out.println("Select query is proper");
            return true;
        }else{
            System.out.println("Select query's syntax is not proper");
        }

        return  false;
    }

    /**
     * extracting the values from the insert query
     * @param insertQuery
     * @return
     */
    public String extractInsertValues(String insertQuery) {

        Pattern Insertpattern = Pattern.compile(InsertRegex);
        Matcher Insertmatcher = Insertpattern.matcher(insertQuery);
        if(Insertmatcher.matches()){
            System.out.println();
        }
        String str = Insertmatcher.group(3);
        System.out.println(str);
        return str;
    }
}