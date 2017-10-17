package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

	private List<Vagao> vagoes;
	private int capacidade;
	
	public boolean podeReservar(int reservas) {
		return lugaresDisponiveis() > reservas; 
	}

	private int lugaresDisponiveis() {
		return capacidade - lugaresJaReservados();
	}

	private int lugaresJaReservados() {
		int lugaresJaReservados = 0;
		for(Vagao vagao : vagoes) {
			lugaresJaReservados += vagao.reservados();
		}
		return lugaresJaReservados;
	}
	
}