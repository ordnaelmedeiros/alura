package br.com.caelum.palindromo;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void testeMarrocos() {
		
		String frase = "Socorram-me subi no onibus em Marrocos";
		
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo(frase);
		
		Assert.assertTrue(frase, ehPalindromo);
		
	}
	
	@Test
	public void testeMaratona() {
		
		String frase = "Anotaram a data da maratona";
		
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo(frase);
		
		Assert.assertTrue(frase, ehPalindromo);
		
	}
	
	@Test
	public void testeMaratonaHouvesse() {
		
		String frase = "E preciso amar as pessoas como se nao houvesse amanha";
		
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo(frase);
		
		Assert.assertFalse(frase, ehPalindromo);
		
	}
	
}
