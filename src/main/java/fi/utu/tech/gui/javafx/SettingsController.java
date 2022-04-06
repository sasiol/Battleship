package fi.utu.tech.gui.javafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SettingsController {
	
	private Lauta lauta = new Lauta();
	private Pelaaja player1 = new Pelaaja();
	private Pelaaja player2 = new Pelaaja();
		
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

		
	public void initialize() {
		ruudut.setText("0");
		ValueFactory<Integer> valuelta = new ValueFactory<Integer>(lta,5,1,ruudut);
		lta.setValueFactory(valuelta);
		ValueFactory<Integer> valuetl = new ValueFactory<Integer>(tl,4,2,ruudut);
		tl.setValueFactory(valuetl);
		ValueFactory<Integer> valuer = new ValueFactory<Integer>(r,3,3,ruudut);
		r.setValueFactory(valuer);
		ValueFactory<Integer> valuesv = new ValueFactory<Integer>(sv,2,4,ruudut);
		sv.setValueFactory(valuesv);
		ValueFactory<Integer> valueh = new ValueFactory<Integer>(h,2,5,ruudut);
		h.setValueFactory(valueh);
	}
	
	@FXML
	void laudanKokoValittu(ActionEvent event) {
		koko = ((MenuItem) event.getSource()).getText();
		laudanKoko.setText(koko+"x"+koko);
		lauta.setKoko(Integer.parseInt(koko));
		System.out.println("Laudan koko: " + lauta.getKoko());
		ruudut.setText(String.valueOf(lauta.getKoko()*lauta.getKoko()/2));
		laudanKoko.setDisable(true);
	}
	
	void alertWindow() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Huomio!");
		alert.setHeaderText("Pelin asetukset ovat puuttelliset");
		alert.setContentText("Tarkista, että kaikki tietokentät ovat täytetty.");
		alert.showAndWait();
	}
	
	
	@FXML
	void valmisKlikattu(ActionEvent event) throws IOException {
		player1.setNimi(p1.getText());
		player2.setNimi(p2.getText());
		if (player1.getNimi().isEmpty() || player2.getNimi().isEmpty() || laudanKoko.getText().isEmpty()
				|| (lta.getValue().equals(0) && tl.getValue().equals(0) && r.getValue().equals(0) && sv.getValue().equals(0) && h.getValue().equals(0))) {
			alertWindow();
		}else {
		//välitettävät tiedot

	
		System.out.println(lta.getValue());
		System.out.println(r.getValue());
	
	//
		
		
		
			FXMLLoader loader=new FXMLLoader(getClass().getResource("board.fxml"));
			Parent root = loader.load();
			
			//välitetään tiedot
			setShipsController shipsController=loader.getController();
			//lauta
			shipsController.displayLauta(Integer.valueOf(koko));
			//laivat
			shipsController.createLentotukialus(lta.getValue(),Integer.valueOf(koko) );
			shipsController.createTaistelulaiva(tl.getValue(),Integer.valueOf(koko) );
			shipsController.createRisteilija(r.getValue(),Integer.valueOf(koko) );
			shipsController.createSukellusvene(sv.getValue(),Integer.valueOf(koko) );
			shipsController.createHavittaja(h.getValue(),Integer.valueOf(koko) );
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		

	}
	
}
