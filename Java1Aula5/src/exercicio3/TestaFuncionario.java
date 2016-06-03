package exercicio3;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Hugo");
		f1.setSalario(100);
		f1.bonifica(50);
		f1.setDataEntrada(new Data(1, 7, 2009));

		f1.mostra();
	}
}
