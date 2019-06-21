package run.wing.university.model.dao;

import com.google.gson.Gson;
import run.wing.university.model.to.Prof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 10/28/17.
 */
public class ProfDAO {


    private final String profFile = "profFile.json";
    private static List<Prof> profs = new ArrayList<>();

    public static List<Prof> getProfs() {
        return profs;
    }

    public static void setProfs(List<Prof> profs) {
        ProfDAO.profs = profs;
    }

    public ProfDAO(){
        loadFromFile();
    }
    public void saveProf(Prof prof){
        profs.add(prof);
        saveToFile(profs);
    }
    public void saveAllProf(List<Prof> profList){
        profs.addAll(profList);
        saveToFile(profList);
    }

    public void saveToFile(List<Prof> profList) {
        try {
            PrintWriter printWriter = new PrintWriter(profFile);
            printWriter.write(new Gson().toJson(profList));
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void loadFromFile() {
        File file = new File(profFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                Prof[] profArray = new Gson().fromJson(s, Prof[].class);
                profs = new ArrayList<>();
                profs.addAll(Arrays.asList(profArray));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static Prof findProf(String profId){
            for (Prof prof: ProfDAO.getProfs()
                 ) {
                if (prof.getProfId().equals(profId))
                    return prof;
            }
        return null;
        }
        public List<Prof> findProfs(){
            List<Prof> response = new ArrayList<>();
            response.addAll(profs);
            return response;
        }


}
