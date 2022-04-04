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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
		String koko = ((MenuItem) event.getSource()).getText();
		laudanKoko.setText(koko+"x"+koko);
		lauta.setKoko(Integer.parseInt(koko));
		System.out.println("Laudan koko: " + lauta.getKoko());
		ruudut.setText(String.valueOf(lauta.getKoko()*lauta.getKoko()/2));
	}
	
	
	@FXML
	void paivitaRuudut(MouseEvent event) {
		System.out.println("klikattu");
		@SuppressWarnings("unchecked")
		Spinner<Integer> kohde = (Spinner<Integer>) event.getSource();
		ValueFactory<Integer> factory = (ValueFactory<Integer>) kohde.getValueFactory();
	}
	
	@FXML
	void valmisKlikattu(ActionEvent event) throws IOException {
		//välitettävät tiedot
		int koko=Character.getNumericValue((laudanKoko.getText()).charAt(0));
		
		
		
			FXMLLoader loader=new FXMLLoader(getClass().getResource("board.fxml"));
			Parent root = loader.load();
			
			//välitetään tiedot
			setShipsController shipsController=loader.getController();
			shipsController.displayLauta(koko);
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
//		System.out.println("valmis");
//		player1.setNimi(p1.getText());
//		player2.setNimi(p2.getText());
//		ArrayList<Integer> alukset = new ArrayList<>();
//		alukset.add(lta.getValue());
//		alukset.add(tl.getValue());
//		alukset.add(r.getValue());
//		alukset.add(sv.getValue());
//		alukset.add(h.getValue());
//		lauta.setAlukset(alukset);
//		System.out.println(player1.getNimi());
//		System.out.println(player2.getNimi());
//		System.out.println(alukset);

	}
	
}
