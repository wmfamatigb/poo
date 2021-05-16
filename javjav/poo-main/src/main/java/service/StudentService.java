package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {

    private StudentDao dao;

    public StudentService () {
        try{
            dao = new StudentDao();
        }catch (Exception e){
            //
        }
    }


    public Student addStudent(Student student) throws Exception{
        return dao.addStudent(student);
    }

    public void removeStudent(String id) throws Exception {
        dao.removeStudent(id);
    }

    public List<Student> getStudents(){
        return dao.getStudents();
    }

    public Student getStudent(String id){
        return dao.getStudent(id);
    }

    public void updateStudent(Student newStudent) throws Exception {
        dao.updateStudent(newStudent);
    }


}
