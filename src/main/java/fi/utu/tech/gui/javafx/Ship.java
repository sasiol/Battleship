package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.UUID;

import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Rectangle;

public class Ship extends Rectangle {

	UUID id = UUID.randomUUID();
	private int hp;

	public Ship(int hp) {

		this.setId(id.toString());
		this.hp = hp;
		makeDraggable();
	}

	public UUID getLaivaId() {
		return id;
	}

	void makeDraggable() {

		this.setOnMousePressed(e -> {
			((Node) e.getSource()).requestFocus();
			// jos laivan parentin parentti on peliRuutu niin silloin voi alentaa laivan
			// hpta
			if (this.getParent().getParent().getId().contentEquals("peliRuutu")) {

				hp = hp - 1;
				try {
					((Board) this.getParent()).miinustaHP();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				// nothing
			}

		});

		this.setOnDragDetected(e -> {
			Dragboard db = this.startDragAndDrop(TransferMode.ANY);
			ClipboardContent content = new ClipboardContent();
			content.putString(this.id.toString());
			db.setContent(content);

			e.consume();

		});
	}

	public int getHP() {

		return hp;
	}

}