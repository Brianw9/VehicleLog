package com.brianweed.logger;

import java.io.IOException;

import com.brianweed.logger.model.Vehicle;
import com.brianweed.logger.view.VehicleOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Vehicle> vehicleData = FXCollections.observableArrayList();

    public MainApp(){
        vehicleData.add(new Vehicle("55","Toyota", "Tundra", "2009", "L65-PDQ"));
        vehicleData.add(new Vehicle("1", "Audi", "TT", "1998","2fast4u"));
        vehicleData.add(new Vehicle("2", "Ford", "Mustang", "1234", "555-555"));
        vehicleData.add(new Vehicle("3","Lincoln", "Navigator", "55555", "55378008"));
    }

    /**
     * Returns the data as an observable list of Vehicles.
     * @return
     */
    public ObservableList<Vehicle> getVehicleData() {
        return vehicleData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("VehicleLogger");

        initRootLayout();
        showVehicleOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the vehicle overview inside the root layout.
     */
    public void showVehicleOverview() {
        try {
            // Load vehicle overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/VehicleOverview.fxml"));
            AnchorPane vehicleOverview = (AnchorPane) loader.load();

            // Set vehicle overview into the center of root layout.
            rootLayout.setCenter(vehicleOverview);

            // Give the controller access to the main app.
            VehicleOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}