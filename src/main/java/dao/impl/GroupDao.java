package dao.impl;

import dao.AbstractDao;
import model.Group;

public class GroupDao  extends AbstractDao<Group> {

    private static GroupDao instance = new GroupDao();

    public static GroupDao getInstance() {
        return instance;
    }
}
