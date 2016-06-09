package exercicio4;

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
	
}
