package service;

import dao.impl.EmployeeDao;
import dao.impl.GroupDao;
import model.Employee;
import model.Group;
import model.Student;


import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();
    private GroupDao groupDao = new GroupDao();
    private GroupService groupService =  GroupService.getInstance();


    public void addEmployee(Employee employee) throws  Exception{
        employeeDao.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    public Employee getEmployee(String id){
        return employeeDao.findById(id);
    }

}
