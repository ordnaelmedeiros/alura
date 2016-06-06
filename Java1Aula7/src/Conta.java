public class Conta {
	int numero;
	Cliente titular;
	private double saldo;
	private double limite;
	
	private static int numeroIncremental = 1;
	
	public static int x() {
		return 2*2;
	}
	
	public Conta() {
		this.numero = numeroIncremental;
		numeroIncremental ++;
	}
	
	public Conta(int numero, double limite) {
		this(numero, limite, 0);
	}
	
	public Conta(int numero, double limite, double saldo) {
		this.numero = numero;
		this.limite = limite;
		this.saldo = saldo;
	}
	
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

