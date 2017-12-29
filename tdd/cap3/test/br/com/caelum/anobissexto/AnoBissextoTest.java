package br.com.caelum.anobissexto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void tete400() {
		assertEquals(true, new AnoBissexto().ehBissexto(400));
	}
	
	@Test
	public void tete100() {
		assertEquals(false, new AnoBissexto().ehBissexto(100));
	}
	
	@Test
	public void tete200() {
		assertEquals(false, new AnoBissexto().ehBissexto(200));
	}
	
	@Test
	public void tete4() {
		assertEquals(true, new AnoBissexto().ehBissexto(4));
	}
	
	@Test
	public void tete2013() {
		assertEquals(false, new AnoBissexto().ehBissexto(2013));
	}
	
	@Test
	public void deveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();

	    assertEquals(true, anoBissexto.ehBissexto(2016));
	    assertEquals(true, anoBissexto.ehBissexto(2012));
	}

	@Test
	public void naoDeveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();        

	    assertEquals(false, anoBissexto.ehBissexto(2015));
	    assertEquals(false, anoBissexto.ehBissexto(2011));
	}
	
}
