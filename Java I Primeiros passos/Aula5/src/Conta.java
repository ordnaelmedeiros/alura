public class Conta {
	int numero;
	Cliente titular;
	private double saldo;
	private int limite;
	
	void deposita(double valorASerDepositado) {
		this.saldo += valorASerDepositado;
	}
	
	public boolean saca(double valor) {
		if (valor > (this.saldo + this.limite)) {
			System.out.println("Saque invalido");
			return false;
		} else {
			this.saldo -= valor;
			return true;
		}
	}
	
	public void trasfere(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
}

