package exercicio08;

public class Main {

	public static void main(String[] args) {

		Conta joao = new Conta();
		try {
			joao.deposita(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Voc� tentou depositar um valor inv�lido");
		}

		System.out.println(joao.getSaldo());

	}

}
