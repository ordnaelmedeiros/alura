
class Funcionario {
	
	private String nome;
	protected double salario;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getBonus() {
		return this.salario * 0.2;
	}
	
}

class Gerente extends Funcionario {
	
	@Override
	public double getBonus() {
		return this.salario * 0.3;
	}
	
}

class Desenvolvedor extends Funcionario {
	
	@Override
	public double getBonus() {
		return this.salario * 0.25;
	}
	
}


class TotalizadorDeBonus {
	
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

public class TestaFuncionario {

	public static void main(String[] args) {
		
		Funcionario joao = new Funcionario();
		joao.setSalario(1000);
		
		Gerente joaquim = new Gerente();
		joaquim.setSalario(2000);
		
		System.out.println(joao.getBonus());
		System.out.println(joaquim.getBonus());
		
		TotalizadorDeBonus totalizador = new TotalizadorDeBonus();
		totalizador.adiciona(joao);
		totalizador.adiciona(joaquim);
		
		System.out.println(totalizador.getTotal());
		
	}
	
}
