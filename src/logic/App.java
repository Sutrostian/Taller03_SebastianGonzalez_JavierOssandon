//Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
//Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package logic;
import java.util.Scanner;
import domain.*;
import java.io.File;

public class App {

	private static Scanner s = new Scanner(System.in);
	private static ISistema sistema = new SistemaI();
	
	public static void main(String[] args) {
		
		
		leerHechizos();
		leerMagos();
		sistema.mostrarHechizos();
	    System.out.println();
	    sistema.mostrarMagos();
		s.close();
	}
	
	private static void leerMagos() {
		File arch = new File("Magos.txt");
		try {
			Scanner lector = new Scanner(arch);
			while(lector.hasNextLine()) {
				String [] partes = lector.nextLine().split(";");
				String nombreMago = partes[0];
				String[] hechizos = partes[1].split("\\|");
				sistema.crearMago(nombreMago, null);
				
				Mago m = sistema.buscarMago(nombreMago); //creamos un mago sin hechizos
				
				for(String nombreHechizo : hechizos) { // recorremos String[] hechizos

	                Hechizo h = sistema.buscarHechizo(nombreHechizo);

	                if(h != null) { // si el hechizo existe entre todos los hechizos del sistema, lo agragamos.
	                    m.agregarHechizo(h);
	                }
	            }
			}
			lector.close();
		}catch (Exception e) {
			e.printStackTrace();	
		}
	}

	private static void leerHechizos() {
		File arch = new File("Hechizos.txt");
		try {
			Scanner lector = new Scanner(arch);
			while(lector.hasNextLine()) {
				String [] partes = lector.nextLine().split(";");
				String nombreHechizo = partes[0];
				String tipo = partes[1];
				int dano = Integer.parseInt(partes[2]);
				int atributo1 = 0;
	            int atributo2 = 0;
	            
	            if(tipo.equalsIgnoreCase("Agua") || tipo.equalsIgnoreCase("Planta")) { // si estamos en Agua o Planta

	            String[] atributos = partes[3].split(","); // porque ya no va separado por ; ahora es por (,) entonces me guarda (atr1,atr2)

	            atributo1 = Integer.parseInt(atributos[0]);
	            atributo2 = Integer.parseInt(atributos[1]);
	            
	            }else { //si estamos en Fuego o Tierra

	            atributo1 = Integer.parseInt(partes[3]);
	            }
				sistema.crearHechizo(nombreHechizo, tipo, dano, atributo1, atributo2);
			}
			lector.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void panelAdministrador() {
		String opcion;
				
				do {
					
					System.out.println("===== PANEL ADMINISTRADOR =====");
					System.out.println("1. Agregar Mago.");
					System.out.println("2. Modificar Mago.");
					System.out.println("3. Eliminar Mago.");
					System.out.println("4. Agregar Hechizo.");
					System.out.println("5. Modificar Hechizo.");
					System.out.println("6. Eliminar Hechizo.");
					System.out.println("0. Volver.");
					System.out.print("Seleccione una opcion >");
					
					opcion = s.nextLine();
					
					switch(opcion) {
					
					case"1":
						
						break;
						
					case"2":
										
						break;
						
					case"3":
										
						break;
						
					case"4":
					
						
						break;
						
					case"5":
						
						break;
						
					case"6":
						break;
						
					case "0":
						System.out.println("");
						break;
						
					default:
						System.out.println("Ingrese una opcion valida");
						break;
					}
					
				}while(!opcion.equals("0")); //Mientras sea distinto de 0
				
			}
	
	private static void panelAnalista() {
		String opcion;
				
				do {
					
					System.out.println("===== PANEL ANALISTA =====");
					System.out.println("1. Top 10 Mejores Hechizos.");
					System.out.println("2. Top 3 Mejores Magos.");
					System.out.println("3. Mostrar todos los Hechizos.");
					System.out.println("4. Mostrar todos los magos.");
					System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion.");
					System.out.println("6. Mostrar todos los magos junto a su puntuacion.");
					System.out.println("0. Volver.");
					System.out.print("Seleccione una opcion >");
					
					opcion = s.nextLine();
					
					switch(opcion) {
					
					case"1":
						
						break;
						
					case"2":
										
						break;
						
					case"3":
										
						break;
						
					case"4":
					
						
						break;
						
					case"5":
						
						break;
						
					case"6":
						break;
						
					case "0":
						System.out.println("");
						break;
						
					default:
						System.out.println("Ingrese una opcion valida");
						break;
					}
					
				}while(!opcion.equals("0")); //Mientras sea distinto de 0
				
			}
}
