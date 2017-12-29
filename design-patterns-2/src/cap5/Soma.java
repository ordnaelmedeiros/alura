package cap5;

public class Soma implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Expressao getEsquerda() {
		return esquerda;
	}
    
    public Expressao getDireita() {
		return direita;
	}
    
    public Soma(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

	@Override
	public int avalia() {
		return esquerda.avalia() + direita.avalia();
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaSoma(this);
	}
}
