package fi.utu.tech.gui.javafx;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;

public class ExitDialog {
	
	public void handleExit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Exit game?");
	    alert.setHeaderText("Are you sure you want to exit? The game won't be saved.");
	    
	    DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(
		   getClass().getResource("exit.css").toExternalForm());
		dialogPane.getStyleClass().add("exitDialog");
		
	    alert.showAndWait();
	    
	    if (alert.getResult() == ButtonType.OK) {
			Platform.exit();
		};
	}

}
