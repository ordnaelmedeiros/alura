package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double mediaDeTodos;

	public void avalia(Leilao leilao) {

		double somaDeTodos = 0;
		
		for (Lance lance : leilao.getLances()) {
			
			somaDeTodos += lance.getValor();
			
			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
			if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
		
		mediaDeTodos = somaDeTodos/leilao.getLances().size();
		
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public double getMediaLance() {
		return mediaDeTodos;
	}
	
}