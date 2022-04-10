
package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameController {
	@FXML
	private Button turnButton;
	@FXML
	private BorderPane turnPane;
	@FXML
	private Button turnExit;
	@FXML
	private StackPane peliRuutu;
	@FXML
	private Label nimi;
	@FXML
	private VBox pelaajaRuutu;
	private GridPane salaus = new GridPane();
	private ArrayList<Board> laudat = new ArrayList<>();
	public int vuoro;

	public void setVuoro(int v) {
		this.vuoro = v;
	}

	public void displayLauta(int i, String pelaaja) {
		// näytetään oikea lauta
		Board lauta = laudat.get(i);
		peliRuutu.getChildren().addAll(lauta, lauta.getSalaus());
		nimi.setText(pelaaja);
	}

	// päivitetään listat joka vaihdolla
	public void setLista(ArrayList<Board> laudat) {
		this.laudat = laudat;
	}

	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		ExitDialog exitDialog = new ExitDialog();
		exitDialog.handleExit();
	}

	// siirry väliruutuun, sama kuin PlacementControllerissa
	@FXML
	public void switchToBetweenScreen(ActionEvent event) throws IOException {
		// katotaan kenen lauta on tällä hetkellä
		Board b;
		if ((vuoro % 2) == 0) {
			b = laudat.get(0);

		} else {
			b = laudat.get(1);
		}
		// jos vastusja on hävinnyt tiedetään kuka voitti
		// jos ei voittanut niin jatketaan peliä
		System.out.println(b.getHavittu());
		if (b.getHavittu()) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("winScreen.fxml"));
			Parent root = loader.load();
			// välitetään tiedot
			WinController wController = loader.getController();
			// voittajaa
			String voittaja = nimi.getText();

			wController.setWinner(voittaja);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().addAll(this.getClass().getResource("winscreenstyle.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} else {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("betweenScreen.fxml"));
			Parent root = loader.load();
			// välitetään tiedot
			BetweenController betweeController = loader.getController();
			// lauta
			// lähetetään betweencontrollerille muuttuneet laudat
			betweeController.setLista(laudat);
			betweeController.setVuoro(vuoro);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().addAll(this.getClass().getResource("betweenScreenStyle.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
	}

	// Siirry voittoruutuun
	@FXML
	public void switchToWinScreen(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("winScreen.fxml"));
		Parent root = loader.load();

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("winscreenstyle.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}
}
