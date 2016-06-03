package exercicio7;

public class Exercicio7 {
	public static void main(String[] args) {
		int x = 13;
		System.err.print( x + " > "  );
		while ( x!=1 ) {
			if ( x%2==0 ) {
				x = x/2;
			} else {
				x = ( 3 * x ) + 1;
			}
			System.err.print( " > " + x );
		}
	}
}
