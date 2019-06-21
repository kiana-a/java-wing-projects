package run.wing.model.to;

import java.util.Date;

/**
 * Created by kiana on 12/26/17.
 */
public class Person {
    private String fname;
    private int id;  //vip
    private String lname;
    private int age;
    private Date createdAt;
//    private Date updatedAt;
//    private Date deletedAt;


    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public Person(String fname, int id, String lname, int age, Date createdAt) {
        this.fname = fname;
        this.id = id;
        this.lname = lname;
        this.age = age;
        this.createdAt = createdAt;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Person{" +
                "fname='" + fname + '\'' +
                ", id=" + id +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }
}
