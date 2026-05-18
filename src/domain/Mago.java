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
		return "Mago [nombreMago=" + nombreMago + ", hechizos=" + hechizos + "]";
	}
	
	
	

}
