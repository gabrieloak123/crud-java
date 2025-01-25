package br.ufrn.imd.biblioteca;

import javafx.application.Application;
import javafx.stage.Stage;
	
import br.ufrn.imd.biblioteca.controller.CenaController;
import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.dao.UsuarioDAO;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			UsuarioDAO usuarios = UsuarioDAO.getInstance();
			ItemBibliotecaDAO itens = ItemBibliotecaDAO.getInstance();

			usuarios.seed();
			itens.seed();
			
			CenaController.setStage(primaryStage);
			CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Login.fxml","Login");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
