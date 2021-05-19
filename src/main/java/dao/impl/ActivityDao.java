package dao.impl;

import dao.AbstractDao;
import model.Activity;

public class ActivityDao extends AbstractDao<Activity> {

    // TODO: replicate design pattern for all dao class
    private static ActivityDao instance = new ActivityDao();

    public static ActivityDao getInstance() {
        return instance;
    }
}
