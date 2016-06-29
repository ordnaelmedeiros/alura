package exercicio10;

public class Main {

	public static void main(String[] args) {

		Conta joao = new Conta();
		try {
			joao.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(joao.getSaldo());

	}

}
