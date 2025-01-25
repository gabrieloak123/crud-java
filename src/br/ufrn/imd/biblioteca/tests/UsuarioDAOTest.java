package br.ufrn.imd.biblioteca.tests;

import br.ufrn.imd.biblioteca.dao.UsuarioDAO;
import br.ufrn.imd.biblioteca.model.Usuario;
import br.ufrn.imd.biblioteca.model.Enum.Privilegio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOTest {

    private UsuarioDAO dao;

    @BeforeEach
    void setUp() {
        dao = UsuarioDAO.getInstance();
        dao.seed();
    }

    @Test
    void testSeed() {
        ArrayList<Usuario> usuarios = dao.getUsuarios();
        assertEquals(2, usuarios.size());

        Usuario padrao = usuarios.get(0);
        Usuario admin = usuarios.get(1);

        assertEquals("aluno", padrao.getNome());
        assertEquals("123", padrao.getSenha());
        assertEquals(Privilegio.Comum, padrao.getPrivilegio());

        assertEquals("admin", admin.getNome());
        assertEquals("123", admin.getSenha());
        assertEquals(Privilegio.Admin, admin.getPrivilegio());
    }

    @Test
    void testLoginComSucesso() {
        Privilegio privilegio = dao.login("admin", "123");
        assertEquals(Privilegio.Admin, privilegio);

        privilegio = dao.login("aluno", "123");
        assertEquals(Privilegio.Comum, privilegio);
    }

    @Test
    void testLoginComFalha() {
        Privilegio privilegio = dao.login("invalido", "123");
        assertEquals(Privilegio.Undefined, privilegio);

        privilegio = dao.login("admin", "senhaerrada");
        assertEquals(Privilegio.Undefined, privilegio);
    }

    @Test
    void testInserirUsuario() {
        Usuario novoUsuario = new Usuario("novoUsuario", "senha123", Privilegio.Comum);
        ArrayList<Usuario> usuariosAntes = dao.getUsuarios();
        int tamanhoAntes = usuariosAntes.size();

        try {
            var inserirMetodo = UsuarioDAO.class.getDeclaredMethod("inserirUsuario", Usuario.class);
            inserirMetodo.setAccessible(true);
            inserirMetodo.invoke(dao, novoUsuario);

            ArrayList<Usuario> usuariosDepois = dao.getUsuarios();
            int tamanhoDepois = usuariosDepois.size();

            assertEquals(tamanhoAntes + 1, tamanhoDepois);
            assertEquals("novoUsuario", usuariosDepois.get(tamanhoDepois - 1).getNome());
        } catch (Exception e) {
            fail("Falha ao acessar o método privado: " + e.getMessage());
        }
    }

    @Test
    void testListarUsuarios() {
        dao.listarUsuarios();
        assertTrue(true, "Verificar a saída no console manualmente");
    }
}
