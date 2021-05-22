package cli;

import cli.handlers.ActionHandler;
import model.Student;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMenu extends  CliMenu{

    private StudentService studentService = StudentService.getInstance();

    @Override
    protected Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        result.put("list", new ActionHandler() {
            public void handle() {
                List<Student> students = studentService.getStudents();
                for(Student s : students) {
                    System.out.println(s);
                }
            }
        });

        result.put("add", new ActionHandler() {
            public void handle() {
                Student s;
                while(true){
                    s = (Student) UserInfoInput.readUserInput(Student.class);
                    if(s == null)
                        System.out.println("Failed to read user input ");
                    else
                        break;
                }
                studentService.addStudent(s);
            }
        });
        return result;
    }
}
