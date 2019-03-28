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
    private TableView<?> maintTable;

    @FXML
    private TableColumn<Vehicle, String> yearColumn;

    @FXML
    private TableColumn<Vehicle, String> licenseColumn;

    @FXML
    private Button editVehicleButton;

    @FXML
    private TableColumn<?, ?> completedColumn;

    @FXML
    private Button deleteVehicleButton;

    @FXML
    private Button addMaintButton;

    @FXML
    private TableColumn<?, ?> maintColumn;

    @FXML
    private TableColumn<Vehicle, String> makeColumn;

    @FXML
    private TableColumn<?, ?> intervalColumn;

    @FXML
    private TableColumn<Vehicle, String> modelColumn;

    @FXML
    private TableColumn<?, ?> dueDateColumn;

    @FXML
    private Button newVehicleButton;

    @FXML
    private Button editMaintButton;

    @FXML
    private Button deleteMaintButton;

    @FXML
    private TableColumn<Vehicle, String> idColumn;

    // Reference to the main application.
    private MainApp mainApp;

    //Constructor
    public VehicleOverviewController() {
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
        modelColumn.setCellValueFactory(celldata -> celldata.getValue().modelProperty());
        yearColumn.setCellValueFactory(celldata -> celldata.getValue().yearProperty());
        licenseColumn.setCellValueFactory(celldata -> celldata.getValue().licenseProperty());
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
