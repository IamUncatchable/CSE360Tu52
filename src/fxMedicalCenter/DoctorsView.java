package fxMedicalCenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DoctorsView extends Application {

 private Label patientInfo;
 private Label weight;
 private Label height;
 private Label temperatureLabel;
 private Label bloodPressureLabel;
 // ... other UI components as needed

 @Override
 public void start(Stage primaryStage) {
     primaryStage.setTitle("Doctor's POV");

     // Initialize UI components
     patientInfo = new Label("Patient Name, DOB, Age, Gender");
     weight = new Label("Weight: ");
     height = new Label("Height: ");
     temperatureLabel = new Label("Temperature: ");
     bloodPressureLabel = new Label("Blood Pressure: ");
     // ... initialize other UI components similarly

     // Layout setup (no changes from your original code)
     HBox topSection = new HBox(10, patientInfo, weight, height, new Label("Today's Date"), new Button("Logout"));
     VBox leftSection = new VBox(10, new Label("Nurse's Notes"), new TextArea(), new Label("Exam Notes"), new TextArea());
     VBox rightSection = new VBox(10, temperatureLabel, bloodPressureLabel, new CheckBox("Allergies"), new CheckBox("Heart Problems"), new CheckBox("Diabetes"), new Button("Previous Visits"), new Button("Previously Prescribed Medications"));
     HBox bottomSection = new HBox(10, new TextArea(), new Button("Order Prescription"), new Button("Visit Summary"));

     // Root Layout
     BorderPane root = new BorderPane();
     root.setTop(topSection);
     root.setLeft(leftSection);
     root.setRight(rightSection);
     root.setBottom(bottomSection);

     // Scene and Stage setup
     Scene scene = new Scene(root, 800, 600);
     primaryStage.setScene(scene);

     // Load patient data and update UI
     loadPatientData("P12345"); // Example patient ID

     primaryStage.show();
 }

 private void loadPatientData(String patientID) {
     Database db = new Database();
     db.setQuery("patients", "patient_id", patientID);
     db.query();
     if (db.next()) {
         String fullName = db.getString("first_name") + " " + db.getString("last_name");
         String dob = db.getString("birthday"); // Ensure this column name matches your schema
         // ... get other patient details as needed
         
         // Update UI components on the JavaFX Application Thread
         Platform.runLater(() -> {
             patientInfo.setText(fullName + ", DOB: " + dob + ", ..."); // Add other details
             weight.setText("Weight: " + db.getString("weight")); // Assuming weight is a string
             height.setText("Height: " + db.getString("height")); // Assuming height is a string
             temperatureLabel.setText("Temperature: " + db.getString("temperature")); // Assuming you have a temperature column
             bloodPressureLabel.setText("Blood Pressure: " + db.getString("blood_pressure")); // Assuming you have a blood_pressure column
             // ... update other UI components as needed
         });
     }
 }

 public static void main(String[] args) {
     launch(args);
 }
}