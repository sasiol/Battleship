package fi.utu.tech.gui.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("menu.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().addAll(this.getClass().getResource("menustyle.css").toExternalForm());

			stage.setTitle("Battleship");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
