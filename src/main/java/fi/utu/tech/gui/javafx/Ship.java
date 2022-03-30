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
	private UUID id= UUID.randomUUID();
		private Node prest;
		private Board lauta;
	
	public Ship(Board lauta) {
		super(80, 120, Color.RED);
		this.lauta=lauta;
		makeDraggable();
	}

	// Drag effect
	private double startX;
	private double startY;

	void makeDraggable() {

		this.setOnMousePressed(e -> {
			((Node) e.getSource()).requestFocus();
			startX = e.getX();
			startY = e.getY();

			lauta.setPrest(this);

		});

		this.setOnDragDetected(e -> {
			
			//dragboard
			Dragboard db=this.startDragAndDrop(TransferMode.MOVE);
			 ClipboardContent content = new ClipboardContent();
			content.putString(this.id.toString());
			db.setContent(content);
			
			System.out.println("Tiomii" + e.getSceneX());
			Ship source=(Ship)e.getSource();
	
			source.setLayoutX(e.getSceneX() - startX);
			source.setLayoutY(e.getSceneY() - startY);
			
			e.consume();

		});
	}
}