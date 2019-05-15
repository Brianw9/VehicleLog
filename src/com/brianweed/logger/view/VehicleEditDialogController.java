package com.brianweed.logger.view;

import com.brianweed.logger.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VehicleEditDialogController {

    @FXML
    private TextField completedField;

    @FXML
    private TextField licenseField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField dueDateField;

    @FXML
    private TextField maintField;

    @FXML
    private TextField milesField;

    @FXML
    private TextField makeField;

    @FXML
    private TextField iDField;

    private Stage dialogStage;
    private Vehicle vehicle;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    /**
     * Sets the vehicle to be edited in the dialog.
     *
     * @param vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

        iDField.setText(vehicle.getID());
        makeField.setText(vehicle.getMake());
        modelField.setText(vehicle.getModel());
        yearField.setText(vehicle.getYear());
        licenseField.setText(vehicle.getLicense());
        maintField.setText(vehicle.getUpcomingMaint());
        dueDateField.setText(vehicle.getDueDate());
        milesField.setText(vehicle.getMiles());
        completedField.setText(vehicle.getComplete());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            vehicle.setID(iDField.getText());
            vehicle.setMake(makeField.getText());
            vehicle.setModel(modelField.getText());
            vehicle.setYear(yearField.getText());
            vehicle.setLicense(licenseField.getText());
            vehicle.setUpcomingMaint(maintField.getText());
            vehicle.setDueDate(dueDateField.getText());
            vehicle.setMiles(milesField.getText());
            vehicle.setComplete(completedField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (iDField.getText() == null || iDField.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (makeField.getText() == null || makeField.getText().length() == 0) {
            errorMessage += "No valid make!\n";
        }
        if (modelField.getText() == null || modelField.getText().length() == 0) {
            errorMessage += "No valid model!\n";
        }
        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "No valid year!\n";
        }
        if (licenseField.getText() == null || licenseField.getText().length() == 0) {
            errorMessage += "No valid License!\n";
        }
        if (maintField.getText() == null || maintField.getText().length() == 0) {
            errorMessage += "No valid maintenance!\n";
        }
        if (dueDateField.getText() == null || dueDateField.getText().length() == 0) {
            errorMessage += "No valid due date!\n";
        }
        if (milesField.getText() == null || milesField.getText().length() == 0) {
            errorMessage += "No valid mileage!\n";
        }
        if (completedField.getText() == null || completedField.getText().length() == 0) {
            errorMessage += "No valid completed indicator!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
