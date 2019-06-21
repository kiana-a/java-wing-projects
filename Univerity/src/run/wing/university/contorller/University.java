package run.wing.university.contorller;

import com.google.gson.Gson;
import run.wing.university.model.to.Prof;
import run.wing.university.model.to.Staff;
import run.wing.university.model.to.Student;
import run.wing.university.model.to.Subject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by kiana on 10/25/17.
 */
public class University {
    private static University ourInstance = new University();

    public static University getInstance() {
        return ourInstance;
    }
    public final String universityFile = "studentFile.json";
    private University() {
    }
    private List<Prof> profList = new ArrayList<>();
    private List<Subject> subjectList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    private List<Staff> jobList = new ArrayList<>();
    private List<Student> gradeList = new ArrayList<>();
    private Integer average;



    public void addSubject(Subject subject){
        for ( subject: subjectList
             ) {
            subjectList.add(subject);
        }

    }


    public void addStudent(Student student){
        for ( student: studentList
             ) {
            studentList.add(student);

        }
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Prof> getProfList() {
        return profList;
    }

    public void setProfList(List<Prof> profList) {
        this.profList = profList;
    }




    public List<Staff> getJobList() {
        return jobList;
    }

    public void setJobList(List<Staff> jobList) {
        this.jobList = jobList;
    }

    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public List<Student> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Student> gradeList) {
        this.gradeList = gradeList;
    }
}
