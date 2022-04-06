package fi.utu.tech.gui.javafx;


import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Board extends Pane{
	Pane lauta;
	private Ship prest;
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
		
		//asetetaan kasvamaan ikkunan kanssa
		
		
		
		//asetetaan drag and drop
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
				Point2D location=new Point2D(e.getX(), e.getY());
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
