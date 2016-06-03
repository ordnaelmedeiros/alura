package exercicio6;

public class Empresa {
	
	Funcionario[] empregados;
	String cnpj;
	int livre = 0;
	
	void adiciona(Funcionario f) {
		this.empregados[this.livre] = f;
		this.livre++;
	}
	
	void mostraEmpregados() {
		for (int i = 0; i < this.livre; i++) {
			System.out.println("Funcionário na posição: " + i);
			System.out.println("R$" + this.empregados[i].salario);
		}
	}
	
	void mostraTodasAsInformacoes() {
		for (int i = 0; i < this.livre; i++) {
			System.out.println("Funcionário na posição: " + i);
			this.empregados[i].mostra();
		}
	}
	
	boolean contem(Funcionario f) {
		for (int i = 0; i < this.livre; i++) {
			if (f == this.empregados[i]) {
				return true;
			}
		}
		return false;
	}
}
