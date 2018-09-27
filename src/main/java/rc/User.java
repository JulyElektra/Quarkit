package rc;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    String id;
    String password;
    String address;


    public User(String id, String password, String address) {
        this.id = id;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.address = address;
    }

    public User() {

    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getPassword() {
//        return password;
//    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
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
