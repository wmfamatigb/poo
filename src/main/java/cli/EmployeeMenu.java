package cli;

import cli.CliMenu;
import cli.UserInfoInput;
import cli.handlers.ActionHandler;
import model.Employee;
import model.Student;
import service.EmployeeService;
import service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMenu extends CliMenu {

    private EmployeeService employeeService = EmployeeService.getInstance();


    @Override
    public Map<String, ActionHandler> initHandlers() {
        Map<String, ActionHandler> result = new HashMap<>();

        result.put("list", new ActionHandler() {
            public void handle() {
                List<Employee> employees = employeeService.getEmployees();
                for(Employee e : employees) {
                    System.out.println(e);
                }
            }
        });

        result.put("add", new ActionHandler() {
            public void handle() {
                Employee e;
                while(true){
                    e = (Employee) UserInfoInput.readUserInput(Employee.class);
                    if(e == null)
                        System.out.println("Failed to read user input ");
                    else
                        break;
                }
                employeeService.addEmployee(e);
            }
        });
        return result;
    }
}