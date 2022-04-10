package fi.utu.tech.gui.javafx;


import java.util.ArrayList;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Board extends Pane{
	Pane lauta;
	public Ship prest=new Ship(0);
	@FXML
	private StackPane laivaParkki;
	
	private int koko;
	private String pelaaja;
	private ArrayList<Ship> laivat=new ArrayList<>();
	

	
	public Board(StackPane laivaParkki, int koko, String pelaaja) {
		super();
		//this.setPrefSize(400, 400);
		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		this.setScaleShape(true);
		this.setStyle("-fx-background-color:white");
		this.laivaParkki=laivaParkki;
		this.koko=koko;
		this.pelaaja=pelaaja;
		//asetetaan oiean kokoinen ruudukko
		double ruutKoko=400/koko;
		
		for(int i=0; i<koko+1; i++) {
			Line lineY=new Line(i*ruutKoko, 0, i*ruutKoko, 400);
			Line lineX=new Line(0, i*ruutKoko, 400, i*ruutKoko);
		this.getChildren().addAll(lineY,lineX);
		}
		
		
		
//		this.setOnMouseClicked(e->{
//			System.out.println("event hand");
//		 //  if((Ship)e.getTarget()==Ship)
//		        prest =  (Ship) e.getSource();
//		        
//		    });
			
		
	
		
		
		//asetetaan drag and drop
		this.setOnDragDropped(e->{
			Dragboard db= e.getDragboard();
			String Sid=db.getString();
			
			Ship la=(Ship) laivaParkki.lookup("#"+Sid);
			Ship lala=(Ship) this.lookup("#"+Sid);
			
			
			//laivaparkista laudalle siirto
			if(la!=null) {
				
				laivaParkki.getChildren().remove(la);
				
				Bounds boundsInScene = la.localToScene(la.getBoundsInLocal());
				Point2D location=new Point2D(e.getX(), e.getY());
				la.setLayoutX(location.getX());
				la.setLayoutY(location.getY());

				la.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
				laivat.add(la);
				prest=la;
				this.getChildren().add(la);
				e.setDropCompleted(true);
			}
			
			//laudan sisällä liikuttelu
			else if(lala!=null){
				
				
				Bounds boundsInScene = lala.localToScene(lala.getBoundsInLocal());
				Point2D location=new Point2D(e.getX(), e.getY());
				lala.relocate(location.getX(),location.getY());
				//prest.setLayoutY(location.getY());

				
				//this.getChildren().add(prest);
				e.setDropCompleted(true);
			}
			
			
			
		});
	
	this.setOnDragOver(e->{
		
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
	
	public ArrayList<Ship> getShips(){
		return  laivat;
	}
	public String getPelaaja() {
		return pelaaja;
	}
	
	 EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
	public void handle(MouseEvent event) {
//		System.out.println("handle toimii"+ event.getTarget().getClass());
//		System.out.println(prest.getClass());
	    if (event.getTarget().getClass()==prest.getClass()){
	    
	      prest=(Ship)event.getTarget();
	    }
	  }
	 };
	
	
	}

	
	


