package br.ufrn.imd.biblioteca.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import br.ufrn.imd.biblioteca.model.Enum.Privilegio;

public class CenaController {
    private static Stage stage;
    private static Privilegio privilegio;

    public static Privilegio getPrivilegio() {
		return privilegio;
	}

	public static void setPrivilegio(Privilegio privilegio) {
		CenaController.privilegio = privilegio;
	}

	public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void trocarCena(String fxmlPath, String title) throws IOException {
        Parent root = FXMLLoader.load(CenaController.class.getResource(fxmlPath));
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}

