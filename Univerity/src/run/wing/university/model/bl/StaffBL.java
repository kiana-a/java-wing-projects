package run.wing.university.model.bl;

import run.wing.university.model.dao.StaffDAO;
import run.wing.university.model.to.Staff;

import java.util.List;

/**
 * Created by kiana on 10/25/17.
 */
public class StaffBL {
    public static List<Staff> getStaff(){
        List<Staff> staffs = null;
        return staffs;
    }

    public void saveStaff(List<Staff> staffs){
        for (Staff staff: staffs
                ) {
            if (staff.getStaffId().length() != 9)
                staffs.remove(staff);
        }
    }
    public Staff getStaffByID(String staffId){
        return StaffDAO.findStaff(staffId);

    }

}


