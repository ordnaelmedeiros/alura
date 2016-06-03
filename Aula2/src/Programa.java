
public class Programa {

	public static void main(String[] args) {
		
		int idadeJoao = 18;
		int idadeMaria = 21;
		
		int somaDasIdades = idadeJoao + idadeMaria;
		
		System.out.println(somaDasIdades);
		
		int numero = 10;
		System.out.println(numero);
		
		double pi = 3.1415;
		double dobroDoPi = pi * 2;
		System.out.println(dobroDoPi);
		
		boolean amigo = true;
		boolean inimigo = !amigo;
		
		boolean maiorDeIdade = idadeJoao > 18;
		
		char letra = 'M';
		
		String nomeCompleto = "João da Silva";
		System.out.println(nomeCompleto);
		
		int numeroPequeno = 32000;
		long numeroGrade = 9999999999999l;
		
		double pis = 3.14;
		float outroPi = 3.14f;
		
		long numeroLong = 314;
		int copiaNumero = (int) numeroLong;
		
		int idadeVisitante = 15;
		boolean amigoDoDono = true;
		
		if (idadeVisitante >= 60) {
			System.out.println("Aproveite a melhor idade!");
		} else if (idadeVisitante>18 || amigoDoDono) {
			System.out.println("Entra na festa!");
		} else {
			System.out.println("Volte para Casa!");
		}
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Parabéns pelo Aniversário no. i" + i);
		}
		
		int j = 1;
		while (j <= 100) {
			System.out.println("Parabéns pelo Aniversário no. j" + j);
			j++;
		}
		
		int multiplicador = 3;
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				int numeroQualquer = 10;
				System.out.println(i * multiplicador);
				System.out.println(numeroQualquer);
			}
			//System.out.println(numeroQualquer); -- não existe aqui
		}
		
		int num = 1;
		
		switch (num) {
		case 1:
			System.out.println("um");
			break;
		case 2:
			System.out.println("dois");
			break;

		default:
			System.out.println("número grande");
			break;
		}
		
	}
	
}
