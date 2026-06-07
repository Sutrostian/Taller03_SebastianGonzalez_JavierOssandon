package domain;
import java.util.ArrayList;

public class Mago {
	
	private String nombreMago;
	private ArrayList <Hechizo> hechizos;
	
	public Mago(String nombreMago, ArrayList<Hechizo> hechizos) {
		super();
		this.nombreMago = nombreMago;
		this.hechizos = hechizos;
	}

	public String getNombreMago() {
		return nombreMago;
	}

	public void setNombreMago(String nombreMago) {
		this.nombreMago = nombreMago;
	}

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
	    hechizos.add(hechizo);
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Mago: ").append(nombreMago).append("\n");
	    sb.append("  Hechizos:\n");
	    for(Hechizo h : hechizos) {
	        sb.append("    - ").append(h.getNombreHechizo()).append(" [").append(h.getTipo()).append("]\n");
	    }
	    return sb.toString();
	}
	
	
	
	public boolean eliminarHechizo(String nombreHechizo) {
		
		for(int i = 0; i < hechizos.size(); i++) {
			
			if(hechizos.get(i).getNombreHechizo().equalsIgnoreCase(nombreHechizo)) {
				
				hechizos.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	

}
