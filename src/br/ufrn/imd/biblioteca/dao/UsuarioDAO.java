package br.ufrn.imd.biblioteca.dao;

import java.util.ArrayList;

import br.ufrn.imd.biblioteca.model.Usuario;
import br.ufrn.imd.biblioteca.model.Enum.Privilegio;

public class UsuarioDAO {
	private static UsuarioDAO bdUsuario;
	private ArrayList<Usuario> usuarios;
	
	private UsuarioDAO(){
		usuarios  = new ArrayList<Usuario>();
	}
	
	public static UsuarioDAO getInstance() {
		if (bdUsuario == null) {
			bdUsuario = new UsuarioDAO();
		}
		return bdUsuario;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	private void inserirUsuario(Usuario u)  {
		usuarios.add(u);
		System.out.println("Cliente Inserido com sucesso!!");
	}
	
	public void seed() {
		Usuario padrao = new Usuario("aluno","123",Privilegio.Comum);
		Usuario admin = new Usuario("admin", "123", Privilegio.Admin);
		
		this.usuarios.add(padrao);
		this.usuarios.add(admin);
	}
	
	public void listarUsuarios() {
		for(Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
	}
	
	public Privilegio login(String nome, String senha) {
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome) && u.getSenha().equals(senha)) {
				return u.getPrivilegio();
			}
		}
		return Privilegio.Undefined;
	}
}
