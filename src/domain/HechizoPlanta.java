package domain;

public class HechizoPlanta extends Hechizo implements ICalcularP{
	
	private int duracionStun;
	private int cantPlantas;
	
	public HechizoPlanta(String nombreHechizo, String tipo, int dano, int duracionStun, int cantPlantas) {
		super(nombreHechizo, tipo, dano);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuracionStun() {
		return duracionStun;
	}

	public void setDuracionStun(int duracionStun) {
		this.duracionStun = duracionStun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}

	@Override
	public String toString() {
	    return super.toString() + " HechizoPlanta [duracionStun=" + duracionStun + ", cantPlantas=" + cantPlantas + "]";
	}

	@Override
	public double calcularPuntaje() {
		
		return dano + (duracionStun * cantPlantas);
	}
	
	

}
