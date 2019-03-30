package com.brianweed.logger.view;

import com.brianweed.logger.MainApp;
import com.brianweed.logger.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VehicleOverviewController {

    @FXML
    private TableView<Vehicle> vehicleTable;

    @FXML
    private TableView<Vehicle> maintTable;

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
    private TableColumn<?, ?> maintColumn;

    @FXML
    private TableColumn<?, ?> intervalColumn;

    @FXML
    private TableColumn<?, ?> dueDateColumn;

    @FXML
    private TableColumn<?, ?> completedColumn;

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
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param vehicle the vehicle or null
     */
    private void showVehicleDetails(Vehicle vehicle) {
        if (vehicle != null) {
            // Fill the labels with info from the vehicle object.
            maintTable.setItems(mainApp.getMaintData);

        } else {
            // Vehicle is null, remove all the text.
            maintTable.setItems(null);
        }
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        makeColumn.setCellValueFactory(cellData -> cellData.getValue().makeProperty());
        modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        licenseColumn.setCellValueFactory(cellData -> cellData.getValue().licenseProperty());

        maintTable.setRowFactory();
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
}
