package run.wing.wage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiana on 10/18/17.
 */
public class Staff {
    private String name;
    private String familyname;
    private String jensiat;
    private String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getJensiat() {
        return jensiat;
    }

    public void setJensiat(String sex) {
        this.jensiat = jensiat;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    private List<Staff> staffs = new ArrayList<>();
    public void addStaff(Staff staff){
        staffs.add(staff);
    }
}
