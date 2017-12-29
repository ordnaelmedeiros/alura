package cap3;

public class Teste {

	public static void main(String[] args) {

		TabelaDePreco tabela = new TabelaDePrecoPadrao();
		ServicoDeEntrega entrega = new Frete();

		new CalculadoraDePrecos(tabela, entrega);

	}

}