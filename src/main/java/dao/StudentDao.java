package dao;

import model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StudentDao {

    List<Student> students;


    public  StudentDao() throws Exception{
        students = new LinkedList<>();


        FileInputStream fileIn = new FileInputStream("students");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        students =  (List<Student>) objectIn.readObject();
        objectIn.close();

    }


    public List<Student> getStudents(){
        return students;
    }


    public Student addStudent(Student student) throws Exception{
        String newId = UUID.randomUUID().toString();
        student.setId(newId);
        students.add(student);


        FileOutputStream fileOut = new FileOutputStream("students");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(students);
        objectOut.close();

        return student;
    }

    public void removeStudent(String id) {
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId().equals(id)){
                it.remove();
            }
        }
    }

    public Student getStudent(String id) {
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    public void updateStudent(Student newStudent) {
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId().equals(newStudent.getId())){
                it.set(newStudent);
            }
        }
    }
}


class Main{
    public static void main(String[] args) throws Exception{
        StudentDao dao = new StudentDao();


        Student s1 = new Student(), s2 = new Student();
        dao.addStudent(s1);
        dao.addStudent(s2);

        List<Student> students = dao.getStudents();
        System.out.println(students.size());
    }
}