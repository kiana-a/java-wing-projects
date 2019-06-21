package run.wing.university.model.to;

/**
 * Created by kiana on 10/25/17.
 */
public enum FieldOfStudy {
    SOFTWARE_ENG("کامپیوتر"),
    ELECTRICAL_ENG("برق"),
    ARCHITECTURE ("معماری");

    private String persianName;

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    FieldOfStudy(String persianName) {
        this.persianName = persianName;
    }
}
