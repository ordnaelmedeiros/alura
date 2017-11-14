package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {

	private Session session;
	private UsuarioDao usuarioDao;

	@Before
	public void antes() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);

		// inicia transacao
		session.beginTransaction();
	}

	@After
	public void depois() {
		// faz o rollback
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveEncontrarPeloNomeEEmail() {

		// criando um usuario e salvando antes
		// de invocar o porNomeEEmail
		Usuario novoUsuario = new Usuario("João da Silva", "joao@dasilva.com.br");
		usuarioDao.salvar(novoUsuario);

		// agora buscamos no banco
		Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("João da Silva", "joao@dasilva.com.br");

		assertEquals("João da Silva", usuarioDoBanco.getNome());
		assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());

	}

	@Test
	public void deveEncontrarPeloNomeEEmailNull() {

		// agora buscamos no banco
		Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("João da Silva 2", "joao2@dasilva.com.br");
		assertNull(usuarioDoBanco);

	}

	@Test
	public void deveDeletarUmUsuario() {
		
		Usuario usuario = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		usuarioDao.salvar(usuario);
		usuarioDao.deletar(usuario);

		// envia tudo para o banco de dados
		session.flush();

		Usuario usuarioNoBanco = usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");

		assertNull(usuarioNoBanco);

	}
	
	@Test
	public void alteraUsuario() {
		
		Usuario usuario = new Usuario("nome1", "nome1@gmail.com");

		usuarioDao.salvar(usuario);
		
		usuario.setNome("nome2");
		usuario.setEmail("nome2@gmail.com");
		
		usuarioDao.atualizar(usuario);

		session.flush();

		Usuario usuarioOriginal = usuarioDao.porNomeEEmail("nome1", "nome1@gmail.com");
		Usuario usuarioAlterado = usuarioDao.porNomeEEmail("nome2", "nome2@gmail.com");

		assertNull(usuarioOriginal);
		assertNotNull(usuarioAlterado);

	}
	
}
