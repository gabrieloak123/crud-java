package br.ufrn.imd.biblioteca.model;

import br.ufrn.imd.biblioteca.model.Enum.Privilegio;

public class Usuario {
	private String nome;
	private String senha;
	private Privilegio privilegio;
	
	public Usuario(String nome, String senha, Privilegio privilegio) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.privilegio = privilegio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Privilegio getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}
}
