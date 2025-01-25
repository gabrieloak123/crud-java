package br.ufrn.imd.biblioteca.model;

import java.util.ArrayList;
import java.util.UUID;

import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;

public class Livro extends ItemBiblioteca {
    private String isbn;
    private String quantidadePaginas;

    public Livro(String titulo, Idioma idioma, String autor, AreaDoConhecimento areaDoConhecimento, String isbn, String quantidadePaginas) {
    	this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
        this.areaDoConhecimento = areaDoConhecimento;
        this.isbn = isbn;
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String toString() {
    	String saida;
    	
    	saida = "Id: " + this.id + "\n";
    	saida += "Título: " + this.titulo + "\n";
    	saida += "Autor: " + this.autor + "\n";
    	saida += "Idioma: " + this.idioma + "\n";
    	saida += "Área do conhecimento: " + this.areaDoConhecimento + "\n";
    	saida += "ISBN: " + this.isbn + "\n";
    	saida += "Quantidade de Páginas: " + this.quantidadePaginas + "\n";

    	return saida;
    }
}
