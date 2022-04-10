package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BetweenController {
	@FXML
	private Button betweenButton;

	// vaihtaa pelivuoro-stageen, hakee resources-kansiosta pelivuoron fxml-pohjan
	// ja css-tyylin.
	@FXML
	public void switchToTurnScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("turn.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);

		scene.getStylesheets().addAll(this.getClass().getResource("turnStyle.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}

}
