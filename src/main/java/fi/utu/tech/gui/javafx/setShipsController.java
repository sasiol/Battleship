package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class setShipsController {

	@FXML
	private BorderPane boardPane;
	@FXML
	private Button nextScene;
	@FXML
	private boolean arePlaced;
	@FXML
	private VBox psIkkuna;
	@FXML
	private VBox psLauta;
	@FXML
	private StackPane laivaParkki;
	@FXML
	private Label nimi;
	@FXML 
	private Button boardExit;
	
	private Ship laiva;

	private Board lauta;
	private ArrayList<Board> laudat = new ArrayList<>();
	private ArrayList<Integer> laivat = new ArrayList<>();
	private Integer lkoko;

<<<<<<< HEAD
	// laivojen teko
=======
//	public void initialize() {
//		//displayLauta(1);
//		//displayShips();
//	}
>>>>>>> refs/remotes/origin/justLooks
	public void createShips(ArrayList<Integer> laivat, int lkoko) {
		this.laivat = laivat;
		this.lkoko = lkoko;
		createLentotukialus(laivat.get(0), lkoko);
		createTaistelulaiva(laivat.get(1), lkoko);
		createRisteilija(laivat.get(2), lkoko);
		createSukellusvene(laivat.get(3), lkoko);
		createHavittaja(laivat.get(4), lkoko);
	}

//	//saavat parametreina kuinka monta pitää tehdä ja koon
	public void createLentotukialus(int maara, int lkoko) {
		for (int i = 0; i < maara; i++) {
			double ruutu = 400 / lkoko;
			Ship laiva = new Ship(5);
			laiva.setWidth(ruutu);
			laiva.setHeight(5 * ruutu);

			Bounds boundsInScene = laiva.localToScene(laiva.getBoundsInLocal());

			laivaParkki.setAlignment(laiva, Pos.TOP_LEFT);
			laivaParkki.setMargin(laiva, new Insets(10, 10, 10, 10));

			laivaParkki.getChildren().add(laiva);
		}
	}

	public void createTaistelulaiva(int maara, int lkoko) {
		for (int i = 0; i < maara; i++) {
			double ruutu = 400 / lkoko;
			Ship laiva = new Ship(4);
			laiva.setWidth(ruutu);
			laiva.setHeight(4 * ruutu);
			laivaParkki.setAlignment(laiva, Pos.TOP_CENTER);
			laivaParkki.setMargin(laiva, new Insets(10, 10, 10, 10));
			laivaParkki.getChildren().add(laiva);
		}
	}

	public void createRisteilija(int maara, int lkoko) {
		for (int i = 0; i < maara; i++) {
			double ruutu = 400 / lkoko;
			Ship laiva = new Ship(3);
			laiva.setWidth(ruutu);
			laiva.setHeight(3 * ruutu);
			laivaParkki.setAlignment(laiva, Pos.TOP_RIGHT);
			laivaParkki.setMargin(laiva, new Insets(10, 10, 10, 10));
			laivaParkki.getChildren().add(laiva);
		}
	}

	public void createSukellusvene(int maara, int lkoko) {
		for (int i = 0; i < maara; i++) {
			double ruutu = 400 / lkoko;
			Ship laiva = new Ship(3);
			laiva.setWidth(ruutu);
			laiva.setHeight(3 * ruutu);
			laivaParkki.setAlignment(laiva, Pos.BOTTOM_RIGHT);
			laivaParkki.setMargin(laiva, new Insets(10, 10, 10, 10));

			laivaParkki.getChildren().add(laiva);
		}
	}

	public void createHavittaja(int maara, int lkoko) {
		for (int i = 0; i < maara; i++) {
			double ruutu = 400 / lkoko;
			Ship laiva = new Ship(2);
			laiva.setWidth(ruutu);
			laiva.setHeight(2 * ruutu);
			laivaParkki.setAlignment(laiva, Pos.BOTTOM_CENTER);
			laivaParkki.setMargin(laiva, new Insets(10, 10, 10, 10));
			laivaParkki.getChildren().add(laiva);
		}
	}

	// tehdään lauta
	public void createLauta(int koko, String pelaaja) {
		Board lauta = new Board(laivaParkki, koko, pelaaja);

		laudat.add(lauta);

		// psLauta.getChildren().add(lauta);

	}

	// näytetään lauta
	public void displayLauta(int i) {
		// find laudan pelaaja
		Board lauta = laudat.get(i);
		psLauta.getChildren().add(lauta);
		nimi.setText(lauta.getPelaaja());
		// psIkkuna.getChildren().add(nimi);

	}

	@FXML
	public void nextBoard(ActionEvent event) throws IOException {

		psLauta.getChildren().clear();
		laivaParkki.getChildren().clear();
		createShips(laivat, lkoko);
		displayLauta(1);
		// }
	}

	@FXML
	public void switchToNextScene(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("betweenScreen.fxml"));
		Parent root = loader.load();

		// välitetään tiedot
		BetweenController betweeController = loader.getController();

		betweeController.setLista(laudat);
		betweeController.displayLauta(0);

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(this.getClass().getResource("betweenScreenStyle.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	public Pane deleteShip(Ship ship) {
		laivaParkki.getChildren().remove(ship);
		return laivaParkki;
	}

	public void setLaivaParkki(StackPane laivaParkki) {
		this.laivaParkki = laivaParkki;
	}
	
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		ExitDialog exitDialog = new ExitDialog();
		exitDialog.handleExit();
	}
}