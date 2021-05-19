package cli;

import model.Group;
import model.Student;
import service.ActivityService;
import service.EmployeeService;
import service.GroupService;
import service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cli {

    private static List<String> options = Arrays.asList("animators", "students", "groups", "activities");
    private static List<String> subHelpOptions = Arrays.asList("add", "update", "delete", "list");


    private static StudentService studentService = StudentService.getInstance();
    private static ActivityService activityService = ActivityService.getInstance();
    private static GroupService groupService =  GroupService.getInstance();
    private static EmployeeService employeeService = new EmployeeService();


    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            help();
            return;
        }

        String command = args[0];
        if (!options.contains(command)) {
            help();
            return;
        }

        if (command.equals("students")) {
            handleStudents(args);
        }

        if (command.equals("employee")) {
            handleEmployee(args);
        } else if (command.equals("group")) {
            handleGroups(args);
        }

        if (command.equals("activity")) {
            handleActivity(args);

        }

        if(command.equals("groups")){
            handleGroups(args);
        }


    }


        private static void handleStudents (String[]args) throws Exception {
            if (args.length != 2) {
                subHelp();
                return;
            }

            if (!subHelpOptions.contains(args[1])) {
                subHelp();
                return;
            }


            String command = args[1];
            if (command.equals("add")) {
                Student s =  (Student) UserInfoInput.readUserInput(Student.class);
                studentService.addStudent(s);
            } else if (command.equals("list")) {
                List<Student> all = studentService.getStudents();

                for (Student s : all) {
                    System.out.println(s);
                    System.out.println("----------");
                }
            } else if (command.equals("remove")) {

            } else if (command.equals("update")) {

            }

        }


        private static void subHelp () {
            System.out.println("Please select a valid option");
            for (String opt : subHelpOptions) {
                System.out.println("* " + opt);
            }
        }


        private static void handleGroups(String[]args) throws Exception {
            if (args.length != 2) {
                subHelp();
                System.out.println("* add-student");
                return;
            }

            if (!subHelpOptions.contains(args[1]) && ! args[1].equals("add-student")) {
                subHelp();
                return;
            }


            String command = args[1];
            if (command.equals("add")) {
                Group g =  (Group) UserInfoInput.readUserInput(Group.class);
                groupService.addGroup(g);
            } else if (command.equals("list")) {
                List<Group> all = groupService.getGroups();

                for (Group g : all) {
                    System.out.println(g);
                    System.out.println("----------");
                }
            } else if (command.equals("remove")) {

            } else if (command.equals("update")) {

            }else if(command.equals("add-student")){
                System.out.println("give student id: ");
                Scanner sc = new Scanner(System.in);
                String id = sc.next();
                System.out.println("give me the group name");
                String groupName = sc.next();
                groupService.addStudentToGroup(id, groupName);

            }
        }

        public static void handleEmployee (String[]args){

        }

        public static void handleActivity (String[]args){

        }

        private static void help () {
            System.out.println("please select a valid option");
            for (String opt : options) {
                System.out.println("* " + opt);
            }
        }

    }


