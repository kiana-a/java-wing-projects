package run.wing.university;

import run.wing.university.model.bl.GradeBL;
import run.wing.university.model.bl.ProfBL;
import run.wing.university.model.bl.StudentBL;
import run.wing.university.model.dao.GradeDAO;
import run.wing.university.model.dao.ProfDAO;
import run.wing.university.model.dao.StudentDAO;
import run.wing.university.model.to.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created by kiana on 10/25/17.
 */
public class Application {

    private Scanner scanner;
    private StudentBL studentBL;
    private ProfBL profBL;
    private GradeBL gradeBL;

    private List<Student> students;
    private List<Prof> profs;
    private List<Grade> grades;

    protected static void clearConsole() {
        for (int i = 0 ; i < 30 ; ++i )
            print("\n");
    }
    private void pressAnyKey() {
        System.out.println("Press Enter key to Continue ...");
        try{
            System.in.read();
        } catch (Exception e){

        }
    }
    public static void print(String str){
        System.out.println(str);
    }
    public void handleMenu(){
        menu("");
    }

    private void menu(String id) {
        clearConsole();
        switch (id){
            default:
                print(
                        "****** MENU ******\n" +
                                "1 - Print Students\n" +
                                "2 - Print Profs\n" +
                                "3 - Print Grades\n" +
                                "\nMake a choice: "
                );
                menu(scanner.next());
                return;
            case "3":
                grades = gradeBL.getGrades("9511130040");
                for (Grade grade: grades)
                    System.out.println(grade.getDate() + " " + grade.getStudent() + " " + grade.getGrade() + " " + grade.getSubject() );
                pressAnyKey();
                break;

            case "1":
                students = studentBL.getStudents();
                for (Student student : students
                     ) {
                        System.out.println(student.getName() + " " + student.getFname() + " " + student.getStudentID()
                        + " " + student.getFieldOfStudy() + " " + student.getSubject());
                }
                pressAnyKey();
                break;

        }
        handleMenu();
    }
    public Application(){
        scanner = new Scanner(System.in);
        studentBL = new StudentBL(new StudentDAO());
        profBL = new ProfBL(new ProfDAO());
        gradeBL = new GradeBL(new GradeDAO());

        students = new ArrayList<>();
        profs = new ArrayList<>();
        grades = new ArrayList<>();

    }

    public static void main(String[] args) {

        Application application = new Application();
        application.handleMenu();

//
////        StudentDAO studentDAO = new StudentDAO();
//////        studentDAO.save(new Student("kiana", "Ahmadi","951113004", FieldOfStudy.SOFTWARE_ENG));
////        List<Student> students =  studentDAO.findStudents();
////        for (Student student:students) {
////            System.out.println(student.getName()+ " " + student.getFname() + " " + student.getStudentID() + " " + student.getFieldOfStudy());
////        }
//
//        StudentBL studentBL = new StudentBL(new StudentDAO());
//        ProfBL profBL = new ProfBL(new ProfDAO());
//        GradeBL gradeBL = new GradeBL(new GradeDAO());
//
//        gradeBL.save(new Grade(16.0f, new Date(), studentBL.getStudentByID("951113004"),
//                new Subject("Physic1", "1002", "1")));
//
//        List<Grade> grades = gradeBL.getGrades("951113004");
//        for (Grade grade : grades) {
//            System.out.println(grade.getDate() + " " + grade.getStudent() + " " + grade.getGrade() + " " + grade.getSubject());
//        }
//        List<Prof> list = new ArrayList<>();
//        list.add(new Prof("karimin123","Mohammad", "Karimian",new Subject("Physic1","1002","1") ) );
//        profBL.saveProfs(list);

    }
}