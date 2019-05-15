package com.brianweed.logger.view;

import com.brianweed.logger.MainApp;
import com.brianweed.logger.model.Vehicle;
import javafx.beans.value.ObservableStringValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VehicleOverviewController {

    @FXML
    private TableView<Vehicle> vehicleTable;

    @FXML
    private TableColumn<Vehicle, String> yearColumn;

    @FXML
    private TableColumn<Vehicle, String> licenseColumn;

    @FXML
    private TableColumn<Vehicle, String> makeColumn;

    @FXML
    private TableColumn<Vehicle, String> modelColumn;

    @FXML
    private TableColumn<Vehicle, String> idColumn;

    @FXML
    private Button editVehicleButton;


    @FXML
    private Button deleteVehicleButton;

    @FXML
    private Button addMaintButton;

    @FXML
    private Label maintLabel;

    @FXML
    private Label mileageLabel;

    @FXML
    private Label dueDateLabel;

    @FXML
    private Label completedLabel;

    @FXML
    private Button newVehicleButton;

    @FXML
    private Button editMaintButton;

    @FXML
    private Button deleteMaintButton;

    // Reference to the main application.
    private MainApp mainApp;

    //Constructor
    public VehicleOverviewController() {
    }
    /**
     * Fills all text fields to show details about the vehicle.
     * If the specified vehicle is null, all text fields are cleared.
     *
     * @param vehicle the vehicle or null
     */
    private void showVehicleDetails(Vehicle vehicle) {
    if (vehicle != null) {
    // Fill the labels with info from the vehicle object.
        maintLabel.setText(vehicle.getUpcomingMaint());
        dueDateLabel.setText(vehicle.getDueDate());
        mileageLabel.setText(vehicle.getMiles());
        completedLabel.setText(vehicle.getComplete());
    } else {
    // Vehicle is null, remove all the text.
        maintLabel.setText("");
        dueDateLabel.setText("");
        mileageLabel.setText("");
        completedLabel.setText("");

    }
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the vehicle table with the five columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        makeColumn.setCellValueFactory(cellData -> cellData.getValue().makeProperty());
        modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        licenseColumn.setCellValueFactory(cellData -> cellData.getValue().licenseProperty());

        showVehicleDetails(null);

        vehicleTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showVehicleDetails(newValue));
    }
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        vehicleTable.setItems(mainApp.getVehicleData());
    }
    @FXML
    private void handleDeleteVehicle(){
        int selectedIndex = vehicleTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            vehicleTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Vehicle Selected");
            alert.setContentText("Please select a Vehicle in the table.");

            alert.showAndWait();
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new vehicle.
     */
    @FXML
    private void handleNewVehicle() {
        Vehicle tempVehicle = new Vehicle();
        boolean okClicked = mainApp.showVehicleEditDialog(tempVehicle);
        if (okClicked) {
            mainApp.getVehicleData().add(tempVehicle);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected vehicle.
     */
    @FXML
    private void handleEditVehicle() {
        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            boolean okClicked = mainApp.showVehicleEditDialog(selectedVehicle);
            if (okClicked) {
                showVehicleDetails(selectedVehicle);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Vehicle Selected");
            alert.setContentText("Please select a vehicle in the table.");

            alert.showAndWait();
        }
    }
}


