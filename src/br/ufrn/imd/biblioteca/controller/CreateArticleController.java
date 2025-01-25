package br.ufrn.imd.biblioteca.controller;


import java.io.IOException;

import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.model.Artigo;
import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;
import br.ufrn.imd.biblioteca.model.interfaces.IBotaoVoltar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateArticleController implements IBotaoVoltar {
	@FXML
	private AnchorPane ancHubAdmin;

	@FXML
	private Button btnVoltar, btnCadastrarArtigo;

	@FXML
	private TextField tfTitulo, tfAutor, tfCoautor, tfDOI;
	
	@FXML
	private ChoiceBox<String> cbAreaDoConhecimento;
	
	@FXML
	private ChoiceBox<String> cbIdioma;
	
	@FXML
	private TextArea taConteudo;
	
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
		cbAreaDoConhecimento.getItems().addAll(this.areas);
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
	public void cadastrarArtigo(ActionEvent event) {
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String coautor = tfCoautor.getText();
		String doi = tfDOI.getText();
		String conteudo = taConteudo.getText();

		String area = cbAreaDoConhecimento.getValue();
		String idioma = cbIdioma.getValue();
		
		if(preencheuTudo(new String[]{titulo,autor,coautor,doi,area,idioma})) {

			Artigo artigo = new Artigo(
				titulo,
				matchIdioma(idioma),
				autor,
				matchArea(area),
				doi,
				coautor,
				conteudo
			);

			ItemBibliotecaDAO.getInstance().inserirArtigo(artigo);
		} else {
			System.out.println("Algum campo não foi preenchido!");
		}
	}

	public void voltar(ActionEvent event) throws IOException {
		CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAdmin.fxml", "Hub Admin");
	}
}
