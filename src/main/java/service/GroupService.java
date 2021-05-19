package service;

import dao.impl.GroupDao;
import model.Group;
import model.Student;

import java.util.List;


public class GroupService {


    private GroupDao groupDao = new GroupDao();
    private StudentService studentService  = new StudentService();


    public void addGroup(Group group) throws  Exception{
        groupDao.save(group);
    }

    public List<Group> getGroups(){
        return groupDao.findAll();
    }

    public void addStudentToGroup(String studentId, String groupName) {
        Student s = studentService.getStudent(studentId);
        Group g = groupDao.findById(groupName);
        g.addStudent(s);
        groupDao.save(g);
    }


    // todo
    public void addActivityToGroup(String studentId, String groupName){
        Student s;
        System.out.println("any");
    }


}
