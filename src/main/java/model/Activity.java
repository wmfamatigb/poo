package model;

import dao.HasId;

public class Activity  implements HasId {

    private String code; // functional id
    private String label;
    private Employee responsible;
    private int chargePrice;

    public int getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(int chargePrice) {
        this.chargePrice = chargePrice;
    }

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

    @Override
    public String getId() {
        return code;
    }

    @Override
    public void setId(String id) {
        this.code= id;
    }
}
