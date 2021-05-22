package dao.impl;

import dao.AbstractDao;
import model.Student;

public class StudentDao  extends AbstractDao<Student> {

    private static StudentDao instance = new StudentDao();

    public static StudentDao getInstance() {
        return instance;
    }
}
