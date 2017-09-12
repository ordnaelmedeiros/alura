package aula1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection_1 {

	
	public static List<String> getAtributosNulos(Object o) throws Exception {
		
		try {
			
			List<String> lista = new ArrayList<>();
			
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object value = f.get(o);
				if (value==null) {
					lista.add(f.getName());
				}
			}
			
			return lista;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public static List<String> getAtributosComString(Object o, String texto) throws Exception {
		
		try {
			
			List<String> lista = new ArrayList<>();
			
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object value = f.get(o);
				if (texto.equals(value)) {
					lista.add(f.getName());
				}
			}
			
			return lista;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
