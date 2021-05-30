package dao.impl;

import dao.AbstractDao;
import model.Group;

public class GroupDao  extends AbstractDao<Group> {

    // *********************************
    // Singleton design pattern

    // private constructor
    private GroupDao(){
    }

    // the only instance that is going to exist on the program
    private static GroupDao instance = new GroupDao();

    // the only way to get that instance
    public static GroupDao getInstance() {
        return instance;
    }
    // *********************************


}
