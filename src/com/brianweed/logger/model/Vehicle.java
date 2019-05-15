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
    private final StringProperty upcomingMaint;
    private final StringProperty dueDate;
    private final StringProperty miles;
    private final StringProperty complete;

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
        this.upcomingMaint = new SimpleStringProperty();
        this.dueDate = new SimpleStringProperty();
        this.miles = new SimpleStringProperty();
        this.complete = new SimpleStringProperty();

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

    public String getUpcomingMaint() {
        return upcomingMaint.get();
    }

    public StringProperty upcomingMaintProperty() {
        return upcomingMaint;
    }

    public void setUpcomingMaint(String upcomingMaint) {
        this.upcomingMaint.set(upcomingMaint);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public StringProperty dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    public String getMiles() {
        return miles.get();
    }

    public StringProperty milesProperty() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles.set(miles);
    }

    public String getComplete() {
        return complete.get();
    }

    public StringProperty completeProperty() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete.set(complete);
    }

}
