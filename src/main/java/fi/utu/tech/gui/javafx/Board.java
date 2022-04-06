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
import javafx.scene.shape.Line;
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
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;

public class Board extends Pane{
	Pane lauta;
	private Ship prest=new Ship(null);
	@FXML
	private StackPane laivaParkki;
	
	private int koko;
	

	
	public Board(StackPane laivaParkki, int koko) {
		super();
		//this.setPrefSize(400, 400);
		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		this.setScaleShape(true);
		this.setStyle("-fx-background-color:white");
		this.laivaParkki=laivaParkki;
		this.koko=koko;
		
		//asetetaan oiean kokoinen ruudukko
		double ruutKoko=400/koko;
		
		for(int i=0; i<koko+1; i++) {
			Line lineY=new Line(i*ruutKoko, 0, i*ruutKoko, 400);
			Line lineX=new Line(0, i*ruutKoko, 400, i*ruutKoko);
		this.getChildren().addAll(lineY,lineX);
		}
		
		
		
	
		
		
		//asetetaan drag and drop
		this.setOnDragDropped(e->{
			Dragboard db= e.getDragboard();
			String Sid=db.getString();
			
			Ship la=(Ship) laivaParkki.lookup("#"+Sid);
			Ship lala=(Ship) this.lookup("#"+Sid);
			System.out.println("hee hee");
			
			//laivaparkista laudalle siirto
			if(la!=null) {
				System.out.println("nulli pulli");
				
				laivaParkki.getChildren().remove(la);
				
				Bounds boundsInScene = la.localToScene(la.getBoundsInLocal());
				Point2D location=new Point2D(e.getX(), e.getY());
				la.setLayoutX(location.getX());
				la.setLayoutY(location.getY());

				
				this.getChildren().add(la);
				e.setDropCompleted(true);
			}
			
			//laudan sisällä liikuttelu
			else if(lala!=null){
				System.out.println("laudan sisällä jejee");
				
				
				Bounds boundsInScene = lala.localToScene(lala.getBoundsInLocal());
				Point2D location=new Point2D(e.getX(), e.getY());
				lala.relocate(location.getX(),location.getY());
				//prest.setLayoutY(location.getY());

				
				//this.getChildren().add(prest);
				e.setDropCompleted(true);
			}
			
			
			
		});
	
	this.setOnDragOver(e->{
		System.out.println("DragOveeerr");
		e.acceptTransferModes(TransferMode.MOVE);
		
		e.consume();
	});

	this.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
		
		if (event.getCode() == KeyCode.R) {
			prest.setRotate(prest.getRotate()+90);
			
		}
		//voi liikutella ylös ja alas
		if (event.getCode() == KeyCode.UP) {
			prest.setLayoutY(prest.getLayoutY()-10);
			
		}
		if (event.getCode() == KeyCode.DOWN) {
			prest.setLayoutY(prest.getLayoutY()+10);
			
		}
		if (event.getCode() == KeyCode.LEFT) {
			prest.setLayoutX(prest.getLayoutX()-10);
			
		}
		if (event.getCode() == KeyCode.RIGHT) {
			prest.setLayoutX(prest.getLayoutX()+10);
			
		}
	});
	
	
	}
	
	public void setPrest(Ship laiva) {
		this.prest=laiva;
	}
}

