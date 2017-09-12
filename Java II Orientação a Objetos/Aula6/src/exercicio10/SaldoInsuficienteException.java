package exercicio10;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private double saldoAtual;
	
	public SaldoInsuficienteException(double saldoAtual) {
		super("Saldo Insuficente: " + saldoAtual);
		this.saldoAtual = saldoAtual;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}
	
}
