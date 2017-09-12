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

// Quais os benef�cios de manter o c�digo com baixo acoplamento?


/*
 
 Quanto menos acoplado o c�digo, mais f�cil � sua manuten��o, j� que alterar uma classe n�o deve atrapalhar o funcionamento das outras. Note que o uso de interfaces cria uma liga��o entre tipos que permite o polimorfismo, mas � bem menos intrusivo do que a heran�a: n�o � poss�vel reaproveitar c�digo da m�e.

Por um lado, isso pode parecer negativo e, por vezes, teremos um trecho de c�digo repetido. Mas a certeza de que, ao mudar uma classe, n�o afetaremos as outras, � muito confort�vel. Para usar interfaces e evitar a repeti��o, procure pelo conceito de composi��o.
 
*/