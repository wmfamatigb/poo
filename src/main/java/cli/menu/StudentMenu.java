package cli.menu;

import cli.CliUtils;
import cli.handlers.ActionHandler;
import model.Student;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMenu extends CliMenu {

    private StudentService studentService = StudentService.getInstance();

    @Override
    protected Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        result.put("list", new ActionHandler() {
            public void handle() {
                List<Student> students = studentService.getStudents();
                if(students.size() == 0) System.out.println("Empty.");

                for(Student s : students) {
                    System.out.println(s);
                }
            }
        });

        result.put("add", new ActionHandler() {
            public void handle() {
                Student s;
                while(true){
                    s = (Student) CliUtils.createInstanceFromUserInput(Student.class);
                    if(s == null)
                        System.out.println("Failed to read user input ");
                    else
                        break;
                }
                studentService.addStudent(s);
            }
        });

        result.put("remove", new ActionHandler() {
            @Override
            public void handle() {
                System.out.println("Give me the id of the student: ");
                String studentId = CliUtils.readUserInput();

                boolean isFoundAndDeleted = studentService.removeStudent(studentId);

                if(!isFoundAndDeleted)
                    System.out.println("No student with the given id is found in the database!");
                else
                    System.out.println("Student deleted from database!");
            }
        });

        result.put("update", new ActionHandler() {
            @Override
            public void handle() {
                System.out.println("Give me the id of the student you want to delete: ");
                String  targetStudentId = CliUtils.readUserInput();

                // see if student exists on the database
                Student student = studentService.getStudent(targetStudentId);
                if( student == null ){
                    // no student found with the given id
                    System.out.println("No student found with the given id!");
                    return;
                }

                // if we are here, that means the student is not null
                System.out.println("Give the new values for the student");
                Student newStudentVersion = (Student) CliUtils.createInstanceFromUserInput(Student.class);
                newStudentVersion.setId(student.getId());
                studentService.updateStudent(newStudentVersion);
            }
        });

        return result;
    }
}
