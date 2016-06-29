package exercicio08;

public class Main {

	public static void main(String[] args) {

		Conta joao = new Conta();
		try {
			joao.deposita(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Você tentou depositar um valor inválido");
		}

		System.out.println(joao.getSaldo());

	}

}
