package cap5;

public class Numero implements Expressao {

    private int numero;
    
    public int getNumero() {
		return numero;
	}
    
    public Numero(int numero) {
        this.numero = numero;
    }

	@Override
	public int avalia() {
		return this.numero;
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaNumero(this);
	}
    
}