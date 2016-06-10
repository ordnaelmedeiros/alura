
public class Cliente implements Autenticavel {
	
	public String nome;
	public String endereco;
	
	
	@Override
	public boolean autentica(int senha) {
		return false;
	}
	
}
