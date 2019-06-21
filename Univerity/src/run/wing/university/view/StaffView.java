
package run.wing.university.view;

import run.wing.university.model.bl.StaffBL;
import run.wing.university.model.to.Staff;
import run.wing.university.model.to.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 10/25/17.
 */
public class StaffView {

    private Scanner scanner;
    StaffBL staffBL;

    List<Staff> staffs;

    public void menu(String id){

        switch (id) {
            default:
                print(
                        "***** MENU *****\n" +
                                "1 - Add Staff\n" +
                                "2 - Show Staff's profile\n" +
                                "3 - Print Staff's Average\n" +
                                "\nMake a choice: "
                );
                menu(scanner.next());
                return;
            case "1":


        }
    }

    private void print(String s) {
        System.out.print(s);
    }



    public void printStaff(Staff staff){
        System.out.println(staff.getClass());
    }

    public void printStaff(List<Staff> staffList){

        Iterable<? extends Staff> staffs = null;
        for (Staff staff : staffs
                ) {
            this.printStaff(staff);
        }
    }

}
