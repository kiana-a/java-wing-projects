package run.wing.university.model.to;

/**
 * Created by kiana on 10/25/17.
 */
public class Prof {
    private String name;
    private String fname;
    private Subject subject;
    private String profId;

    public Prof(String id, String name, String fname, Subject subject) {
        this.name = name;
        this.fname = fname;
        this.subject = subject;
        this.profId = id;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Prof(String name, String fname, Subject subject, String profId) {
        this.name = name;
        this.fname = fname;
        this.subject = subject;
        this.profId = profId;
    }


}
