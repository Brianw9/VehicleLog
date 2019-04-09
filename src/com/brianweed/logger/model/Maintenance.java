package com.brianweed.logger.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Maintenance {
    private final StringProperty maintenancename;
    private final StringProperty duedate;
    private final StringProperty completed;
    private final StringProperty interval;


    public Maintenance(String maint, String duedate, String interval, String completed){
        this.maintenancename = new SimpleStringProperty(maint);
        this.duedate = new SimpleStringProperty(duedate);
        this.interval = new SimpleStringProperty(interval);
        this.completed = new SimpleStringProperty(completed);
    }
    public String getMaintenancename() {
        return maintenancename.get();
    }

    public StringProperty maintenancenameProperty() {
        return maintenancename;
    }

    public void setMaintenancename(String maintenancename) {
        this.maintenancename.set(maintenancename);
    }

    public String getDuedate() {
        return duedate.get();
    }

    public StringProperty duedateProperty() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate.set(duedate);
    }

    public String getCompleted() {
        return completed.get();
    }

    public StringProperty completedProperty() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed.set(completed);
    }

    public String getInterval() {
        return interval.get();
    }

    public StringProperty intervalProperty() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval.set(interval);
    }


}
