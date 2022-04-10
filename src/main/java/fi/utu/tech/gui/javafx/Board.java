package fi.utu.tech.gui.javafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Board extends Pane {
	Pane lauta;
	// mitä laivaa on viimeksi klikattu
	public Ship prest = new Ship(0);
	@FXML
	private StackPane laivaParkki;

	private GridPane salaus = new GridPane();

	private int koko;
	private String pelaaja;
	private ArrayList<Ship> laivat = new ArrayList<>();
	private ArrayList<Button> nappulat = new ArrayList<>();
	private int hp;
	private boolean havittu;

	public Board(StackPane laivaParkki, int koko, String pelaaja) {
		super();

		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		this.setScaleShape(true);
		this.setStyle("-fx-background-color:white");
		this.laivaParkki = laivaParkki;
		this.koko = koko;
		this.pelaaja = pelaaja;
		// asetetaan oiean kokoinen ruudukko
		double ruutKoko = 400 / koko;

		for (int i = 0; i < koko + 1; i++) {
			// luodaan laudan ruudukko
			Line lineY = new Line(i * ruutKoko, 0, i * ruutKoko, 400);
			Line lineX = new Line(0, i * ruutKoko, 400, i * ruutKoko);
			this.getChildren().addAll(lineY, lineX);
		}

		// luodaan saman kokoinen GridPane täynnä nappuloita
		// tämä tulee pelin alkaessa estämään laivojen näkemisen
		for (int i = 0; i < koko; i++) {
			for (int j = 0; j < koko; j++) {
				Button b = new Button("?");
				nappulat.add(b);
				// kun nappulaa ḱlikataan asetetaan nappula näkymättömäksi
				// ja salaus niin että jos se on näkymätön se ei vastaan ota klikkaukisa
				b.setOnAction(event -> {
					b.setVisible(false);
					salaus.setPickOnBounds(false);

				});

				b.setPrefSize(ruutKoko, ruutKoko);
				b.setStyle("-fx-background-color:blue");
				salaus.add(b, i, j);

			}
		}

		// asetetaan drag and drop
		this.setOnDragDropped(e -> {
			Dragboard db = e.getDragboard();
			String Sid = db.getString();

			// la on laivoille jotka tulee laivaparkista
			// lala on laivoille jotka tulee laudasta
			Ship la = (Ship) laivaParkki.lookup("#" + Sid);
			Ship lala = (Ship) this.lookup("#" + Sid);

			// laivaparkista laudalle siirto
			if (la != null) {

				laivaParkki.getChildren().remove(la);

				Bounds boundsInScene = la.localToScene(la.getBoundsInLocal());
				Point2D location = new Point2D(e.getX(), e.getY());
				la.setLayoutX(location.getX());
				la.setLayoutY(location.getY());

				// asetetaan laivalle MouseEvent, hp ja viedään se prestiin
				la.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
				laivat.add(la);
				this.setHP(la.getHP());
				prest = la;
				this.getChildren().add(la);
				e.setDropCompleted(true);
			}

			// laudan sisällä liikuttelu
			else if (lala != null) {

				Bounds boundsInScene = lala.localToScene(lala.getBoundsInLocal());
				Point2D location = new Point2D(e.getX(), e.getY());
				lala.relocate(location.getX(), location.getY());
				e.setDropCompleted(true);
			}

		});

		this.setOnDragOver(e -> {

			e.acceptTransferModes(TransferMode.MOVE);

			e.consume();
		});

		// laivaa voi liikutella näppäimillä. Sitä voi kääntää tai liikutella ylös, alas
		// ja sivuille
		this.addEventFilter(KeyEvent.KEY_PRESSED, event -> {

			if (event.getCode() == KeyCode.R) {
				prest.setRotate(prest.getRotate() + 90);

			}
			// voi liikutella ylös ja alas
			if (event.getCode() == KeyCode.UP) {
				prest.setLayoutY(prest.getLayoutY() - 10);

			}
			if (event.getCode() == KeyCode.DOWN) {
				prest.setLayoutY(prest.getLayoutY() + 10);

			}
			if (event.getCode() == KeyCode.LEFT) {
				prest.setLayoutX(prest.getLayoutX() - 10);

			}
			if (event.getCode() == KeyCode.RIGHT) {
				prest.setLayoutX(prest.getLayoutX() + 10);

			}
		});

	}

	public ArrayList<Ship> getShips() {
		return laivat;
	}

	public String getPelaaja() {
		return pelaaja;
	}

	EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {

			if (event.getTarget().getClass() == prest.getClass()) {

				prest = (Ship) event.getTarget();
			}
		}
	};
	public int getHP() {
		System.out.println("HP on"+hp);
		return hp;
	};

	// asetetaan laudalle laivojen yhteinen hp
	public void setHP(int h) {
		this.hp = hp + h;
	}

	public void miinustaHP() throws IOException {
		this.hp--;
System.out.println("pelaajan "+pelaaja+"HP on"+hp);
		if (hp == 0) {
			
			
			setHavittu(true);
			System.out.println(pelaaja+"hävisi" +havittu);
		}
	}

	public GridPane getSalaus() {
		// TODO Auto-generated method stub
		return salaus;
	}
	public void setHavittu(boolean i) {
		this.havittu=i;
	}
	public boolean getHavittu() {
		return havittu;
	}

}
