package dao;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    List<Student> students;


    private Connection connection;

    public StudentDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase","root","root");
        }catch(Exception e ) {

        }
    }


    public List<Student> getStudents(){
        try{

            Statement stmt = connection.createStatement();
            ResultSet rs  =stmt.executeQuery("select * from student");
            List<Student> res = new ArrayList<>();
            while(rs.next()){
                Student s = new Student();

                s.setName(rs.getString(2));
                s.setId(  rs.getString(1));
                res.add(s);
            }
            return res;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }


}


class Main{
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        List<Student> students = dao.getStudents();
        for(Student s : students){
            System.out.println(s.getName());
        }
    }
}