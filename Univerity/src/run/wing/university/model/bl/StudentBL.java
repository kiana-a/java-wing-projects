package run.wing.university.model.bl;

import run.wing.university.model.dao.StudentDAO;
import run.wing.university.model.to.Grade;
import run.wing.university.model.to.Student;

import java.util.List;

/**
 * Created by kiana on 10/25/17.
 */
public class StudentBL {

    private StudentDAO studentDAO;
    private GradeBL gradeBL;

    public StudentBL(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentBL() {

    }

    public  List<Student> getStudents(){
        return studentDAO.findStudents();
    }

    public void saveStudents(List<Student> students){
        for (Student student: students) {
            if(student.getStudentID().length() != 9){
                    students.remove(student);
            }
        }

        studentDAO.saveAll(students);
    }

    public Float getStudentAverage(String studentID){
        float sumGrade = 0;
        int count = 0;
        List<Grade> studentGrades = gradeBL.getGrades(studentID);
        for (Grade grade : studentGrades
             ) {
            sumGrade += grade.getGrade();
            count++;
        }
        return sumGrade/count;
    }
    public Student getStudentByID(String studentID){
        return studentDAO.findStudent(studentID);
    }

    public boolean getStudentByID() {
    }


//    for(Student student : students: j++ ){
//        for (Student gradeList: : i++
//             ) {
//            sum += grade
//        }
//
//    }
}
