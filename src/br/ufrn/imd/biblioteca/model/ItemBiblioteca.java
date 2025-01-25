package br.ufrn.imd.biblioteca.model;

import java.util.ArrayList;
import java.util.UUID;

import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;

public abstract class ItemBiblioteca {
    protected UUID id;
    protected String titulo;
    protected String autor;
    protected Idioma idioma;
    protected AreaDoConhecimento areaDoConhecimento;

    
    public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Idioma getIdioma() {
		return idioma;
	}


	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}


	public AreaDoConhecimento getAreaDoConhecimento() {
		return areaDoConhecimento;
	}


	public void setAreaDoConhecimento(AreaDoConhecimento areaDoConhecimento) {
		this.areaDoConhecimento = areaDoConhecimento;
	}


	@Override
    public String toString() {
    	String saida;
    	
    	saida = "Id: " + this.id + "\n";
    	saida += "Título: " + this.titulo + "\n";
    	saida += "Autor: " + this.autor + "\n";
    	saida += "Idioma: " + this.idioma + "\n";
    	saida += "Área do conhecimento: " + this.areaDoConhecimento + "\n";

    	return saida;
    }
}
