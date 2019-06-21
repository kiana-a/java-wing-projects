package run.wing.university.view;

import run.wing.university.model.bl.SubjectBL;
import run.wing.university.model.dao.SubjectDAO;
import run.wing.university.model.to.Prof;
import run.wing.university.model.to.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 11/11/17.
 */
public class SubjectView {

private Scanner scanner;
SubjectDAO subjectDAO = new SubjectDAO();
private SubjectBL subjectBL = new SubjectBL();
List<Subject> subjects = new ArrayList<>();

    public void menu(String id){

        switch (id) {
            default:
                print(
                        "***** MENU *****\n" +
                                "1 - Add Subject\n" +
                                "2 - Show Subject Average\n" +
                                "\nMake a choice: "
                );
                menu(scanner.next());
                return;
            case "1":
                String subjectName = scanner.next();
                String subjectId = scanner.next();
                String term = scanner.next();
                String prof = scanner.next();
                break;
            case "2":

                System.out.println(subjectBL.getSubjectAverage(subjectId));
                break;
        }
    }

    private void print(String s) {
        System.out.print(s);
    }






    private List<Subject> subjectList;

    public void printSubject(Subject subject){
        System.out.println(subject.getClass());
    }

    public void printSubject(List<Subject> subjectList){
        this.subjectList = subjectList;

        Iterable<? extends Subject> subjects = null;
        assert subjects != null;
        for (Subject subject : subjects
                ) {
            this.printSubject(subject);
        }
    }



}
