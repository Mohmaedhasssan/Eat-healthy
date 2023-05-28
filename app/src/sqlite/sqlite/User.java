package ws.idroid.sqlite;

public class User {
    private int id;
    private String USERNAME;
    private String PASSWORD;

    public User(int id,String USERNAME,String PASSWORD ) {
        this.id = id;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }
    public User(String USERNAME,String PASSWORD ) {

        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }


}
