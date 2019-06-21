package run.wing.university.model.bl;

import run.wing.university.model.dao.GradeDAO;
import run.wing.university.model.to.Grade;

import java.util.List;

/**
 * Created by kiana on 10/25/17.
 */
public class GradeBL {

    private GradeDAO gradeDAO;

//    public  List<Grade> getGrades() {
//        return gradeDAO.findStudentGrades();
//    }
//


    public GradeBL(GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }

    public void save(Grade grade){
        gradeDAO.saveGrade(grade);
    }

    public List<Grade> Save(List<Grade> grades){
        for (Grade grade: grades
             ) {
            if(grades.size() > 00.0 && grades.size() < 20.0){
                return grades;
                //agar ba shart ok bud b dao pass bede

            }
        }

        System.out.println("This grade doesn't match the terms ! \n");
        return null;
    }




    public List<Grade> getGrades(String studentID){
        return gradeDAO.findStudentGrades(studentID);
    }

}