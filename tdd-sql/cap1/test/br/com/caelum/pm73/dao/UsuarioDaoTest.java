package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {

	@Test
	public void deveEncontrarPeloNomeEEmail() {

		Session session = new CriadorDeSessao().getSession();
		UsuarioDao usuarioDao = new UsuarioDao(session);

		// criando um usuario e salvando antes
		// de invocar o porNomeEEmail
		Usuario novoUsuario = new Usuario("João da Silva", "joao@dasilva.com.br");
		usuarioDao.salvar(novoUsuario);

		// agora buscamos no banco
		Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("João da Silva", "joao@dasilva.com.br");

		assertEquals("João da Silva", usuarioDoBanco.getNome());
		assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());

		session.close();
	}
	
	@Test(expected=NullPointerException.class)
	public void deveEncontrarPeloNomeEEmailNull() {

		Session session = new CriadorDeSessao().getSession();
		UsuarioDao usuarioDao = new UsuarioDao(session);

		// agora buscamos no banco
		Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("João da Silva 2", "joao2@dasilva.com.br");

		assertEquals("João da Silva", usuarioDoBanco.getNome());
		assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());

		session.close();
	}

}
