package run.wing.university.model.to;

import java.util.Date;

/**
 * Created by kiana on 10/25/17.
 */
public class Grade {
    private Float grade;
    private Date date;
    private Student student;
    private Subject subject;


    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grade(Float grade, Date date, Student student, Subject subject) {
        this.grade = grade;
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", date=" + date +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
