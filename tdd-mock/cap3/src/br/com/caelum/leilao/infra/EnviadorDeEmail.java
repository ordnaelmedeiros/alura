package br.com.caelum.leilao.infra;

import br.com.caelum.leilao.dominio.Leilao;

public interface EnviadorDeEmail {
	void envia(Leilao leilao);
}
