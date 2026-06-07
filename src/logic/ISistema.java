package logic;
import java.util.ArrayList;

import domain.*;

public interface ISistema {
	
	public void crearHechizo(String nombreHechizo, String tipo, int dano, int atributo1, int atributo2);

	public void crearMago(String nombreMago, Hechizo hechizo);
	
	public Hechizo buscarHechizo(String nombreHechizo);
	
	public Mago buscarMago(String nombreMago);

	public void mostrarHechizos();

	public void mostrarMagos();
	
	public void LeerHechizos();
	
	public void LeerMagos();
	
	public void guardarMagos();
	
	public boolean eliminarMago(String nombreMago);
	
	public boolean modificarNombreMago(String nombreActual, String nuevoNombre);

	public boolean agregarHechizoAMago(String nombreMago, String nombreHechizo);

	public boolean quitarHechizoDeMago(String nombreMago, String nombreHechizo);
	
	public void guardarHechizos();
	
	public boolean eliminarHechizo(String nombreHechizo);
	
	public boolean modificarHechizo(String nombreHechizo, int dano, int atributo1, int atributo2);
	
	public ArrayList<Hechizo> getHechizos();
	
	public ArrayList<Mago> getMagos();
	
	public double calcularPuntajeMago(Mago mago);
	
	
}
