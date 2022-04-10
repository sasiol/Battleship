package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Pelin asetusten laittaminen

public class SettingsController {

	private Pelaaja player1 = new Pelaaja();
	private Pelaaja player2 = new Pelaaja();

	private ArrayList<Integer> laivat = new ArrayList<>();

	@FXML
	private MenuButton laudanKoko;

	@FXML
	private MenuItem item10;
	@FXML
	private MenuItem item9;
	@FXML
	private MenuItem item8;
	@FXML
	private MenuItem item7;
	@FXML
	private MenuItem item6;
	@FXML
	private MenuItem item5;

	@FXML
	private TextField p1;

	@FXML
	private TextField p2;

	@FXML
	private Button valmis;

	@FXML
	private Spinner<Integer> lta;
	@FXML
	private Spinner<Integer> tl;
	@FXML
	private Spinner<Integer> r;
	@FXML
	private Spinner<Integer> sv;
	@FXML
	private Spinner<Integer> h;
	@FXML
	private Label ruudut;

	private String koko;

	// asetusten alkutila
	public void initialize() {
		ruudut.setText("0");
		ValueFactory<Integer> valuelta = new ValueFactory<Integer>(lta, 5, 1, ruudut);
		lta.setValueFactory(valuelta);
		ValueFactory<Integer> valuetl = new ValueFactory<Integer>(tl, 4, 2, ruudut);
		tl.setValueFactory(valuetl);
		ValueFactory<Integer> valuer = new ValueFactory<Integer>(r, 3, 3, ruudut);
		r.setValueFactory(valuer);
		ValueFactory<Integer> valuesv = new ValueFactory<Integer>(sv, 3, 4, ruudut);
		sv.setValueFactory(valuesv);
		ValueFactory<Integer> valueh = new ValueFactory<Integer>(h, 2, 5, ruudut);
		h.setValueFactory(valueh);
	}

	// laskee montako ruutua aluksilla on käytettävissä
	@FXML
	void laudanKokoValittu(ActionEvent event) {
		koko = ((MenuItem) event.getSource()).getText();
		laudanKoko.setText(koko + "x" + koko);
		System.out.println("Nyt on hyvä koko :)");
		ruudut.setText(String.valueOf(Integer.parseInt(koko) * Integer.parseInt(koko) / 2));

		laudanKoko.setDisable(true);
	}

	// jos asetukset puutteelliset
	void alertWindow() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Attention!");
		alert.setHeaderText("Game settings are incomplete.");
		alert.setContentText("Please check that you have filled all necessary information.");

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");

		alert.showAndWait();
	}

	void makeList() {
		laivat.add(lta.getValue());
		laivat.add(tl.getValue());
		laivat.add(r.getValue());
		laivat.add(sv.getValue());
		laivat.add(h.getValue());
		System.out.println(laivat);
	}

	// asetusten valinnan jälkeen

	@FXML
	void valmisKlikattu(ActionEvent event) throws IOException {
		makeList();

		player1.setNimi(p1.getText());
		player2.setNimi(p2.getText());
		// tarkistetaan onko tarvitut tiedot
		if (player1.getNimi().isEmpty() || player2.getNimi().isEmpty() || laudanKoko.getText().isEmpty()
				|| (lta.getValue().equals(0) && tl.getValue().equals(0) && r.getValue().equals(0)
						&& sv.getValue().equals(0) && h.getValue().equals(0))) {
			alertWindow();
		} else {
			// kun kaikki asetukset OK, välitetään tehdyt valinnat shipsControlleriin ja
			// siirrytään pelilautojen asetteluun

			FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));

			Parent root = loader.load();

			// välitetään tiedot
			setShipsController shipsController = loader.getController();
			// lauta
			shipsController.createLauta(Integer.valueOf(koko), p1.getText());
			shipsController.createLauta(Integer.valueOf(koko), p2.getText());
			shipsController.displayLauta(0);

			// laivat
			shipsController.createShips(laivat, Integer.valueOf(koko));

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().addAll(this.getClass().getResource("boardStyle.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

		}

	}

}
