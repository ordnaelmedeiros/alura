
public class TotalizadorDeBonus {
	
	private double total = 0;
	
	public void adiciona(Funcionario funcionario) {
		setTotal(getTotal() + funcionario.getBonus());
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
