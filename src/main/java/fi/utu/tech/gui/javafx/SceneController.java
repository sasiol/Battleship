package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneController {

	@FXML
	private boolean arePlaced;
	@FXML
	private Label nimi;
	@FXML
	private Button start;
	@FXML
	private Button betweenButton;
	@FXML
	private Button turnButton;
	@FXML 
	private Button kenttaNappi;
	@FXML 
	private Button startGameButton;
	
	
	

	//palaa menu-stageen
	@FXML
	public void switchToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		//tän controllerissa luoda listan laivoja joka välittään setshipsControllerille, joka asettaa ne laivaparkkiin
	}

	//siirry stageen laivojen asettamista varten
	//jos lauta asetetaan johonkin olioon/muuttujaan niin ehkä tää voi vaan päivittyä?
	//ja tyyliin kun molemmat laudat on asetettu niin tulee nkyviin nappi et peli alkaa
	@FXML
	public void switchToBoardCreation(ActionEvent event) throws IOException {
		//
		FXMLLoader loader= new FXMLLoader(getClass().getResource("board.fxml"));
		Parent root = loader.load();
		setShipsController sscontroller=loader.getController();
		
//		sscontroller.displayLauta();
//		sscontroller.displayShips();
		
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
	
	//siirry pelivuoro-stageen
	@FXML
	public void switchToTurnScreen(ActionEvent event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("turn.fxml"));
		
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

	
	
	@FXML
	public void switchToWinScreen(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("winScreen.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//sulje sovellus
	@FXML
	protected void handleExitButton(ActionEvent event) {
		System.out.println("Closing app.");
		Platform.exit();
	}

	//tarkistetaan onko kaikki laivat asetettu
	@FXML
	public void shipsArePlaced(ActionEvent event) {
		arePlaced = true;
		kenttaNappi.setTextFill(Color.RED);
		startGameButton.setVisible(true);
		
	}

	//päivittää laivojenasetusnäkymän?
	@FXML
	public void nextBoard(ActionEvent event) throws IOException {
		if (arePlaced == true) {
			switchToBoardCreation(event);
			
		} 
	}

}