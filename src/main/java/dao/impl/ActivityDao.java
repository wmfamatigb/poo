package dao.impl;

import dao.AbstractDao;
import model.Activity;

public class ActivityDao extends AbstractDao<Activity> {

    private static ActivityDao instance = new ActivityDao();

    public static ActivityDao getInstance() {
        return instance;
    }
}
