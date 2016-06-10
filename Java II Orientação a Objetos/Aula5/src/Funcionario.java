public abstract class Funcionario {
	
	private String nome;
	protected double salario;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public abstract double getBonus();
	
}