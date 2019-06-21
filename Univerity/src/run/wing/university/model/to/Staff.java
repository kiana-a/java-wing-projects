package run.wing.university.model.to;

/**
 * Created by kiana on 10/25/17.
 */
public class Staff {
    private String name;
    private String fname;
    private StaffJob job;
    private String staffId;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public StaffJob getJob() {
        return job;
    }

    public void setJob(StaffJob job) {
        this.job = job;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff(String name, String fname, StaffJob job, String staffId) {
        this.name = name;
        this.fname = fname;
        this.job = job;
        this.staffId = staffId;
    }
}
