package org.example;

public class CurrentUser {
    private String currentusername;


    /**
     *
     * @param currentusername
     */
    public CurrentUser(String currentusername) {
        this.currentusername = currentusername;
        Database database = new Database(currentusername);
        //database.createDatabase(currentusername);
    }

    /**
     *
     * @return
     */
    public String getCurrentusername() {
        return currentusername;
    }

    /**
     * 
     * @param currentusername
     */
    public void setCurrentusername(String currentusername) {
        this.currentusername = currentusername;
    }


}
