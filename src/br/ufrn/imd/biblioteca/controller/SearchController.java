package br.ufrn.imd.biblioteca.controller;

import java.io.IOException;

import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.model.Enum.Privilegio;
import br.ufrn.imd.biblioteca.model.interfaces.IBotaoVoltar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class SearchController implements IBotaoVoltar {
	@FXML
	private AnchorPane ancBuscar;
	@FXML
	private RadioButton radioTitulo, radioDOI, radioISBN;

	@FXML
	private ToggleGroup criterioBusca;
	
	@FXML
	private TextField tfBusca;
	
	@FXML
	private TextArea taSaida;
	
	@FXML
	private Button btnBuscar, btnVoltar;
	
	public void mostrarBusca(ActionEvent event) {
		ItemBibliotecaDAO itens = ItemBibliotecaDAO.getInstance();
		
		String busca = tfBusca.getText();
		String saida = null;
		
		taSaida.clear();

		if(radioTitulo.isSelected()) {
			saida = itens.buscarPorTitulo(busca);
		} else if(radioDOI.isSelected()) {
			saida = itens.buscarPorDOI(busca);
		} else if(radioISBN.isSelected()) {
			saida = itens.buscarPorISBN(busca);
		} else {
			//exception
			taSaida.setText("Selecione um critério de busca!");
		}
		
		taSaida.setText(saida);
	}
	
	public void voltar(ActionEvent event) throws IOException {
		if(CenaController.getPrivilegio() == Privilegio.Admin) {
			CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAdmin.fxml", "Hub Admin");
		} else if(CenaController.getPrivilegio() == Privilegio.Comum) {
			CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAluno.fxml", "Hub Aluno");
		}
	}
}
