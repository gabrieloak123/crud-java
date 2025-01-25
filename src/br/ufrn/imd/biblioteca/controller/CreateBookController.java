package br.ufrn.imd.biblioteca.controller;

import java.io.IOException;

import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.model.Livro;
import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;
import br.ufrn.imd.biblioteca.model.interfaces.IBotaoVoltar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateBookController implements IBotaoVoltar {
	@FXML
	private AnchorPane ancCadastrarLivro;
	
	@FXML
	private Label lblCadastraLivro;
	
	@FXML
	private TextField tfTitulo, tfAutor, tfISBN, tfQuantidadePaginas;
	
	@FXML
	private Button btnCadastrarLivro, btnVoltar;
	
	@FXML
	private ChoiceBox<String> cbIdioma;
	
	@FXML
	private ChoiceBox<String> cbAreaConhecimento;

	private String[] idiomas = {
			Idioma.Portugues.toString(),
			Idioma.Espanhol.toString(),
			Idioma.Frances.toString(),
			Idioma.Ingles.toString(
	)};
	
	private String[] areas = {
			AreaDoConhecimento.CienciasDaNatureza.toString(),
			AreaDoConhecimento.CienciasExatas.toString(),
			AreaDoConhecimento.CienciasHumanas.toString(),
			AreaDoConhecimento.CienciasSociais.toString(),
			AreaDoConhecimento.Engenharias.toString(),
			AreaDoConhecimento.Literatura.toString()
	};
	
	@FXML
	public void initialize() {
		cbIdioma.getItems().addAll(this.idiomas);
		cbAreaConhecimento.getItems().addAll(this.areas);
	}
	
	@SuppressWarnings("null")
	private boolean preencheuTudo(String[] strings) {
		for(String s : strings) {
			if(s == null && s.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private AreaDoConhecimento matchArea(String area) {
		if(area.equals(AreaDoConhecimento.CienciasDaNatureza.toString())) {
			return AreaDoConhecimento.CienciasDaNatureza;
		} else if(area.equals(AreaDoConhecimento.CienciasExatas.toString())) {
			return AreaDoConhecimento.CienciasExatas;
		}else if(area.equals(AreaDoConhecimento.CienciasHumanas.toString())) {
			return AreaDoConhecimento.CienciasHumanas;
		}else if(area.equals(AreaDoConhecimento.CienciasSociais.toString())) {
			return AreaDoConhecimento.CienciasSociais;
		}else if(area.equals(AreaDoConhecimento.Engenharias.toString())) {
			return AreaDoConhecimento.Engenharias;
		}else if(area.equals(AreaDoConhecimento.Literatura.toString())) {
			return AreaDoConhecimento.Literatura;
		}
		return null;
	}

	private Idioma matchIdioma(String idioma) {
		if(idioma.equals(Idioma.Portugues.toString())) {
			return Idioma.Portugues;
		} else if(idioma.equals(Idioma.Ingles.toString())) {
			return Idioma.Ingles;
		}else if(idioma.equals(Idioma.Frances.toString())) {
			return Idioma.Frances;
		}else if(idioma.equals(Idioma.Espanhol.toString())) {
			return Idioma.Espanhol;
		}
		return null;
	}

	@FXML
	public void cadastrarLivro(ActionEvent event) {
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String isbn = tfISBN.getText();
		String qntPaginas= tfQuantidadePaginas.getText();

		String area = cbAreaConhecimento.getValue();
		String idioma = cbIdioma.getValue();
		
		if(preencheuTudo(new String[]{titulo,autor,isbn,qntPaginas,area,idioma})) {
			Livro livro = new Livro(
				titulo,
				matchIdioma(idioma),
				autor,
				matchArea(area),
				isbn,
				qntPaginas
			);

			ItemBibliotecaDAO.getInstance().inserirLivro(livro);
		} else {
			System.out.println("Algum campo não foi preenchido!");
		}
	}

	@FXML
	public void voltar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAdmin.fxml", "Hub Admin");
	}
}
