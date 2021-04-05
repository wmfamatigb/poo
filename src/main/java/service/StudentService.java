package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {

    private StudentDao dao;


    public StudentService () throws Exception{
        dao = new StudentDao();
    }


    public Student addStudent(Student student) throws Exception{
        return dao.addStudent(student);
    }

    public void removeStudent(String id) {
        dao.removeStudent(id);
    }

    public List<Student> getStudents(){
        return dao.getStudents();
    }

    public Student getStudent(String id){
        return dao.getStudent(id);
    }

    public void updateStudent(Student newStudent){
        dao.updateStudent(newStudent);
    }


}
