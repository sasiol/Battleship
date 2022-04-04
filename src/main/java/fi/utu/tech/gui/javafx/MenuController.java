package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	private Button start;
	@FXML
	private BorderPane menupane;

	// siirry stageen laivojen asettamista varten
	// jos lauta asetetaan johonkin olioon/muuttujaan niin ehkä tää voi vaan
	// päivittyä?
	// ja tyyliin kun molemmat laudat on asetettu niin tulee nkyviin nappi et peli
	// alkaa

	//Josba heitä tää sun kontrolleriin ja laita tilalle et miten mennään sun sceneen
	// Eli vaihda nimi ja fxml-tiedoston nimi JA fxml tiedostoissa ne nappuloiden metodit

	@FXML
	public void switchToBoardCreation(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// sulje sovellus
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		Platform.exit();
	}

}
