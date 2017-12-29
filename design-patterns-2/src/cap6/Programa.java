package cap6;

public class Programa {

	public static void main(String[] args) {
		
		Mapa mapa = new GoogleMaps();
		String conteudo = mapa.devolveMapa("Rua Vergueiro, 3185");
		
		System.out.println(conteudo);
		
	}
	
}
