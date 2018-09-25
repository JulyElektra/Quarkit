package rc;


public class User {

    String id;
    String password;
    String address;


    public User(String id, String password, String address) {
        this.id = id;
        this.password = password;
        this.address = address;
    }

    public User() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

}
