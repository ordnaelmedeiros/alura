package exercicio3;

public class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private Data dataEntrada;
	private String rg;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome) {
		this.nome = nome;
	}

	public double getGanhoAnual() {
		return this.salario * 12;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento (String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario (double salario) {
		this.salario = salario;
	}
	
	public Data getDataEntrada() {
		return this.dataEntrada;
	}
	
	public void setDataEntrada (Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public String getRg() {
		return this.rg;
	}
	
	public void recebeAumento(double aumento) {
		this.salario += aumento;
	}
	
	public double calculaGanhoAnual() {
		return this.salario * 12;
	}
	
	public void mostra() {
		System.out.println(this.nome + " - " + this.salario);
	}

	public void bonifica(int bonificacao) {
		this.salario += bonificacao;
	}
}