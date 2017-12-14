package com.caelum.alura.validacao.cap1;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.Validator;

public class App {
	
	public static void main(String[] args) {
		
		validar("CPF", new CPFValidator(), new CPFFormatter(), "00951953940");
		
	}
	
	private static void validar(String nome, Validator<String> validador, Formatter formater, String valor) {
		
		try {
			validador.assertValid(valor);
			System.out.println(nome+" VALIDO : " + formater.format(valor));
		} catch (Exception e) {
			System.out.println(nome+" INVALIDO : " + e);
		}
		
	}
	
}
