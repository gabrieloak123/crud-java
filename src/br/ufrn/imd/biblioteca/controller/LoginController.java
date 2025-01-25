package br.ufrn.imd.biblioteca.controller;

import java.io.IOException;

import br.ufrn.imd.biblioteca.dao.UsuarioDAO;
import br.ufrn.imd.biblioteca.model.Enum.Privilegio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	@FXML
	private AnchorPane ancLogin;
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private Label lblError;

	@FXML
	private TextField tfUsuario;
	
	@FXML
	private PasswordField pfSenha;
	
	@FXML
	private Button btnLogin;

	@FXML
	void verificarTentativaLogin(ActionEvent event) throws IOException {
		try {
			String usuarioDigitado = tfUsuario.getText();
			String senhaDigitada = pfSenha.getText();
			
			Privilegio privilegioUsuario = UsuarioDAO.getInstance().login(usuarioDigitado, senhaDigitada);
			CenaController.setPrivilegio(privilegioUsuario);
			
			if(privilegioUsuario == Privilegio.Admin) {
				CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAdmin.fxml", "Hub Admin");
			} else if(privilegioUsuario == Privilegio.Comum) {
				CenaController.trocarCena("/br/ufrn/imd/biblioteca/view/HubAluno.fxml", "Hub Aluno");
			} else if(privilegioUsuario == Privilegio.Undefined){
				System.out.println("Usuário não cadastrado!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
