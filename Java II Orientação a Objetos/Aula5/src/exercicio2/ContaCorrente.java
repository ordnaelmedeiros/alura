package exercicio2;

public class ContaCorrente extends Conta implements Tributavel {

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
	
}
