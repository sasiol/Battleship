package fi.utu.tech.gui.javafx;

import javafx.scene.control.Alert;

public class Dialogs {
    public static void warning(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}