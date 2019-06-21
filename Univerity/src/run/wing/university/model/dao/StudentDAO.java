package run.wing.university.model.dao;

import com.google.gson.Gson;
import run.wing.university.model.to.Prof;
import run.wing.university.model.to.Staff;
import run.wing.university.model.to.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 10/25/17.
 */
public class StudentDAO {

    private final String studentFile = "studentFile.json";
    private static List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        StudentDAO.students = students;
    }

    public StudentDAO(){
        loadFromFile();
    }


    public void save(Student student){
        students.add(student);
        saveToFile();
    }

    public void saveAll(List<Student> studentList){
        students.addAll(studentList);
        saveToFile();
    }

    private void saveToFile() {
        try {
            PrintWriter printWriter = new PrintWriter(studentFile);
            printWriter.write(new Gson().toJson(students));
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File file = new File(studentFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                Student[] studentArray = new Gson().fromJson(s, Student[].class);
                students = new ArrayList<>();
                students.addAll(Arrays.asList(studentArray));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student findStudent(String studentID) {
        for (Student student : StudentDAO.getStudents()
                ) {
            if (student.getStudentID().equals(studentID))
                return student;
        }
        return null;
    }

    public List<Student> findStudents(){
        List<Student> response = new ArrayList<>();
        response.addAll(students);
        return response;
    }

}
