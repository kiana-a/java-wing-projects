/**
 * Created by kiana on 1/22/18.
 */
public class User {
    private String name;
    private String fname;


    public User(String name, String fname) {
        this.name = name;
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
