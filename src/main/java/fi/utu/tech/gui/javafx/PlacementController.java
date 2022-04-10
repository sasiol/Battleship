package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlacementController {
	@FXML
	private boolean arePlaced;
	@FXML
	private Button startGameButton;
	@FXML
	private Button kenttaNappi;
	@FXML
	private Label nimi;

	@FXML
	public void switchToBetweenScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("betweenScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// tarkistetaan onko kaikki laivat asetettu
	@FXML
	public void shipsArePlaced(ActionEvent event) {
		arePlaced = true;
		kenttaNappi.setTextFill(Color.RED);
		startGameButton.setVisible(true);

	}

	// päivittää laivojenasetusnäkymän?
	@FXML
	public void nextBoard(ActionEvent event) throws IOException {
		if (arePlaced == true) {
			switchToBoardCreation(event);

		}
	}

	// siirry stageen laivojen asettamista varten
	// jos lauta asetetaan johonkin olioon/muuttujaan niin ehkä tää voi vaan
	// päivittyä?
	// ja tyyliin kun molemmat laudat on asetettu niin tulee nkyviin nappi et peli
	// alkaa
	// Sama kuin MenuControllerissa
	@FXML
	public void switchToBoardCreation(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
