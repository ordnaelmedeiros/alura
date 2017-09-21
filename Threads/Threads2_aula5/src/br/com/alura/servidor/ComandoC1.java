package br.com.alura.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

    private PrintStream saida; //novo, atributo representa a saida do cliente

    public ComandoC1(PrintStream saida) { //novo construtor
        this.saida = saida;
    }

	@Override
	public void run() {
		//será impresso no console do servidor
	    System.out.println("Executando comando c1"); 

	    try {
	        Thread.sleep(20000);
	    } catch (InterruptedException e) {
	        throw new RuntimeException(e);
	    } 

	    //essa mensagem será enviada para o cliente
	    this.saida.println("Comando c1 executado com sucesso!");
	}

}
