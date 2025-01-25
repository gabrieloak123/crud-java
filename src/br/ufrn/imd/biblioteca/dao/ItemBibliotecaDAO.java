package br.ufrn.imd.biblioteca.dao;

import java.util.ArrayList;
import java.util.UUID;

import br.ufrn.imd.biblioteca.model.Artigo;
import br.ufrn.imd.biblioteca.model.ItemBiblioteca;
import br.ufrn.imd.biblioteca.model.Livro;
import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;

public class ItemBibliotecaDAO {
	private ArrayList<ItemBiblioteca> acervo;
	private static ItemBibliotecaDAO bdAcervo;
	
	private ItemBibliotecaDAO(){
		acervo  = new ArrayList<ItemBiblioteca>();
	}
	
	public static ItemBibliotecaDAO getInstance() {
		if (bdAcervo == null) {
			bdAcervo = new ItemBibliotecaDAO();
		}
		return bdAcervo;
	}
	
	public void inserirLivro(Livro livro)  {
		acervo.add(livro);
		System.out.println("Livro inserido com sucesso");
	}
	
	public void inserirArtigo(Artigo artigo)  {
		acervo.add(artigo);
		System.out.println("Artigo inserido com sucesso");
	}

	public void deletar(String id) {
		for(ItemBiblioteca i : acervo) {
			String uuid = i.getId().toString();
			if(uuid.equals(id)) {
				acervo.remove(i);
				System.out.println("Item removido!");
				return;
			}
		}
		System.out.println("Não existe livro com esse id!");
	}
	
	public String buscarPorDOI(String doi) {
		String saida = null;
		for(ItemBiblioteca i : acervo) {
			if(i instanceof Artigo) {
				Artigo artigo = (Artigo)i;
				if(artigo.getDoi().equals(doi)) {
					saida = (saida == null ? "" : saida) + artigo.toString();
				}
			}
		}
		
		if(saida == null) {
			return "Sem resultados";
		}
		
		return saida;
	}

	public String buscarPorISBN(String isbn) {
		String saida = null;
		for(ItemBiblioteca i : acervo) {
			if(i instanceof Livro) {
				Livro livro = (Livro)i;
				if(livro.getIsbn().equals(isbn)) {
					saida = (saida == null ? "" : saida) + livro.toString();
				}
			}
		}
		
		if(saida == null) {
			return "Sem resultados";
		}
		
		return saida;
	}

	public String buscarPorTitulo(String titulo) {
		String saida = null;
		for(ItemBiblioteca i : acervo) {
				if(i.getTitulo().equals(titulo)) {
					saida = (saida == null ? "" : saida) + i.toString();
				}
		}
		
		if(saida == null) {
			return "Sem resultados";
		}
		
		return saida;
	}
	
	public void seed() {
        this.acervo.add(new Livro("A Origem das Espécies", Idioma.Portugues, "Charles Darwin", AreaDoConhecimento.CienciasDaNatureza, "978-0-12345-678-9", "502"));
        this.acervo.add(new Livro("O Senhor dos Anéis", Idioma.Ingles, "J.R.R. Tolkien", AreaDoConhecimento.Literatura, "978-0-12345-111-2", "1178"));
        this.acervo.add(new Livro("O Código Da Vinci", Idioma.Portugues, "Dan Brown", AreaDoConhecimento.CienciasHumanas, "978-0-12345-222-3", "689"));
        this.acervo.add(new Livro("Breve História do Tempo", Idioma.Portugues, "Stephen Hawking", AreaDoConhecimento.CienciasExatas, "978-0-12345-333-4", "256"));
        this.acervo.add(new Livro("Matemática para Leigos", Idioma.Ingles, "Mary Jane Sterling", AreaDoConhecimento.CienciasExatas, "978-0-12345-444-5", "384"));
        this.acervo.add(new Livro("Introdução à Filosofia", Idioma.Portugues, "René Descartes", AreaDoConhecimento.CienciasHumanas, "978-0-12345-555-6", "312"));
        this.acervo.add(new Livro("Cálculo Diferencial e Integral", Idioma.Portugues, "Gilbert Strang", AreaDoConhecimento.CienciasExatas, "978-0-12345-666-7", "678"));
        this.acervo.add(new Livro("O Gene", Idioma.Ingles, "Siddhartha Mukherjee", AreaDoConhecimento.CienciasDaNatureza, "978-0-12345-777-8", "499"));
        this.acervo.add(new Livro("O Homem que Calculava", Idioma.Portugues, "Malba Tahan", AreaDoConhecimento.CienciasExatas, "978-0-12345-888-9", "320"));
        this.acervo.add(new Livro("Os Miseráveis", Idioma.Portugues, "Victor Hugo", AreaDoConhecimento.CienciasHumanas, "978-0-12345-999-0", "1463"));

        this.acervo.add(new Artigo("Inteligência Artificial e o Futuro", Idioma.Ingles, "Alan Turing", AreaDoConhecimento.Engenharias, "10.1000/xyz123", "","Exploração dos limites da IA."));
        this.acervo.add(new Artigo("A Revolução Quântica", Idioma.Frances, "Marie Curie", AreaDoConhecimento.CienciasExatas, "10.1000/xyz124", "", "Estudo sobre física quântica."));
        this.acervo.add(new Artigo("Criptografia Moderna", Idioma.Portugues, "Claude Shannon", AreaDoConhecimento.Engenharias, "10.1000/xyz125", "", "Criptografia na era digital."));
        this.acervo.add(new Artigo("A Linguagem Universal da Matemática", Idioma.Espanhol, "Carl Friedrich Gauss", AreaDoConhecimento.CienciasExatas, "", "10.1000/xyz126", "Exploração da matemática pura."));
        this.acervo.add(new Artigo("Teoria das Cordas Simplificada", Idioma.Ingles, "Brian Greene", AreaDoConhecimento.CienciasExatas, "10.1000/xyz127", "", "Introdução à teoria das cordas."));
        this.acervo.add(new Artigo("Filosofia da Ciência", Idioma.Portugues, "Karl Popper", AreaDoConhecimento.CienciasHumanas, "10.1000/xyz128", "", "Exploração filosófica sobre a ciência."));
        this.acervo.add(new Artigo("Modelos de Crescimento Populacional", Idioma.Espanhol, "Thomas Malthus", AreaDoConhecimento.CienciasSociais, "10.1000/xyz129", "", "Estudo sobre crescimento populacional."));
        this.acervo.add(new Artigo("O Futuro da Energia", Idioma.Ingles, "Nikola Tesla", AreaDoConhecimento.Engenharias, "10.1000/xyz130", "", "Visões sobre o futuro das energias renováveis."));
        this.acervo.add(new Artigo("Teoria da Evolução", Idioma.Portugues, "Charles Darwin", AreaDoConhecimento.CienciasDaNatureza, "10.1000/xyz131", "", "Exploração da teoria da evolução."));
        this.acervo.add(new Artigo("O Papel das Mulheres na Ciência", Idioma.Portugues, "Marie Curie", AreaDoConhecimento.CienciasHumanas, "10.1000/xyz132", "", "Contribuições de mulheres para a ciência."));
	}
}
