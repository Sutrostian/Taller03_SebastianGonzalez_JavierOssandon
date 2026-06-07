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
		
		
		sistema.LeerHechizos();
		sistema.LeerMagos();
		sistema.mostrarHechizos();
	    System.out.println();
	    sistema.mostrarMagos();
	    
	    panelAdministrador();
	    
	    
	    
	    
	    
		s.close();
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
					System.out.println("0. Salir.");
					System.out.print("Seleccione una opcion >");
					
					opcion = s.nextLine();
					
					switch(opcion) {
					
					case"1":
						System.out.println("Elegiste la opcion 1");
						sistema.crearMago("Prueba", null);
						sistema.guardarMagos();
						
			
						
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
						System.out.println("Seguro de salir?");
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
