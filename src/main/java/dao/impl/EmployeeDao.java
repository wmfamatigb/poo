package dao.impl;

import dao.AbstractDao;
import model.Employee;

public class EmployeeDao extends AbstractDao<Employee> {

    // *********************************
    // Singleton design pattern

    // private constructor
    private EmployeeDao(){
    }

    // the one instance that is going to exist
    private static EmployeeDao instance = new EmployeeDao();

    // the only way to get it
    public static EmployeeDao getInstance() {
        return instance;
    }

    // *********************************
}
