package org.example.Table;

import java.util.List;

public class Table {
String tableName;
List<Columns> columnsListTable;


    public Table(String tableName, List<Columns> columnsListTable) {
        this.tableName = tableName;
        this.columnsListTable = columnsListTable;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * returns list of Column(entity)
     * @return
     */
    public List<Columns> getColumnsListTable() {
        return columnsListTable;
    }

    public void setColumnsListTable(List<Columns> columnsListTable) {
        this.columnsListTable = columnsListTable;
    }
}