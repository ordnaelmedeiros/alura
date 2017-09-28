package cap4;

public class RaizQuadrada implements Expressao {

    private Expressao numero;
    
    public RaizQuadrada(Expressao numero) {
        this.numero = numero;
    }

	@Override
	public int avalia() {
		return Double.valueOf(Math.sqrt(Double.parseDouble(""+this.numero.avalia()))).intValue();
	}
    
}