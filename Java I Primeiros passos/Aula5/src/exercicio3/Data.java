package exercicio3;

public class Data {
	
	int dia;
	int mes;
	int ano;
	
	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String getFormatada() {
		return dia+"/"+mes+"/"+ano;
	}
	
}
