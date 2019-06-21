package run.wing.university.view;

import run.wing.university.model.bl.ProfBL;
import run.wing.university.model.dao.ProfDAO;
import run.wing.university.model.to.Prof;

import java.util.List;
import java.util.Scanner;

/**
 * Created by kiana on 11/11/17.
 */
public class ProfView {



    private Scanner scanner;
    ProfBL profBL = new ProfBL();
    List<Prof> profs;

    public void menu(String id){
        ProfDAO profDAO =new ProfDAO();

        switch (id) {
            default:
                print(
                        "***** MENU *****\n" +
                                "1 - Add Prof\n" +
                                "2 - Show Prof's profile\n" +
                                "\nMake a choice: "
                );
                menu(scanner.next());
                return;
            case "1":
                Prof prof;
                System.out.println(prof.getName() + " " + prof.getFname() + " " + prof.getSubject() + " " + prof.getProfId());
                break;
            case "2":

                System.out.println(profBL.showProfById());
                break;
        }
    }

    private void print(String s) {
        System.out.print(s);
    }






    public void printStaff(Prof prof){
        System.out.println(prof.getClass());
    }

    public void printProf(List<Prof> profList){

        Iterable<? extends Prof> profs = null;
        for (Prof prof : profs
                ) {
            this.printStaff(prof);
        }
    }
}
