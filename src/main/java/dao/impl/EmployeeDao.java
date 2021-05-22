package dao.impl;

import dao.AbstractDao;
import model.Employee;

public class EmployeeDao extends AbstractDao<Employee> {

    private static EmployeeDao instance = new EmployeeDao();

    public static EmployeeDao getInstance() {
        return instance;
    }
}
