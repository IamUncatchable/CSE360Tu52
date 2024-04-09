package fxMedicalCenter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Error {
	
	
	//This class generates a popup box with red text(from what is input) for any errors that are generated
	public Error(String errorMsg) {
		Stage error = new Stage();
		error.setTitle("Error");
		HBox errorPane = new HBox();
		errorPane.setAlignment(Pos.CENTER);
		Label errorLabel = new Label(errorMsg);
		errorLabel.setTextFill(Color.RED);
		errorLabel.setFont(Font.font("Times", FontWeight.BOLD, 14));
		errorLabel.setWrapText(true);
		errorLabel.setTextAlignment(TextAlignment.CENTER);
		errorPane.getChildren().add(errorLabel);
		Scene errorScene = new Scene(errorPane,400,100);
		error.setScene(errorScene);
		error.show();
	}
}
