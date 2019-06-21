package run.wing.university.model.bl;

import run.wing.university.model.dao.ProfDAO;
import run.wing.university.model.to.Prof;

import java.util.List;

/**
 * Created by kiana on 10/25/17.
 */
public class ProfBL {
    public ProfBL(ProfDAO profDAO) {

    }

    public static List<Prof> getProf(){
        List<Prof> profs = null;
        return profs;
    }

    public void saveProfs(List<Prof> profs){
        for (Prof prof: profs
             ) {
            if (prof.getProfId()!=null && prof.getProfId().length() != 9)
                profs.remove(prof);
        }
    }
    public Prof getProfByID(String profId){
        return ProfDAO.findProf(profId);
    }
    public Prof showProfById(String profId){
       getProfByID(profId);
        Prof prof = null;
        System.out.println(prof.setName() + " " + prof.setFname() + " " + prof.setProfId() + " " + prof.setSubject() + " ");
    }

    public boolean showProfById() {
    }
}
