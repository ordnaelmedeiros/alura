package br.alura.refatoracao.cap4;

public class ContaBancaria {

	private String titular;
	private double saldo;
	
	public ContaBancaria(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldo = saldoInicial;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void saca(double valor) {
		saldo -= valor;
	}
	
	public void deposita(double valor) {
		saldo += valor;
	}
	
}
