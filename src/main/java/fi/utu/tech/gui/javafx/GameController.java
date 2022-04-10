package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {

	@FXML
	private Button turnButton;
	@FXML
	private BorderPane turnPane;
	@FXML
	private Button turnExit;

	@FXML
	private Pane peliRuutu;

	private ArrayList<Board> laudat = new ArrayList<>();

	public void displayLauta(int i) {
		// find laudan pelaaja
		Board lauta = laudat.get(i);

		System.out.println("Laudan laivat" + laudat.get(0).getChildren());
		// peliRuutu.getChildren().add(lauta);
		// nimi.setText(lauta.getPelaaja());
		// psIkkuna.getChildren().add(nimi);

	}

	public void setLista(ArrayList<Board> laudat) {
		this.laudat = laudat;
	}

	// siirry väliruutuun, sama kuin PlacementControllerissa
	@FXML
	public void switchToBetweenScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("betweenScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("betweenScreenStyle.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	// Siirry voittoruutuun
	@FXML
	public void switchToWinScreen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("winScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("winscreenstyle.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		ExitDialog exitDialog = new ExitDialog();
		exitDialog.handleExit();
	}

}
