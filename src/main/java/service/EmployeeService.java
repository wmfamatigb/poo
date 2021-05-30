package service;

import dao.impl.EmployeeDao;
import dao.impl.GroupDao;
import model.Employee;
import model.Group;
import model.Student;


import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = EmployeeDao.getInstance();
    private GroupDao groupDao = GroupDao.getInstance();
    private GroupService groupService =  GroupService.getInstance();

    private EmployeeService(){}

    private static EmployeeService instance = new EmployeeService();

    public static EmployeeService getInstance(){
        return instance;
    }


    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    public Employee getEmployee(String id){
        return employeeDao.findById(id);
    }

}
