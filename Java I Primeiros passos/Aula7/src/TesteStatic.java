
public class TesteStatic {

	public static void main(String[] args) {
		
		Conta conta1 = new Conta();
		System.out.println(conta1.numero);
		
		Conta conta2 = new Conta();
		System.out.println(conta2.numero);
		
		System.out.println(Conta.x());
		
	}
	
}
