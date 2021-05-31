package model;

import dao.HasId;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Group implements Serializable , HasId {

    private String name; // functional id
    private List<Student> students;
    private List<Activity> activities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student s ){
        if(students == null) students = new LinkedList<>();
        students.add(s);
    }


    public void addActivity(Activity activity){
        if(activities == null) activities = new LinkedList<>();
        activities.add(activity);
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


    @Override
    public String toString() {
        return "Group{" +
                "name='" + name +  '\'' +
                ", students=" + students +
                ", activities=" + activities +
                '}';
    }

    @Override
    public String getId() {
        return this.name;
    }

    @Override
    public void setId(String id) {
        this.name = id;
    }
}
