package exercicio14;

public class TesteFinally {

	public static void main(String[] args) {
		try {
			throw new RuntimeException("excecao forcada");
		} catch (Exception e) {
			System.out.println("deu erro");
		} finally {
			System.out.println("acabou");
		}
	}

}
