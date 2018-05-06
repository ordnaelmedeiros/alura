package br.com.alura.bytebank;

import br.com.alura.bytebank.visualizador.OpcoesPagamento;
import org.apache.log4j.Logger;


public class Principal {

    static final Logger logger = Logger.getLogger(Principal.class);

    public static void main(String[] args) {



        new OpcoesPagamento().mensagemDeBoasVindas();
    }

}
