package domain;

public class HechizoAgua extends Hechizo implements ICalcularP {

	private int cantidadHeal;
	private int presionAgua;

	public HechizoAgua(String nombreHechizo, String tipo, int dano, int cantidadHeal, int presionAgua) {
		super(nombreHechizo, tipo, dano);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public void setCantidadHeal(int cantidadHeal) {
		this.cantidadHeal = cantidadHeal;
	}

	public int getPresionAgua() {
		return presionAgua;
	}

	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}

	@Override
	public String toString() {
		return super.toString() + " HechizoAgua [cantidadHeal=" + cantidadHeal + ", presionAgua=" + presionAgua + "]";
	}

	@Override
	public double calcularPuntaje() {

		return (dano + cantidadHeal + presionAgua) * 2.0;
	}

}
