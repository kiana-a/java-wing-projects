package run.wing.university.model.dao;

import com.google.gson.Gson;
import run.wing.university.model.to.Subject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 11/7/17.
 */
public class SubjectDAO {
    private final String subjectFile = "subjectFile.json";
    private static List<Subject> subjects = new ArrayList<>();

    public static List<Subject> getSubjects() {
        return subjects;
    }

    public SubjectDAO(){
        loadFromFile();
    }


    public void saveSubject(Subject subject){
        subjects.add(subject);
        saveToFile();
    }

    private void saveToFile() {
        try {
            PrintWriter printWriter = new PrintWriter(subjectFile);
            printWriter.write(new Gson().toJson(subjects));
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void loadFromFile() {
        File file = new File(subjectFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            StringBuilder s = new StringBuilder();
            while (scanner.hasNext())
                s.append(scanner.nextLine());

            Subject[] subjectList = new Gson().fromJson(s.toString(), Subject[].class);
            subjects = new ArrayList<>();
            subjects.addAll(Arrays.asList(subjectList));
        } catch (FileNotFoundException e) {
            System.out.println("Grade FIle not found");
        }
    }

    private static Subject findSubject(String subjectId){
        for (Subject subject: SubjectDAO.getSubjects()
                ) {
            if (subject.getSubjectID().equals(subjectId))
                return subject;
        }
        return null;
    }
    public List<Subject> findSubjects(){
        List<Subject> response = new ArrayList<>();
        response.addAll(subjects);
        return response;
    }


    public List<Subject> findSubjects(String subjectId) {
        return new ArrayList<>();


    }
}
