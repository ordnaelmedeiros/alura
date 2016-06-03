public class Programa {
	
	public static void main(String[] args) {
		
		Conta mauricio = new Conta();
		mauricio.numero = 123;
		mauricio.saldo = 800.0;
		mauricio.titular = new Pessoa();
		mauricio.titular.nome = "Mauricio Aniche";
		mauricio.titular.cpf = "123456";
		mauricio.titular.dataNascimento = "10/05/1980";
		
		mauricio.agencia = 842;
		
		mauricio.deposita(100);
		mauricio.saca(5000);
		
		Conta guilherme = new Conta();
		guilherme.numero = 456;
		guilherme.saldo = 1200.0;
		guilherme.titular = new Pessoa();
		guilherme.titular.nome = "Guilherme";
		guilherme.agencia = 842;
		
		guilherme.deposita(100);
		
		mauricio.trasfere(100, guilherme);
		
		
		System.out.println(mauricio.titular.nome);
		System.out.println(mauricio.saldo);
		System.out.println(guilherme.titular.nome);
		System.out.println(guilherme.saldo);
		
	}
	
}

class Conta {
	int numero;
	Pessoa titular;
	double saldo;
	int agencia;
	
	void deposita(double valorASerDepositado) {
		this.saldo += valorASerDepositado;
	}
	
	boolean saca(double valorASerSacado) {
		if (this.saldo>=valorASerSacado) {
			this.saldo -= valorASerSacado;
			return true;
		} else {
			return false;
		}
	}
	
	void trasfere(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
		}
	}
	
}

class Pessoa {
	String nome;
	String cpf;
	String dataNascimento;
}