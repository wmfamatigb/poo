package model;

public class Activity {
    private String code;
    private String label;
    private Employee responsible;
    private int chargePrice;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

    public Activity(String code, String label, Employee responsible) {
        this.code = code;
        this.label = label;
        this.responsible = responsible;
    }
}
