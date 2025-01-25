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

public class HubAlunoController implements IBotaoVoltar {
	@FXML
	private AnchorPane ancHubAluno;
	
	@FXML
	private MenuBar mBar;
	
	@FXML
	private MenuItem miBuscar;
	
	@FXML
	private Menu  mBuscar;
	
	@FXML
	private Label lblBemVindo, lblDesc;

	@FXML
	private Button btnVoltar;

	public void voltar(ActionEvent event) throws IOException {
		CenaController.setPrivilegio(Privilegio.Undefined);
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Login.fxml", "Login");
	}

	public void irTelaBuscar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/Search.fxml", "Buscar Item");
	}
}
