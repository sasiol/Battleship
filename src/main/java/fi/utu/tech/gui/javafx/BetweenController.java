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
import javafx.stage.Stage;

public class BetweenController {
	@FXML
	private Button betweenButton;
	
private ArrayList<Board> laudat=new ArrayList<>();

private int vuoro=0;
	
	
	public void displayLauta(int i ) {
		//find laudan pelaaja
		Board lauta=laudat.get(i);
		
		//System.out.println("Laudan laivat" +laudat.get(0).getChildren());
		//peliRuutu.getChildren().add(lauta);
		//nimi.setText(lauta.getPelaaja());
		//psIkkuna.getChildren().add(nimi);
		
	}
	public void setLista(ArrayList<Board> laudat) {
		this.laudat=laudat;
	}
	public void setVuoro(int v) {
		this.vuoro=v;
	}

	// siirry pelivuoro-stageen
	@FXML
	public void switchToTurnScreen(ActionEvent event )throws IOException {
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("turn.fxml"));
		Parent root = loader.load();

		// välitetään tiedot 
		GameController gameController = loader.getController();
		// lauta
		System.out.println(vuoro);
		if((vuoro%2)==0) {
			
		System.out.println("pelaajan yks vuoro");
		String pelaajanNimi=laudat.get(0).getPelaaja();
		gameController.setLista(laudat);
		gameController.displayLauta(1,pelaajanNimi);
		vuoro=vuoro+1;
		gameController.setVuoro(vuoro);
		}else {
			System.out.println("pelaajan kaks vuoro");
			String pelaajanNimi=laudat.get(1).getPelaaja();
			gameController.setLista(laudat);
			gameController.displayLauta(0,pelaajanNimi);
			vuoro++;
			gameController.setVuoro(vuoro);
		}
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
