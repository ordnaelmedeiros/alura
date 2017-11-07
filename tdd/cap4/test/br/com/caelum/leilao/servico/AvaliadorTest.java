package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.builder.CriadorDeLeilao;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
	}

	@After
	public void finaliza() {
		System.out.println("fim");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 250.0)
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void deveCalcularMediaDeLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double mediaEsperado = 300;

		assertEquals(mediaEsperado, leiloeiro.getMediaLance(), 0.0001);

	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.constroi();
		
		leiloeiro.avalia(leilao);

		assertEquals(200, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 200.0)
				.lance(joao, 450.0)
				.lance(jose, 120.0)
				.lance(maria, 700.0)
				.lance(joao, 630.0)
				.lance(jose, 230.0)
				.constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 700;
		double menorEsperado = 120;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 400.0)
				.lance(joao, 300.0)
				.lance(jose, 200.0)
				.lance(maria, 100.0)
				.constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 100;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);

	}

	@Test
	public void deveEncontrarOsDoisMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.constroi();
		
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(2, maiores.size());
		assertEquals(300, maiores.get(0).getValor(), 0.00001);
		assertEquals(200, maiores.get(1).getValor(), 0.00001);

	}

}
