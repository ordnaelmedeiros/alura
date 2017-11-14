package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dao.builder.LeilaoBuilder;
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

	@Test
	public void deveTrazerLeiloesNaoEncerradosNoPeriodo() {

		// criando as datas
		Calendar comecoDoIntervalo = Calendar.getInstance();
		comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
		Calendar fimDoIntervalo = Calendar.getInstance();

		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("XBox")
				.comValor(700.0)
				.diasAtras(2)
				.constroi();
		
		Leilao leilao2 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Geladeira")
				.comValor(1700.0)
				.diasAtras(20)
				.constroi();
		
		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

		// garantindo que a query funcionou
		assertEquals(1, leiloes.size());
		assertEquals("XBox", leiloes.get(0).getNome());

	}

	@Test
	public void naoDeveTrazerLeiloesEncerradosNoPeriodo() {

		// criando as datas
		Calendar comecoDoIntervalo = Calendar.getInstance();
		comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
		Calendar fimDoIntervalo = Calendar.getInstance();

		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("XBox")
				.comValor(700.0)
				.diasAtras(2)
				.encerrado()
				.constroi();

		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.porPeriodo(comecoDoIntervalo, fimDoIntervalo);

		// garantindo que a query funcionou
		assertEquals(0, leiloes.size());
		
	}
	
	@Test
	public void deveTrazerLeiloesDisputadosEntre() {

		// criando as datas
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comValor(100.0)
				.constroi();
		
		Leilao leilao2 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("XBox")
				.comValor(200)
				.comLance(mauricio, 100.0)
				.comLance(mauricio, 200.0)
				.comLance(mauricio, 300.0)
				.comLance(mauricio, 400.0)
				.constroi();
		
		Leilao leilao3 = new LeilaoBuilder()
				.comDono(mauricio)
				.comValor(200.0)
				.comLance(mauricio, 400.0)
				.constroi();
		
		Leilao leilao4 = new LeilaoBuilder()
				.comDono(mauricio)
				.comValor(200.0)
				.comLance(mauricio, 100.0)
				.comLance(mauricio, 200.0)
				.comLance(mauricio, 300.0)
				.comLance(mauricio, 400.0)
				.encerrado()
				.constroi();
		
		Leilao leilao5 = new LeilaoBuilder()
				.comDono(mauricio)
				.comValor(300.0)
				.constroi();
		
		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);
		leilaoDao.salvar(leilao3);
		leilaoDao.salvar(leilao4);
		leilaoDao.salvar(leilao5);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.disputadosEntre(150, 250);

		// garantindo que a query funcionou
		assertEquals(1, leiloes.size());
		assertEquals("XBox", leiloes.get(0).getNome());

	}
	
	@Test
	public void deveTrazerLeiloesDoUsuario() {

		// criando as datas
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 1")
				.comValor(100.0)
				.constroi();
		
		Leilao leilao2 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 2")
				.comValor(200)
				.comLance(mauricio, 100.0)
				.constroi();
		
		Leilao leilao3 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 3")
				.comValor(200.0)
				.comLance(mauricio, 400.0)
				.comLance(mauricio, 400.0)
				.constroi();
		
		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);
		leilaoDao.salvar(leilao3);

		// invocando o metodo para testar
		List<Leilao> leiloes = leilaoDao.listaLeiloesDoUsuario(mauricio);

		// garantindo que a query funcionou
		assertEquals(2, leiloes.size());
		assertEquals("Leilão 2", leiloes.get(0).getNome());
		assertEquals("Leilão 3", leiloes.get(1).getNome());

	}
	
	@Test
	public void deveTrazerValorInicialMedioDoUsuario() {
		
		// criando as datas
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");
		
		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 1")
				.comValor(100.0)
				.constroi();
		
		Leilao leilao2 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 2")
				.comValor(200)
				.comLance(mauricio, 100.0)
				.constroi();
		
		Leilao leilao3 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 3")
				.comValor(400.0)
				.comLance(mauricio, 400.0)
				.constroi();
		
		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);
		leilaoDao.salvar(leilao3);
		
		// invocando o metodo para testar
		double valorMedio = leilaoDao.getValorInicialMedioDoUsuario(mauricio);
		
		// garantindo que a query funcionou
		assertEquals(300, valorMedio, 0.0001);
		
	}
	
	@Test
	public void deveTrazerValorInicialMedioDoUsuarioMaisParticipacao() {
		
		// criando as datas
		Usuario mauricio = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");
		
		// criando os leiloes, cada um com uma data
		Leilao leilao1 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 1")
				.comValor(100.0)
				.comLance(mauricio, 400.0)
				.comLance(mauricio, 400.0)
				.constroi();
		
		Leilao leilao2 = new LeilaoBuilder()
				.comDono(mauricio)
				.comNome("Leilão 2")
				.comValor(200)
				.comLance(mauricio, 100.0)
				.constroi();
		
		
		// persistindo os objetos no banco
		usuarioDao.salvar(mauricio);
		leilaoDao.salvar(leilao1);
		leilaoDao.salvar(leilao2);
		
		// invocando o metodo para testar
		double valorMedio = leilaoDao.getValorInicialMedioDoUsuario(mauricio);
		
		// garantindo que a query funcionou
		assertEquals(150, valorMedio, 0.0001);
		
	}
	
	@Test
	public void deveDeletarUmleilao() {
		
		Usuario usuario = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao = new LeilaoBuilder()
			.comDono(usuario)
			.comNome("Leilão 1")
			.comValor(100.0)
			.constroi();
		
		usuarioDao.salvar(usuario);
		leilaoDao.salvar(leilao);
		
		// envia tudo para o banco de dados
		session.flush();
		
		leilaoDao.deleta(leilao);
		Leilao leilarDeletado = leilaoDao.porId(leilao.getId());

		assertNull(leilarDeletado);

	}
	
	@Test
	public void deveDeletarUmleilaoConLances() {
		
		Usuario usuario = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		// criando os leiloes, cada um com uma data
		Leilao leilao = new LeilaoBuilder()
			.comDono(usuario)
			.comNome("Leilão 1")
			.comLance(usuario, 100.0)
			.comValor(100.0)
			.constroi();
		
		usuarioDao.salvar(usuario);
		leilaoDao.salvar(leilao);
		leilaoDao.deleta(leilao);

		// envia tudo para o banco de dados
		session.flush();
		
		Leilao leilarDeletado = leilaoDao.porId(leilao.getId());

		assertNull(leilarDeletado);

	}

}
