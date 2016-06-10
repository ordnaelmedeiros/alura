package exercicio3;

public class TestaGerenciadorDeImpostoDeRenda {
	public static void main(String[] args) {

		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);

		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		gerenciador.adiciona(cc);

		System.out.println(gerenciador.getTotal());
	}
}

// Quais os benefícios de manter o código com baixo acoplamento?


/*
 
 Quanto menos acoplado o código, mais fácil é sua manutenção, já que alterar uma classe não deve atrapalhar o funcionamento das outras. Note que o uso de interfaces cria uma ligação entre tipos que permite o polimorfismo, mas é bem menos intrusivo do que a herança: não é possível reaproveitar código da mãe.

Por um lado, isso pode parecer negativo e, por vezes, teremos um trecho de código repetido. Mas a certeza de que, ao mudar uma classe, não afetaremos as outras, é muito confortável. Para usar interfaces e evitar a repetição, procure pelo conceito de composição.
 
*/