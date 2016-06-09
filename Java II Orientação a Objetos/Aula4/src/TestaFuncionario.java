
public class TestaFuncionario {

	public static void main(String[] args) {
		
		Funcionario joao = new Desenvolvedor();
		joao.setSalario(1000);
		
		Gerente joaquim = new Gerente();
		joaquim.setSalario(2000);
		
		System.out.println(joao.getBonus());
		System.out.println(joaquim.getBonus());
		
		TotalizadorDeBonus totalizador = new TotalizadorDeBonus();
		totalizador.adiciona(joao);
		totalizador.adiciona(joaquim);
		
		System.out.println(totalizador.getTotal());
		
	}
	
}
