package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.LeilaoDao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTest {
	
	private Session session;
	private LeilaoDao leilaoDao;
	private UsuarioDao usuarioDao;
	
	@Before
    public void antes() {
        session = new CriadorDeSessao().getSession();
        leilaoDao = new LeilaoDao(session);
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
	public void deveContarLeiloesNaoEncerrados() {
		
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao ativo = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado = new Leilao("XBox", 700.0, mauricio, false);
		encerrado.encerra();

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(ativo);
		leilaoDao.salvar(encerrado);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		long total = leilaoDao.total();

		assertEquals(1L, total);
		
	}
	
	@Test
	public void deveContarLeiloesNaoEncerradosMesmoSemLeiloes() {
		
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao encerrado1 = new Leilao("Geladeira", 1500.0, mauricio, false);
		Leilao encerrado2 = new Leilao("XBox", 700.0, mauricio, false);
		encerrado1.encerra();
		encerrado2.encerra();

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(encerrado1);
		leilaoDao.salvar(encerrado2);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		long total = leilaoDao.total();

		assertEquals(0L, total);
		
	}
	
	@Test
	public void deveContarLeiloesNovos() {
		
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criamos os dois leiloes
		Leilao velho = new Leilao("Geladeira", 1500.0, mauricio, true);
		Leilao novo = new Leilao("XBox", 700.0, mauricio, false);
		velho.encerra();
		novo.encerra();

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(velho);
		leilaoDao.salvar(novo);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		List<Leilao> novos = leilaoDao.novos();

		assertEquals(1L, novos.size());
		assertEquals(novo.getNome(), novos.get(0).getNome());
		
	}
	
	@Test
	public void deveContarLeiloesAntigos() {
		
		// criamos um usuario
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		Calendar dataVelha1 = Calendar.getInstance();
		dataVelha1.add(Calendar.DAY_OF_MONTH, -6);
		
		Calendar dataVelha2 = Calendar.getInstance();
		dataVelha2.add(Calendar.DAY_OF_MONTH, -7);
		
		Calendar dataVelha3 = Calendar.getInstance();
		dataVelha3.add(Calendar.DAY_OF_MONTH, -8);
		
		// criamos os dois leiloes
		Leilao velho1 = new Leilao("Geladeira", 1500.0, mauricio, true);
		Leilao velho2 = new Leilao("XBox", 700.0, mauricio, false);
		Leilao velho3 = new Leilao("Play Station", 750.0, mauricio, false);
		velho1.setDataAbertura(dataVelha1);
		velho2.setDataAbertura(dataVelha2);
		velho3.setDataAbertura(dataVelha3);

		// persistimos todos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(velho1);
		leilaoDao.salvar(velho2);
		leilaoDao.salvar(velho3);

		// invocamos a acao que queremos testar
		// pedimos o total para o DAO
		List<Leilao> antigos = leilaoDao.antigos();

		assertEquals(2L, antigos.size());
		assertEquals(velho2.getNome(), antigos.get(0).getNome());
		assertEquals(velho3.getNome(), antigos.get(1).getNome());
		
	}

}
