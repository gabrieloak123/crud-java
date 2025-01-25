package br.ufrn.imd.biblioteca.controller;

import java.io.IOException;

import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.model.interfaces.IBotaoVoltar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteController implements IBotaoVoltar{
	@FXML
	private Label lblRemover;
	
	@FXML
	private TextField tfRemover;
	
	@FXML
	private Button btnApagar, btnVoltar;
	
	public void voltar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAdmin.fxml", "Hub Admin");
	}
	
	public void deletarItem(ActionEvent event) {
		String entrada = tfRemover.getText();

		System.out.println("cheguei aqui");
		ItemBibliotecaDAO.getInstance().deletar(entrada);
	}
	
}
