package com.brianweed.logger.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vehicle {
    private final StringProperty ID;
    private final StringProperty make;
    private final StringProperty model;
    private final StringProperty year;
    private final StringProperty license;

    //default constructor
    public Vehicle(){
        this(null, null);
    }

    public Vehicle(String ID, String make){
        this.ID = new SimpleStringProperty(ID);
        this.make = new SimpleStringProperty(make);

        //some prefilled data for easier testing
        this.model = new SimpleStringProperty("Tundra");
        this.year = new SimpleStringProperty("2009");
        this.license = new SimpleStringProperty("L65-PDQ");
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
}
