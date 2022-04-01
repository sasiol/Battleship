package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class setShipsController{
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
	
	public void displayShips() {
		Ship laiva=new Ship(lauta);
	
	laivaParkki.getChildren().add(laiva);
	
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