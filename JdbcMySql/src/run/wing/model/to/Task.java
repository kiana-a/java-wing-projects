package run.wing.model.to;

import java.sql.Date;

/**
 * Created by kiana on 12/31/17.
 */
public class Task {
    private int id;
    private Date startDate;
    private Date endDate;
    private int point;
    private String description;
    private Person person;

    public Task(int id, Date startDate, Date endDate, int point, String description) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.point = point;
        this.description = description;
    }

    public Task(int id, Date startDate, Date endDate, int point, String description,Person person) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.point = point;
        this.description = description;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(Date startDate, Date endDate, int point, String description, Person person) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.point = point;
        this.description = description;
        this.person = person;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", point=" + point +
                ", description='" + description + '\'' +
                ", person=" + person +
                '}';
    }
}
