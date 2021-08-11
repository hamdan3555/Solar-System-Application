package Models;

import android.widget.TextView;

public class ModelBookNow {
    public String address;
    public String type;
    public String project_power;
    public String contact_number;
    public ModelBookNow(){}
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProject_power() {
        return project_power;
    }

    public void setProject_power(String project_power) {
        this.project_power = project_power;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public ModelBookNow(String address, String type, String project_power, String contact_number) {
        this.address = address;
        this.type = type;
        this.project_power = project_power;
        this.contact_number = contact_number;
    }

}
