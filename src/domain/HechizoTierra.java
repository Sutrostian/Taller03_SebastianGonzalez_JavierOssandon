package domain;

public class HechizoTierra extends Hechizo implements ICalcularP {

	private int mejoraDefensa;

	public HechizoTierra(String nombreHechizo, String tipo, int dano, int mejoraDefensa) {
		super(nombreHechizo, tipo, dano);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}

	@Override
	public String toString() {
		return super.toString() + " HechizoTierra [mejoraDefensa=" + mejoraDefensa + "]";
	}

	@Override
	public double calcularPuntaje() {

		return (dano * mejoraDefensa) / 2.0;

	}

}
