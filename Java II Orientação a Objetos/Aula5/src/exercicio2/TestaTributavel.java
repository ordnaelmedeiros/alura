package exercicio2;

public class TestaTributavel {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(100);
		System.out.println(cc.calculaTributos());
		// testando polimorfismo:
		Tributavel t = cc;
		System.out.println(t.calculaTributos());
	}
}

/*
 Responda o que acontece quando voc� tenta chamar o m�todo t.getSaldo(), por que isso ocorre ?
 
Apesar de ser um objeto do tipo ContaCorrente, ao chamarmos ele de Tributavel, apenas garantimos para o compilador que aquele objeto tem os m�todos que todo Tributavel tem. E como o compilador do Java s� trabalha com certezas, ele s� permite chamar os m�todos definidos no tipo da vari�vel.

No pr�ximo exerc�cio, essa diferen�a entre o tipo da vari�vel e o objeto referenciado por ela ficar� mais clara.
*/
