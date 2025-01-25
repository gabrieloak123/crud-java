package br.ufrn.imd.biblioteca.model;

import java.util.UUID;

import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;

public class Artigo extends ItemBiblioteca{
    private String doi;
    private String coautor;
    private String conteudo;

    public Artigo(String titulo, Idioma idioma, String autor, AreaDoConhecimento areaDoConhecimento, String doi, String coautor, String conteudo) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
        this.coautor = coautor;
        this.areaDoConhecimento = areaDoConhecimento;
        this.doi = doi;
        this.conteudo = conteudo;
    }

    public String getDoi() {
        return doi;
    }

    public String getCoautor() {
        return coautor;
    }

    public String getConteudo() {
        return conteudo;
    }
    
	@Override
    public String toString() {
    	String saida;
    	
    	saida = "Id: " + this.id + "\n";
    	saida += "Título: " + this.titulo + "\n";
    	saida += "Autor: " + this.autor + "\n";
    	saida += "Idioma: " + this.idioma + "\n";
    	saida += "Área do conhecimento: " + this.areaDoConhecimento + "\n";
    	saida += "DOI: " + this.doi + "\n";
    	saida += "======================Conteúdo======================\n";
    	saida += this.conteudo + "\n";
    	saida += "====================================================\n";

    	return saida;
    }
}
