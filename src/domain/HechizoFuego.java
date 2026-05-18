package domain;

public class HechizoFuego extends Hechizo {
	
	private int duracionQuemadura;
	
	public HechizoFuego(String nombreHechizo, String tipo, int dano, int duracionQuemadura) {
		super(nombreHechizo, tipo, dano);
		this.duracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " HechizoFuego [duracionQuemadura=" + duracionQuemadura + "]";
	}

	
	
	

}
