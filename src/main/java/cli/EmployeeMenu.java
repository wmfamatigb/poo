package cli;

import cli.CliMenu;
import cli.UserInfoInput;
import cli.handlers.ActionHandler;
import model.Employee;
import model.Student;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMenu extends CliMenu {

    private StudentService EmployeeService = EmployeeService.getInstance();

    @Override
    Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        result.put("list", new ActionHandler() {
            public void handle() {
                List<Employee> employees = EmployeeService.getEmployee();
                for(Employee e : employees) {
                    System.out.println(e);
                }
            }
        });

        result.put("add", new ActionHandler() {
            public void handle() {
                Student s;
                while(true){
                    e = (Employee) UserInfoInput.readUserInput(Employee.class);
                    if(e == null)
                        System.out.println("Failed to read user input ");
                    else
                        break;
                }
                EmployeeService.addEmployee(e);
            }
        });
        return result;
    }
}