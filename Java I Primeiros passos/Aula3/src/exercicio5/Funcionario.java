package exercicio5;

import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private String departamento;
	private double salario;
	private String dataEntrada;
	private String rg;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, String rg, Double salario) {
		this.setNome(nome);
		this.setRg(rg);
		this.setSalario(salario);
		this.setDataEntrada(LocalDate.now().toString());
	}
	
	public void recebeAumento(Double valor) {
		this.salario += valor;
	}
	
	public Double calculaGanhoAnual() {
		return this.salario*12;
	}
	
	public void mostra() {
		System.out.println("RG: "+this.rg+", Nome: " + this.nome + ", Data Entrada: "+dataEntrada );
	}
	
}
