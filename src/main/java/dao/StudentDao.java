package dao;

import model.Student;

import java.io.*;
import java.util.*;

public class StudentDao {

    List<Student> students;
    private final String STUDENTS_FILENAME = "students";


    public  StudentDao() throws Exception{
        students = new LinkedList<>();

        try {
            FileInputStream fileIn = new FileInputStream(STUDENTS_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            students =  (List<Student>) objectIn.readObject();
            objectIn.close();
        }catch(FileNotFoundException e){
        }

    }


    public List<Student> getStudents(){
        try {
            // reads list of students from a file
            FileInputStream fileIn = new FileInputStream(STUDENTS_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            students =  (List<Student>) objectIn.readObject();
            objectIn.close();
            return students;
        }catch(Exception e){
            return Arrays.asList();
        }
    }


    public Student addStudent(Student student) throws Exception{
        String newId = UUID.randomUUID().toString();
        student.setId(newId);
        students.add(student);

        FileOutputStream fileOut = new FileOutputStream(STUDENTS_FILENAME);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(students);
        objectOut.close();

        return student;
    }

    public void removeStudent(String id) throws Exception {
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId().equals(id)){
                it.remove();
                break;
            }
        }

        FileOutputStream fileOut = new FileOutputStream(STUDENTS_FILENAME);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(students);
        objectOut.close();
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

    public void updateStudent(Student newStudent) throws Exception  {
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getId().equals(newStudent.getId())){
                it.set(newStudent);
                break;
            }
        }
        FileOutputStream fileOut = new FileOutputStream("students");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(students);
        objectOut.close();
    }
}
