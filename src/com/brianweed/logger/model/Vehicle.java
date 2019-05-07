        package com.brianweed.logger.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Vehicle {
    private final StringProperty ID;
    private final StringProperty make;
    private final StringProperty model;
    private final StringProperty year;
    private final StringProperty license;
    private final ArrayList<StringProperty> maintenanceList = new ArrayList<>(5);

    //default constructor
    public Vehicle(){
        this(null, null, null, null, null);
    }

    public Vehicle(String ID, String make, String model, String year, String license){
        this.ID = new SimpleStringProperty(ID);
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = new SimpleStringProperty(year);
        this.license = new SimpleStringProperty(license);
    }
    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getMake() {
        return make.get();
    }

    public StringProperty makeProperty() {
        return make;
    }

    public void setMake(String make) {
        this.make.set(make);
    }

    public String getModel() {
        return model.get();
    }

    public StringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getLicense() {
        return license.get();
    }

    public StringProperty licenseProperty() {
        return license;
    }

    public void setLicense(String license) {
        this.license.set(license);
    }
    public void setMaintenanceList(StringProperty newVar){
        this.maintenanceList.add(newVar);
    }
    private ArrayList<StringProperty> maintenanceListProperty(){
        return maintenanceList;
    }
}
