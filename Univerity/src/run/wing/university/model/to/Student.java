package run.wing.university.model.to;

import java.util.List;

/**
 * Created by kiana on 10/25/17.
 */
public class Student {
    private String name;
    private String fname;
    private FieldOfStudy fieldOfStudy;
    private List<Subject> subject;
    private String studentID;

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public FieldOfStudy getFielOfStudy() {
        return fieldOfStudy;
    }

    public void setFielOfStudy(FieldOfStudy fielOfStudy) {
        this.fieldOfStudy = fielOfStudy;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
    public Student(String name,String fname, String studentID, FieldOfStudy fieldOfStudy){
        this.name = name;
        this.fname = fname;
        this.studentID = studentID;
        this.fieldOfStudy = fieldOfStudy;
    }

    public Student(String name, String fname, FieldOfStudy fieldOfStudy, List<Subject> subject, String studentID) {
        this.name = name;
        this.fname = fname;
        this.fieldOfStudy = fieldOfStudy;
        this.subject = subject;
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", fieldOfStudy=" + fieldOfStudy +
                ", subject=" + subject +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
