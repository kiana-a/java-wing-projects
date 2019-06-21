package run.wing.university.model.dao;

import com.google.gson.Gson;
import run.wing.university.model.to.Staff;

import javax.swing.plaf.PanelUI;
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
public class StaffDAO {

    private final String staffFile = "staffFile.json";
    private static List<Staff> staffs = new ArrayList<>();

    public static List<Staff> getStaffs() {
        return staffs;
    }
    public StaffDAO(){
        loadFromFile();
    }
    public void saveStaff(Staff staff){
        staffs.add(staff);
        List<Staff> staffList = null;
        saveToFile(staffList);
    }
    public void saveAllStaff(List<Staff> staffList){
        staffs.addAll(staffList);
        saveToFile(staffList);
    }

    public void saveToFile(List<Staff> staffList) {
        try {
            PrintWriter printWriter = new PrintWriter(staffFile);
            printWriter.write(new Gson().toJson(staffs));
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void loadFromFile() {
        File file = new File(staffFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                Staff[] staffArray = new Gson().fromJson(s, Staff[].class);
                staffs = new ArrayList<>();
                staffs.addAll(Arrays.asList(staffArray));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Staff findStaff(String staffId){
        for (Staff staff: StaffDAO.getStaffs()
                ) {
            if (staff.getStaffId().equals(staffId))
                return staff;
        }
        return null;
    }
    public List<Staff> findStaffs(){
        List<Staff> response = new ArrayList<>();
        response.addAll(staffs);
        return response;
    }

}
