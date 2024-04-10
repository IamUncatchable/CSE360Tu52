package fxMedicalCenter;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;

public class ReceptionistView extends Application {

    private TableView<Patient> patientTable = new TableView<>();
    private Random rand = new Random();
    // You'll need to store the text fields for data retrieval
    private TextField nameField;
    private TextField insuranceProviderField;
    private TextField dateOfBirthField;
    private TextField idField;
    private TextField addressField;
    private TextField groupNumberField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to FX Medical Center");
        // Move the UI setup to a separate method for better readability
        setupUI(primaryStage);
        askNewOrExistingPatient(primaryStage);
    }

    private void setupUI(Stage primaryStage) {
        // Header with logout button
        HBox header = new HBox();
        Label titleLabel = new Label("Welcome to FX Medical Center");
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> primaryStage.close()); // Simplified logout action
        header.getChildren().addAll(titleLabel, logoutButton);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setSpacing(10);

        // Patient Form
        GridPane gridPane = createPatientForm();

        // Layout setup
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(header);
        borderPane.setCenter(gridPane);

        // Scene setup
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createPatientForm() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Initialize each TextField and add form fields
        nameField = new TextField();
        addFormField(gridPane, "Name", 0, nameField);

        insuranceProviderField = new TextField();
        addFormField(gridPane, "Insurance Provider", 1, insuranceProviderField);

        dateOfBirthField = new TextField();
        addFormField(gridPane, "Date of Birth", 2, dateOfBirthField);

        idField = new TextField();
        addFormField(gridPane, "ID #", 3, idField);

        addressField = new TextField();
        addFormField(gridPane, "Address", 4, addressField);

        groupNumberField = new TextField();
        addFormField(gridPane, "Group Number", 5, groupNumberField);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> saveNewPatient());
        submitButton.setMaxWidth(Double.MAX_VALUE);
        GridPane.setFillWidth(submitButton, true);
        gridPane.add(submitButton, 0, 6, 2, 1);

        return gridPane;
    }

    private void askNewOrExistingPatient(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Patient Type");
        alert.setHeaderText("Is this a new or existing patient?");
        ButtonType newPatientButton = new ButtonType("New Patient");
        ButtonType existingPatientButton = new ButtonType("Existing Patient");
        alert.getButtonTypes().setAll(newPatientButton, existingPatientButton, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == newPatientButton) {
            // Display the form for new patient data entry
        } else if (result.isPresent() && result.get() == existingPatientButton) {
            // Handle existing patient scenario
        }
    }

    private void addFormField(GridPane gridPane, String labelText, int rowIndex, TextField textField) {
        Label label = new Label(labelText + ":");
        textField.setPromptText(labelText);
        gridPane.add(label, 0, rowIndex);
        gridPane.add(textField, 1, rowIndex);
    }

    private void saveNewPatient() {
        String patientId = generatePatientId();
        // Here you'd collect data from the form fields and save the new patient
        // For now, let's just print the collected data
        System.out.println("Saving new patient with ID: " + patientId);
        System.out.println("Name: " + nameField.getText());
        System.out.println("Insurance Provider: " + insuranceProviderField.getText());
        // Add logic here to save the patient information to your data storage
    }

    private String generatePatientId() {
        return "PID-" + rand.nextInt(1_000_000);
    }

    // Dummy Patient class for table view
    public static class Patient {
        private final SimpleStringProperty name;
        private final SimpleStringProperty insuranceProvider;
        private final SimpleStringProperty dateOfBirth;
        private final SimpleStringProperty id;
        private final SimpleStringProperty address;
        private final SimpleStringProperty groupNumber;

        // Constructor initializes all properties
        private Patient(String name, String insuranceProvider, String dateOfBirth, String id, String address, String groupNumber) {
            this.name = new SimpleStringProperty(name);
            this.insuranceProvider = new SimpleStringProperty(insuranceProvider);
            this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
            this.id = new SimpleStringProperty(id);
            this.address = new SimpleStringProperty(address);
            this.groupNumber = new SimpleStringProperty(groupNumber);
        }

        // Getters for each property (add setters if necessary)
        public String getName() { return name.get(); }
        public String getInsuranceProvider() { return insuranceProvider.get(); }
        public String getDateOfBirth() { return dateOfBirth.get(); }
        public String getId() { return id.get(); }
        public String getAddress() { return address.get(); }
        public String getGroupNumber() { return groupNumber.get(); }
    }
}
