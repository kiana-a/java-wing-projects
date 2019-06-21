package run.wing.university.model.dao;

import com.google.gson.Gson;
import run.wing.university.model.to.Grade;

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
public class GradeDAO {
    private final String gradeFile = "gradeFile.json";
    private static List<Grade> grades = new ArrayList<>();

    public static List<Grade> getGrades() {
        return grades;
    }

    public GradeDAO(){
        loadFromFile();
    }
//    List<Grade> Save(Grade grades);

    public void saveGrade(Grade grade){
        grades.add(grade);
        saveToFile();
    }

    private void saveToFile() {
        try {
            PrintWriter printWriter = new PrintWriter(gradeFile);
            printWriter.write(new Gson().toJson(grades));
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void loadFromFile() {
        File file = new File(gradeFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                Grade[] gradeArray = new Gson().fromJson(s, Grade[].class);
                grades = new ArrayList<>();
                grades.addAll(Arrays.asList(gradeArray));

            }
        } catch (FileNotFoundException e) {
            System.out.println("Grade FIle not found");
        }
    }

    public List<Grade> findStudentGrades(String studentID) {
        List<Grade> response = new ArrayList<>();
        for (Grade grade : GradeDAO.getGrades()) {
            if (grade.getStudent().getStudentID().equals(studentID))
                response.add(grade);
        }
        return response;
    }




}
