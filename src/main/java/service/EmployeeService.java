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


    public void addEmployee(Employee employee) throws  Exception{
        employeeDao.save(employee);
    }

    public List<Employee> getEmployee(){
        return employeeDao.findAll();
    }


    public void addGroupToEmployee(String groupId, String employeeName) {
        Group g = GroupService.getGroups(groupId);
        Employee e = employeeDao.findById(employeeName);
        e.addGroup(g);
        employeeDao.save(e);
    }

}
