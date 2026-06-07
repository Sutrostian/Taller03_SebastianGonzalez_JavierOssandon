package domain;

public abstract class Hechizo implements ICalcularP{
	
	protected String nombreHechizo;
	protected String tipo;
	protected int dano;
	
	public Hechizo(String nombreHechizo, String tipo, int dano) {
		super();
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.dano = dano;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public abstract double calcularPuntaje();

	@Override
	public String toString() {
	    return nombreHechizo + " [" + tipo + "] - Daño: " + dano;
	}
	
	
	
	

}
