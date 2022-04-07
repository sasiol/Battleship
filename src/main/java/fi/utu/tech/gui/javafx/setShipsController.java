package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
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
	private StackPane laivaParkki;
	@FXML
	private Label nimi;
	
	private Ship laiva;
	
	private Board lauta;
	
	private ArrayList<Board> laudat=new ArrayList<>();
	
//	public void initialize() {
//		//displayLauta(1);
//		//displayShips();
//	}
	
	

	
//	//saavat parametreina kuinka monta pitää tehdä ja koon
	public void createLentotukialus(int maara, int lkoko){
		for(int i=0; i<maara;i++) {
			double ruutu=400/lkoko;
		Ship laiva=new Ship(5);
		laiva.setWidth(ruutu);
		laiva.setHeight(5*ruutu);
		
		Bounds boundsInScene = laiva.localToScene(laiva.getBoundsInLocal());
		System.out.println(boundsInScene);
		laivaParkki.setAlignment(laiva,Pos.TOP_LEFT);
		laivaParkki.setMargin(laiva,  new Insets(10,10,10,10) );

		laivaParkki.getChildren().add(laiva);
		}
	}
public void createTaistelulaiva(int maara, int lkoko){
	for(int i=0; i<maara;i++) {
		double ruutu=400/lkoko;
	Ship laiva=new Ship(4);
	laiva.setWidth(ruutu);
	laiva.setHeight(4*ruutu);
	laivaParkki.setAlignment(laiva, Pos.TOP_CENTER);
	laivaParkki.setMargin(laiva,  new Insets(10,10,10,10) );
	laivaParkki.getChildren().add(laiva);
	}
	}
public void createRisteilija(int maara, int lkoko){
	for(int i=0; i<maara;i++) {
		double ruutu=400/lkoko;
	Ship laiva=new Ship(3);
	laiva.setWidth(ruutu);
	laiva.setHeight(3*ruutu);
	laivaParkki.setAlignment(laiva, Pos.TOP_RIGHT);
	laivaParkki.setMargin(laiva,  new Insets(10,10,10,10) );
	laivaParkki.getChildren().add(laiva);
	}
}
public void createSukellusvene(int maara, int lkoko){
	for(int i=0; i<maara;i++) {
		double ruutu=400/lkoko;
	Ship laiva=new Ship(3);
	laiva.setWidth(ruutu);
	laiva.setHeight(3*ruutu);
	laivaParkki.setAlignment(laiva, Pos.BOTTOM_RIGHT);
	laivaParkki.setMargin(laiva,  new Insets(10,10,10,10) );
	System.out.println("margin"+ laivaParkki.getMargin(laiva));
	laivaParkki.getChildren().add(laiva);
	}
}
public void createHavittaja(int maara, int lkoko){
	for(int i=0; i<maara;i++) {
		double ruutu=400/lkoko;
	Ship laiva=new Ship(0);
	laiva.setWidth(ruutu);
	laiva.setHeight(2*ruutu);
	laivaParkki.setAlignment(laiva, Pos.BOTTOM_CENTER);
	laivaParkki.setMargin(laiva,  new Insets(10,10,10,10) );
	laivaParkki.getChildren().add(laiva);
	}
}
	
//	public void displayShips() {
//		Ship laiva=new Ship(lauta);
//		laiva.setWidth(50);
//		laiva.setHeight(80);
//	
//	laivaParkki.getChildren().addAll(laiva);
//	
//}

public void createLauta(int koko, String pelaaja) {
	Board lauta=new Board(laivaParkki, koko, pelaaja);
	
	laudat.add(lauta);
	
	//psLauta.getChildren().add(lauta);
	
}
	public void displayLauta( ) {
		//find laudan pelaaja
		Board lauta=laudat.get(0);
		psLauta.getChildren().add(lauta);
		nimi.setText(lauta.getPelaaja());
		//psIkkuna.getChildren().add(nimi);
		
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

	public void setLaivaParkki(StackPane laivaParkki) {
		this.laivaParkki = laivaParkki;
	}
}