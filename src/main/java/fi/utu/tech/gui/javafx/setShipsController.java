package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class setShipsController{
	
	//placeholder, joskus start game nappula, joka tulee kun molemmat laudat on asetettu ja peli voi alkaa
	@FXML
	private Button nextscene;
	@FXML
	private boolean arePlaced;
	@FXML
	private VBox psIkkuna;
	@FXML 
	private VBox psLauta;
	@FXML 
	private Pane laivaParkki;
	
	private Ship laiva;
	
	private Board lauta;
	
	public void initialize() {
		displayLauta();
		displayShips();
	}
	
	
	
//	//saavat parametreina kuinka monta pitää tehdä
//	public void createLentotukialus(){
//		Ship laiva=new Ship(lauta);
//		laiva.setWidth(50);
//		laiva.setHeight(50);
//	}
//public void createTaistelulaiva(){
//	Ship laiva=new Ship(lauta);
//	laiva.setWidth(40);
//	laiva.setHeight(40);
//	}
//public void createRisteilija(){
//	Ship laiva=new Ship(lauta);
//	laiva.setWidth(30);
//	laiva.setHeight(30);
//}
//public void createSukellusvene(){
//	Ship laiva=new Ship(lauta);
//	laiva.setWidth(30);
//	laiva.setHeight(30);
//}
//public void createHavittaja(){
//	Ship laiva=new Ship(lauta);
//	laiva.setWidth(20);
//	laiva.setHeight(20);
//}
//	
	public void displayShips() {
		Ship laiva=new Ship(lauta);
		laiva.setWidth(50);
		laiva.setHeight(80);
	
	laivaParkki.getChildren().addAll(laiva);
	
}
	public void displayLauta() {
		lauta=new Board(laivaParkki);
		psLauta.getChildren().add(lauta);
		
	}
	@FXML
	public void switchToBetweenScreen(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("betweenScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void nextBoard(ActionEvent event) throws IOException {
		if (arePlaced == true) {
	//		SceneController.switchToBoardCreation(event);
			
		} 
	}

	public Pane deleteShip(Ship ship) {
		laivaParkki.getChildren().remove(ship);
		return laivaParkki;
	}

	public void setLaivaParkki(Pane laivaParkki) {
		this.laivaParkki = laivaParkki;
	}
}