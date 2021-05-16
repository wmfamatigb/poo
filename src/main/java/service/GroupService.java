package service;

import dao.GroupDao;
import model.Group;
import model.Student;

import java.util.List;


public class GroupService {


    private GroupDao groupDao = new GroupDao();
    private StudentService studentService  = new StudentService();


    public void addGroup(Group group) throws  Exception{
        groupDao.addGroup(group);
    }

    public List<Group> getGroups(){
        return groupDao.getGroups();
    }

    public void addStudentToGroup(String studentId, String groupName) throws Exception{
        Student s = studentService.getStudent(studentId);
        Group g = groupDao.getGroup(groupName);
        g.addStudent(s);
        groupDao.updateGroup(g);

    }


    // todo
    public void addActivityToGroup(String studentId, String groupName){

    }


}
