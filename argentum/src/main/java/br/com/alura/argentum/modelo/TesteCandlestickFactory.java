package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TesteCandlestickFactory {
	
	public static void main(String[] args) {

		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(37.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.5, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(negociacoes, hoje);

		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());

	}

}
