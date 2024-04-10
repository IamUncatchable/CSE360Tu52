package fxMedicalCenter;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;

public class ReceptionistView extends Application {

    private TableView<Patient> patientTable = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Receptionist Dashboard");

        // Menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> System.exit(0));
        fileMenu.getItems().add(exitItem);

        Menu manageMenu = new Menu("Manage");
        MenuItem newVisitItem = new MenuItem("New Visit");
        MenuItem checkInItem = new MenuItem("Check-In");
        MenuItem newPatientItem = new MenuItem("New Patient");

        manageMenu.getItems().addAll(newVisitItem, checkInItem, newPatientItem);
        menuBar.getMenus().addAll(fileMenu, manageMenu);

        // Handling new patient registration
        newPatientItem.setOnAction(e -> showNewPatientDialog());

        // Table for patient data
        TableColumn<Patient, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> data.getValue().name);
        TableColumn<Patient, String> appointmentColumn = new TableColumn<>("Appointment Time");
        appointmentColumn.setCellValueFactory(data -> data.getValue().appointmentTime);

        patientTable.getColumns().addAll(nameColumn, appointmentColumn);
        // ... add data to the table

        // Status bar
        Label statusLabel = new Label("Ready");
        HBox statusBar = new HBox(statusLabel);
        statusBar.setAlignment(Pos.CENTER);
        statusBar.setPadding(new Insets(5, 10, 5, 10));

        // Layout setup
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(patientTable);
        borderPane.setBottom(statusBar);

        // Scene setup
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showNewPatientDialog() {
        Dialog<Patient> dialog = new Dialog<>();
        dialog.setTitle("New Patient");
        dialog.setHeaderText("Add a New Patient");

        // Set the button types.
        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        // Create the name and appointment fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField appointmentField = new TextField();
        appointmentField.setPromptText("Appointment Time");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Appointment Time:"), 0, 1);
        grid.add(appointmentField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Convert the result to a Patient when the create button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                return new Patient(nameField.getText(), appointmentField.getText());
            }
            return null;
        });

        Optional<Patient> result = dialog.showAndWait();

        result.ifPresent(patient -> {
            patientTable.getItems().add(patient);
        });
    }

    // Dummy Patient class for table view
    public static class Patient {
        private final SimpleStringProperty name;
        private final SimpleStringProperty appointmentTime;

        private Patient(String name, String appointmentTime) {
            this.name = new SimpleStringProperty(name);
            this.appointmentTime = new SimpleStringProperty(appointmentTime);
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public SimpleStringProperty appointmentTimeProperty() {
            return appointmentTime;
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getAppointmentTime() {
            return appointmentTime.get();
        }

        public void setAppointmentTime(String fName) {
            appointmentTime.set(fName);
        }
    }
}
