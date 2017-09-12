
public class TesteModificador {
	public static void main(String[] args) {
		
		Conta joao = new Conta(123, 100);
		
		joao.deposita(500);
		joao.saca(600);
		
		System.out.println(joao.getSaldo());
		
	}
}
