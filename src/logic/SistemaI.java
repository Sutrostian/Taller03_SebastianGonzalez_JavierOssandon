package logic;
import java.util.ArrayList;
import domain.*;


public class SistemaI implements ISistema {
	
	private ArrayList<Mago> magos = new ArrayList<Mago>();
	private ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();

	@Override
	public void crearHechizo(String nombreHechizo, String tipo, int dano, int atributo1, int atributo2) {
		
		Hechizo nuevoHechizo = null;
		
		if(tipo.equalsIgnoreCase("Fuego")) {
			nuevoHechizo = new HechizoFuego(nombreHechizo, tipo, dano, atributo1);
		}
		
		if(tipo.equalsIgnoreCase("Tierra")) {
			nuevoHechizo = new HechizoTierra(nombreHechizo, tipo, dano, atributo1);
		}
		
		if(tipo.equalsIgnoreCase("Planta")) {
			nuevoHechizo = new HechizoPlanta(nombreHechizo, tipo, dano, atributo1, atributo2 );
		}
		
		if(tipo.equalsIgnoreCase("Agua")) {
			nuevoHechizo = new HechizoAgua(nombreHechizo, tipo, dano, atributo1, atributo2);
		}
		
		hechizos.add(nuevoHechizo);
		
	}

	@Override
	public void crearMago(String nombreMago, Hechizo hechizo) {
		
		Mago m = new Mago(nombreMago, new ArrayList<Hechizo>());
		
		if(hechizo != null) {
			
	        m.agregarHechizo(hechizo);
	    }
		
		magos.add(m);
		
	}

	@Override
	public Hechizo buscarHechizo(String nombreHechizo) {
		
	    for(Hechizo h : hechizos) {
	    	
	        if(h.getNombreHechizo().equalsIgnoreCase(nombreHechizo)) {
	            return h;
	        }
	    }
		return null;
	}

	@Override
	public Mago buscarMago(String nombreMago) {
		
		for (Mago m : magos) {
			
			 if(m.getNombreMago().equalsIgnoreCase(nombreMago)) {
		            return m;
		     }
		}
		return null;
	}

	@Override
	public void mostrarHechizos() {
		
		 System.out.println("===== HECHIZOS =====");

		    for(Hechizo h : hechizos) {
		        System.out.println(h);
		    }
		
	}

	@Override
	public void mostrarMagos() {
		
		System.out.println("===== MAGOS =====");

	    for(Mago m : magos) {
	        System.out.println(m);
	    }
		
	}
}
