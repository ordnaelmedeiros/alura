package exercicio4;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.setNome("Danilo");
		f1.setSalario(100);

		Funcionario f2 = new Funcionario();
		f2.setNome("Danilo");
		f2.setSalario(100);
		
		if (f1 == f2) {
			System.out.println("iguais");
		} else {
			System.out.println("diferentes");
		}
	}
}
