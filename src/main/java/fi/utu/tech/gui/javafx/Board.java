package fi.utu.tech.gui.javafx;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;

public class Board extends Pane{
	Pane lauta;
	private Ship prest;
	@FXML
	private Pane laivaParkki;
	

	
	public Board(Pane laivaParkki) {
		super();
		this.setPrefSize(400, 500);
		this.setStyle("-fx-background-color:green");
		this.laivaParkki=laivaParkki;
		
		this.setOnDragDropped(e->{
			System.out.println("Dragdropped");
			Dragboard db= e.getDragboard();
			String Sid=db.getString();
			Ship la=(Ship) laivaParkki.lookup("#"+Sid);
			System.out.println(Sid);
			if(la!=null) {
				System.out.println("Toimii");
				laivaParkki.getChildren().remove(la);
				System.out.println(la.getBoundsInLocal());
				Bounds boundsInScene = la.localToScene(la.getBoundsInLocal());
				location=new Point2D(e.getX(), e.getY());
				la.setLayoutX(location.getX());
				la.setLayoutY(location.getY());
				//Double x =db.getX()+la.getLayoutX();
//				Double y=e.getY();
				
				this.getChildren().add(la);
			}
			
		});
	
	this.setOnDragOver(e->{
		System.out.println("DragOver");
		e.acceptTransferModes(TransferMode.MOVE);
		
		e.consume();
	});

	this.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
		
		if (event.getCode() == KeyCode.R) {
			prest.setRotate(prest.getRotate()+90);
			((Shape) prest).setFill(Color.GRAY);
		}
	});
	}
	
	public void setPrest(Ship laiva) {
		this.prest=laiva;
	}
}
