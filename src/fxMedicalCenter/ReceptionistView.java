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

public class ReceptionistView {

    // You'll need to store the text fields for data retrieval
    private TextField fNameField;
    private TextField lNameField;
    private TextField genderField;
    private TextField insuranceProviderField;
    private TextField dateOfBirthField;
    private TextField addressField;
    private TextField cityField;
    private TextField stateField;
    private TextField emailField;
    private TextField groupNumberField;
    private TextField phoneField;
    private TextField zipField;



    public ReceptionistView(Stage primaryStage) {
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
        fNameField = new TextField();
        addFormField(gridPane, "First Name", 0, fNameField);
        
        lNameField = new TextField();
        addFormField(gridPane, "Last Name", 1, lNameField);
        
        dateOfBirthField = new TextField();
        addFormField(gridPane, "Date of Birth", 2, dateOfBirthField);
        
        genderField = new TextField();
        addFormField(gridPane, "Gender", 3, genderField);

        insuranceProviderField = new TextField();
        addFormField(gridPane, "Insurance Provider", 4, insuranceProviderField);
        
        groupNumberField = new TextField();
        addFormField(gridPane, "Group Number", 5, groupNumberField);

        addressField = new TextField();
        addFormField(gridPane, "Address", 6, addressField);
        
        cityField = new TextField();
        addFormField(gridPane, "City", 7, cityField);
        
        stateField = new TextField();
        addFormField(gridPane, "State", 8, stateField);
        
        zipField = new TextField();
        addFormField(gridPane, "Zip", 9, zipField);
        
        emailField = new TextField();
        addFormField(gridPane, "Email", 10, emailField);

        phoneField = new TextField();
        addFormField(gridPane, "Phone", 11, phoneField);


        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> saveNewPatient());
        submitButton.setMaxWidth(Double.MAX_VALUE);
        GridPane.setFillWidth(submitButton, true);
        gridPane.add(submitButton, 0, 12, 2, 1);

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
    
        // Here you'd collect data from the form fields and save the new patient
        // For now, let's just print the collected data
    	// Add logic here to save the patient information to your data storage
    		Patient patient = new Patient();
    		patient.newPatient(genderField.getText(),addressField.getText(),cityField.getText(),stateField.getText(),Integer.parseInt(zipField.getText()),Integer.parseInt(phoneField.getText()),emailField.getText(),Integer.parseInt(groupNumberField.getText()),insuranceProviderField.getText(),null,fNameField.getText(),lNameField.getText(),dateOfBirthField.getText());
        
    }
   
}
