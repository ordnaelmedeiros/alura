package br.alura.refatoracao.cap6;

public enum Moeda {

	DOLAR(3.8),
	EURO(4.0);
	
	private double taxa;

	private Moeda(double taxa) {
		this.taxa = taxa;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
}
