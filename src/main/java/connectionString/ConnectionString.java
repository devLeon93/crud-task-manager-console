package connectionString;

public class ConnectionString {

    private   String  dbUrl ="jdbc:mysql://localhost:3306/task_manager_db";
    private   String  dbUser ="task_user";
    private   String  dbPass ="root93";


    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }
}
