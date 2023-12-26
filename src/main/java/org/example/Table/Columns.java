package org.example.Table;

public class Columns {
    String columnName;
    String columnType;

    String columnData;

    /**
     * Constructor of the Columns entity
     * @param columnName
     * @param columnType
     */
    public Columns(String columnName, String columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getColumnData() {
        return columnData;
    }

    public void setColumnData(String columnData) {
        this.columnData = columnData;
    }

    /**
     * column name getter
     * @return columnName
     */
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

}
