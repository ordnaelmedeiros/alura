package exercicio8;

public class TestaFuncionario {
	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		f1.setNome("Danilo");
		f1.setSalario(100);
		f1.setDataEntrada(new Data(1, 6, 2015));
		
		f1.mostra();
		
	}
}
