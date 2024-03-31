import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PrescriptionApplication extends Application {

    private final TableView<Prescription> table = new TableView<>();
    private final ObservableList<Prescription> data = FXCollections.observableArrayList(
            // Example data
            new Prescription(1, LocalDate.now(), 2, "Medicine A"),
            new Prescription(2, LocalDate.now().minusDays(10), 1, "Medicine B"),
            new Prescription(3, LocalDate.now().minusMonths(1), 0, "Medicine C")
    );

    @Override
    public void start(Stage stage) {
        stage.setTitle("Prescriptions");

        // Setting up the table columns
        TableColumn<Prescription, Integer> idColumn = new TableColumn<>("Prescription ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("prescriptionId"));

        TableColumn<Prescription, LocalDate> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Prescription, Integer> refillsColumn = new TableColumn<>("Refills");
        refillsColumn.setCellValueFactory(new PropertyValueFactory<>("refills"));

        TableColumn<Prescription, String> medicationColumn = new TableColumn<>("Medication Name");
        medicationColumn.setCellValueFactory(new PropertyValueFactory<>("medicationName"));

        table.setItems(data);
        table.getColumns().addAll(idColumn, dateColumn, refillsColumn, medicationColumn);

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
