package br.ufrn.imd.biblioteca.tests;

import br.ufrn.imd.biblioteca.dao.ItemBibliotecaDAO;
import br.ufrn.imd.biblioteca.model.Artigo;
import br.ufrn.imd.biblioteca.model.Livro;
import br.ufrn.imd.biblioteca.model.Enum.AreaDoConhecimento;
import br.ufrn.imd.biblioteca.model.Enum.Idioma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemBibliotecaDAOTest {

    private ItemBibliotecaDAO dao;

    @BeforeEach
    void setUp() {
        dao = ItemBibliotecaDAO.getInstance();
        dao.seed();
    }

    @Test
    void testInserirLivro() {
        Livro livro = new Livro("Teste Livro", Idioma.Portugues, "Autor Teste", AreaDoConhecimento.CienciasExatas, "123-456-789", "200");
        dao.inserirLivro(livro);

        String resultado = dao.buscarPorISBN("123-456-789");
        assertNotNull(resultado);
        assertTrue(resultado.contains("Teste Livro"));
    }

    @Test
    void testInserirArtigo() {
        Artigo artigo = new Artigo("Teste Artigo", Idioma.Ingles, "Autor Artigo", AreaDoConhecimento.CienciasHumanas, "10.1000/teste123", "", "Resumo do artigo");
        dao.inserirArtigo(artigo);

        String resultado = dao.buscarPorDOI("10.1000/teste123");
        assertNotNull(resultado);
        assertTrue(resultado.contains("Teste Artigo"));
    }

    @Test
    void testDeletar() {
        Livro livro = new Livro("Livro para Deletar", Idioma.Portugues, "Autor Teste", AreaDoConhecimento.Literatura, "111-222-333", "150");
        dao.inserirLivro(livro);

        String resultado = dao.buscarPorISBN("111-222-333");
        assertNotNull(resultado);

        dao.deletar(livro.getId().toString());

        resultado = dao.buscarPorISBN("111-222-333");
        assertEquals("Sem resultados", resultado);
    }

    @Test
    void testBuscarPorDOI() {
        String resultado = dao.buscarPorDOI("10.1000/xyz123");
        assertNotNull(resultado);
        assertTrue(resultado.contains("Inteligência Artificial e o Futuro"));
    }

    @Test
    void testBuscarPorISBN() {
        String resultado = dao.buscarPorISBN("978-0-12345-678-9");
        assertNotNull(resultado);
        assertTrue(resultado.contains("A Origem das Espécies"));
    }

    @Test
    void testBuscarPorTitulo() {
        String resultado = dao.buscarPorTitulo("O Senhor dos Anéis");
        assertNotNull(resultado);
        assertTrue(resultado.contains("J.R.R. Tolkien"));
    }

    @Test
    void testBuscarPorTituloSemResultados() {
        String resultado = dao.buscarPorTitulo("Livro Inexistente");
        assertEquals("Sem resultados", resultado);
    }

    @Test
    void testBuscarPorDOISemResultados() {
        String resultado = dao.buscarPorDOI("10.9999/inexistente");
        assertEquals("Sem resultados", resultado);
    }

    @Test
    void testBuscarPorISBNSemResultados() {
        String resultado = dao.buscarPorISBN("000-000-000");
        assertEquals("Sem resultados", resultado);
    }
}
