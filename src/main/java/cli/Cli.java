package cli;

import model.Employee;
import model.Student;
import service.ActivityService;
import service.EmployeeService;
import service.GroupService;
import service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cli {

    private static List<String> options = Arrays.asList("animators", "students", "classes", "activities");
    private static List<String> subHelpOptions = Arrays.asList("add", "update", "delete","list");


    private static StudentService studentService = new StudentService();
    private static ActivityService activityService= new ActivityService();
    private static GroupService groupService=new GroupService();
    private static EmployeeService employeeService= new EmployeeService();


    public static void main(String[] args)  throws Exception{
        if(args.length == 0 ) {
            help();
            return;
        }

        String command = args[0];
        if(!options.contains(command)){
            help();
            return;
        }

        if(command.equals("students")){
            handleStudents(args);
        }else if(command.equals("classes")){
            handleClasses(args);
        }

        if(command.equals("employee")) {
            handleEmployee(args);
        }else if(command.equals("classes")){
            handleClasses(args);
        }

        if(command.equals("activity")){
            handleActivity(args);

        }else if (command.equals("classes")){
            handleClasses(args);
        }




    }


    private static void handleStudents(String[] args) throws Exception{
        if(args.length != 2){
            subHelp();
            return;
        }

        if(!subHelpOptions.contains(args[1])){
            subHelp();
            return;
        }


        String command = args[1];
        if(command.equals("add")){
            Student student = new Student();
            Scanner sc = new Scanner(System.in);
            System.out.println("plz give me the student's name");
            student.setName(sc.next());
            System.out.println("plz give the student's father name");
            student.setFatherName(sc.next());
            System.out.println("plz give me the student's last name");
            student.setLastname(sc.next());
            System.out.println("plz give me the student's grand father's name");
            student.setGrandFatherName(sc.next());
            System.out.println("plz give me the student's mother's name");
            student.setMotherName(sc.next());
            System.out.println("plz give me the student's father's CIN ");
            student.setFatherCin(sc.next());
            System.out.println("plz give me the student's father's Phone Number");
            student.setFatherPhoneNumber(sc.next());
            System.out.println("plz give me the student's birthday date");
            student.setBirthday(sc.next());
            System.out.println("plz give me the student's adress");
            student.setAddress(sc.next());
            System.out.println("plz give me the student's picture");
            student.setImageSource(sc.next());




            studentService.addStudent(student);
        }else if(command.equals("list")){
            List<Student> all = studentService.getStudents();

            for(Student s : all ){
                System.out.println(s);
                System.out.println("----------");
            }
        }

        else if (command.equals("remove")){

        }

        else if (command.equals("update")){

        }

    }


    private static void subHelp(){
        System.out.println("Please select a valid option");
        for(String opt : subHelpOptions){
            System.out.println("* "+ opt);
        }
    }


    private static void handleClasses(String[] args){

    }

    public static void handleEmployee(String[] args) {

    }

    public static void handleActivity(String[] args) {

    }

    private static void help(){
        System.out.println("please select a valid option");
        for(String opt : options ){
            System.out.println("* "+ opt);
        }
    }

}
