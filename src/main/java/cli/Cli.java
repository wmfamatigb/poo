package cli;

import model.Student;
import service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cli {

    private static List<String> options = Arrays.asList("animators", "students", "classes", "activities");
    private static List<String> subHelpOptions = Arrays.asList("add", "update", "delete","list");


    private static StudentService studentService = new StudentService();
    // TODO: the other services


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
        }// TODO : the others

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
            System.out.println("plz give me his name");
            student.setName(sc.next());
            System.out.println("plz give me his father name");
            student.setFatherName(sc.next());
            studentService.addStudent(student);
        }else if(command.equals("list")){
            List<Student> all = studentService.getStudents();

            for(Student s : all ){
                System.out.println(s);
                System.out.println("----------");

            }
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

    private static void help(){
        System.out.println("please select a valid option");
        for(String opt : options ){
            System.out.println("* "+ opt);
        }
    }

}
