package service;

import dao.impl.ActivityDao;
import model.Activity;
import model.Employee;

public class ActivityService {

    // singleton design pattern

    private ActivityService(){
    }

    private static ActivityService instance = new ActivityService();

    public static ActivityService getInstance(){
        return instance;
    }


    ActivityDao dao = new ActivityDao();
    EmployeeService employeeService = new EmployeeService();

    public Activity getActivity(String activityId) {
        return dao.findById(activityId);
    }

    public Activity addActivity(Activity a ){
        return dao.save(a);
    }


    public void deleteActivity(String id){
        dao.deleteById(id);
    }



    public void setResponsibleEmployee(String activityId, String employeeId){
        Activity a = dao.findById(activityId);
        Employee e = employeeService.getEmployee(employeeId);
        a.setResponsible(e);
    }
}
