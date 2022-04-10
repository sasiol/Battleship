package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WinController {
	@FXML
	private BorderPane winpane;

	// palaa menu-stageen
	@FXML
	public void switchToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		
		scene.getStylesheets().addAll(this.getClass().getResource("menustyle.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
	}

	// sulje sovellus, sama kuin MenuControllerissa
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		Platform.exit();
	}

}
