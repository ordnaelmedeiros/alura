
public class Main {

	public static void main(String[] args) {
		
		Conta joao = new Conta();
		joao.deposita(50);
		
		try {
			joao.saca(100);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(joao.getSaldo());
		
	}
	
}
