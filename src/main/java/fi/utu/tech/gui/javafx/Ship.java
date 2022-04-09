package fi.utu.tech.gui.javafx;

import java.util.UUID;

import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Ship extends Rectangle{
	// onko nodea klikattu
	UUID id= UUID.randomUUID();
		//private Board lauta;
		private int hp;
	
	public Ship(int hp) {
	//	super( Color.RED);
		this.setId(id.toString());
		this.hp=hp;
		//this.lauta=lauta;
		makeDraggable();
	}
	
	public UUID getLaivaId() {
		return id;
	}

	// Drag effect
//	private double startX;
//	private double startY;
//	
//	public void setStartCoords(double x, double y) {
//		this.startX=x;
//		this.startY=y;
//	}

	
	void makeDraggable() {

		this.setOnMousePressed(e -> {
			((Node) e.getSource()).requestFocus();
			System.out.println("laivan parent"+this.getParent().getParent().getId());
			if(this.getParent().getParent().getId().contentEquals("peliRuutu")) {
				System.out.println("hp ennen"+hp);
				hp=hp-1;
				((Board) this.getParent()).miinustaHP();
//				((Board) this.getParent()).setClickable(true);
				
			}
			else {
				//nothing
			}
////			startX = e.getX();
////			startY = e.getY();
//
//
//		});
//		this.setOnMouseDragged(e->{
//			this.setLayoutX(e.getSceneX() - startX);
//			this.setLayoutY(e.getSceneY() - startY);
		});

		this.setOnDragDetected(e -> {
			//System.out.println("drag detetecyted");
			//dragboard
			Dragboard db=this.startDragAndDrop(TransferMode.ANY);
			 ClipboardContent content = new ClipboardContent();
			content.putString(this.id.toString());
			db.setContent(content);
			
			//Ship source=(Ship)e.getSource();
	
			
			
			e.consume();

		});
	//}
}

	public int getHP() {
		
		return hp;
	}

}