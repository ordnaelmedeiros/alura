package exercicio3;

public class TestaEmpresa {

	public static void main (String[] args) {
		Empresa empresa = new Empresa();
		empresa.empregados = new Funcionario[10];
		
		Funcionario f1 = new Funcionario();
		f1.salario = 1000;
		empresa.adiciona(f1);
		
		Funcionario f2 = new Funcionario();
		f2.salario = 1700;
		empresa.adiciona(f2);
		
		empresa.empregados[0].mostra();
		empresa.empregados[1].mostra();
	}

}
