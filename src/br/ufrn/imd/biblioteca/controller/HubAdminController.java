package br.ufrn.imd.biblioteca.controller;

import java.io.IOException;

import br.ufrn.imd.biblioteca.model.Enum.Privilegio;
import br.ufrn.imd.biblioteca.model.interfaces.IBotaoVoltar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class HubAdminController implements IBotaoVoltar {
	@FXML
	private AnchorPane ancHubAdmin;
	
	@FXML
	private MenuBar mBar;
	
	@FXML
	private MenuItem miAdicionarLivro, miAdicionarArtigo, miRemover, miBuscar;
	
	@FXML
	private Menu mAdicionar, mRemover, mBuscar;
	
	@FXML
	private Label lblBemVindo, lblDesc;
	
	@FXML
	private Button btnVoltar;

	public void voltar(ActionEvent event) throws IOException {
		CenaController.setPrivilegio(Privilegio.Undefined);
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Login.fxml", "Login");
	}

	public void irTelaAdicionarLivro(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/CreateBook.fxml", "Adicionar Livro");
	}

	public void irTelaAdicionarArtigo(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/CreateArticle.fxml", "Adicionar Artigo");
	}

	public void irTelaBuscar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Search.fxml", "Buscar Item");
	}

	public void irTelaDeletar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Delete.fxml", "Deletar Item");
	}
}
