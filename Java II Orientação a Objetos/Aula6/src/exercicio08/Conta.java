package exercicio08;

public class Conta {

	protected double saldo;

	public double getSaldo() {
		return this.saldo;
	}

	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException();
		} else {
			this.saldo += valor;
		}
	}

	public void saca(double valor) throws SaldoInsuficienteException {
		if (this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException(this.saldo);
		}
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}

}