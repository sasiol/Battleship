package fi.utu.tech.gui.javafx;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SettingsController {
	
<<<<<<< HEAD
	private Lauta lauta = new Lauta();
=======
	private Board lauta = new Board();
>>>>>>> a6fe879 (luokat)
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
	
	protected void asetaArvo(Spinner<Integer> alus, int maara) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maara, 0);
		alus.setValueFactory(valueFactory);
		
	}
		
	public void initialize() {
		asetaArvo(lta, 1);
		asetaArvo(tl, 2);
		asetaArvo(r, 3);
		asetaArvo(sv, 4);
		asetaArvo(h, 5);
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
		Node alus = (Node) event.getSource();
		Integer ruudutAtm = Integer.parseInt(ruudut.getText());
		if (alus.equals(lta) && ruudutAtm > 4) {
			ruudut.setText(String.valueOf(ruudutAtm-5));
		}else if(alus.equals(tl) && ruudutAtm > 3) {
			ruudut.setText(String.valueOf(ruudutAtm-4));
		}else if(alus.equals(r) && ruudutAtm > 2) {
			ruudut.setText(String.valueOf(ruudutAtm-3));
		}else if((alus.equals(sv) || alus.equals(h)) && ruudutAtm > 2) {
			ruudut.setText(String.valueOf(ruudutAtm-3));
		}else {
			alus.setDisable(true);
			System.out.println("Ruutuja ei enää käytettävissä");
		}
	}
	
	@FXML
	void valmisKlikattu(MouseEvent event) {
		System.out.println("valmis");
		player1.setNimi(p1.getText());
		player2.setNimi(p2.getText());
		System.out.println(player1.getNimi());
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
