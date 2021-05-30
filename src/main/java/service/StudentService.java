package service;

import dao.impl.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {

    private StudentDao dao = StudentDao.getInstance();

    private StudentService () {
    }


    private static StudentService instance = new StudentService();


    public static StudentService getInstance(){
        return instance;
    }


    public Student addStudent(Student student) {
        return dao.save(student);
    }

    public boolean removeStudent(String id)  {
        return dao.deleteById(id);
    }

    public List<Student> getStudents(){
        return dao.findAll();
    }

    public Student getStudent(String id){
        return dao.findById(id);
    }

    public void updateStudent(Student newStudent) {
        dao.save(newStudent);
    }

}
