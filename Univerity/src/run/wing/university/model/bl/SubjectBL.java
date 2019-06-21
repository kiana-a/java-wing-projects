package run.wing.university.model.bl;

import run.wing.university.model.dao.SubjectDAO;
import run.wing.university.model.to.Grade;
import run.wing.university.model.to.Subject;

import java.util.List;

/**
 * Created by kiana on 11/7/17.
 */
public class SubjectBL {
    //میانگین بگیره.
    private SubjectDAO subjectDAO;

    public SubjectBL(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public SubjectBL() {

    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public Float getSubjectAverage(String subjectId){
        float sumGrade = 0;
        int count = 0;
        GradeBL gradeBL = null;
        List<Grade> subjectGrades = gradeBL.getGrades(subjectId);
        for (Grade grade : subjectGrades
                ) {
            sumGrade += grade.getGrade();
            count++;
        }
        return sumGrade/count;
    }
    public List<Subject> getSubjectByID(String subjectId){
        return subjectDAO.findSubjects(subjectId);
    }


}
