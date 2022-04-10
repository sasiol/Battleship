package fi.utu.tech.gui.javafx;

import java.io.IOException;

import fi.utu.tech.gui.javafx.ExitDialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	private Button start;
	@FXML
	private BorderPane menupane;

	// siirry asetukset-stageen

	@FXML
	public void switchToSettings(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("settingsStyle.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
	}

	// sulje sovellus ja varmista haluaako pelaaja varmasti poistua
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		ExitDialog exitDialog = new ExitDialog();
		exitDialog.handleExit();
	}

}
