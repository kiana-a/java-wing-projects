package run.wing.university.view;

import run.wing.university.model.bl.StaffBL;
import run.wing.university.model.bl.StudentBL;
import run.wing.university.model.dao.StudentDAO;
import run.wing.university.model.to.FieldOfStudy;
import run.wing.university.model.to.Student;
import run.wing.university.model.to.Subject;

import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 10/25/17.
 */
public class StudentView {
    private Scanner scanner;
    StudentBL studentBL;

    List<Student> students;

    public void menu(String id){
        StudentDAO studentDAO =new StudentDAO();
        StudentBL studentBL = new StudentBL();

        switch (id) {
            default:
                print(
                        "***** MENU *****\n" +
                                "1 - Add Student\n" +
                                "2 - Show Student profile\n" +
                                "3 - Print Student Average\n" +
                                "\nMake a choice: "
                );
                menu(scanner.next());
                return;
            case "1":
                String name = scanner.next();
                String fname = scanner.next();
                String studentID = scanner.next();
                String subject = scanner.next();
                String fieldOfStudy = scanner.next();
                break;
            case "3":
                Float studentAverage = studentBL.getStudentAverage(studentID);
                break;
            case "2":

                System.out.println(studentBL.getStudentByID());
                break;
        }
    }

    private void print(String s) {
        System.out.print(s);
    }


    public void printStudent(Student student){
        System.out.println(student.getClass());

    }
    public void printStudents(List<Student> students){
        for (Student student : students
             ) {
            this.printStudent(student);
        }
    }


}
