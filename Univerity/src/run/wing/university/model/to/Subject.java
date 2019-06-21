package run.wing.university.model.to;

/**
 * Created by kiana on 10/25/17.
 */
public class Subject {
    private String subjectName;
    private String subjectID;
    private String term;
    private Prof prof;

    public Subject(String subjectName, String subjectID, String term) {
        this.subjectName = subjectName;
        this.subjectID = subjectID;
        this.term = term;
        this.prof = prof;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectID='" + subjectID + '\'' +
                ", term='" + term + '\'' +
                ", prof=" + prof +
                '}';
    }
}
