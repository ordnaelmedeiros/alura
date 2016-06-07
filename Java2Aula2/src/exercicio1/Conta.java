package exercicio1;

public class Conta{
	protected double saldo;
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}

}