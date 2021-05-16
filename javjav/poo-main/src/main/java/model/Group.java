package model;

import java.util.List;

public class Group {

    private String name;
    private List<Student> students;
    private List<Activity> activities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Group(String name, List<Student> students, List<Activity> activities) {
        this.name = name;
        this.students = students;
        this.activities = activities;
    }
}
