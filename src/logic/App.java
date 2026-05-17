//Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
//Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package logic;
import java.util.Scanner;

public class App {

	private static Scanner s = new Scanner(System.in);
	private static ISistema sistema = new SistemaI();
	
	public static void main(String[] args) {
		mostrarMenu();

	}
	
	private static void mostrarMenu() {
		String opcion;
				
				do {
					
					System.out.println("===== MENU =====");
					System.out.println("1. Enviar un mensaje, desde un número de teléfono.");
					System.out.println("2. Enviar un sticker, desde un número de telefono.");
					System.out.println("3. Ver todos los usuarios que no pueden enviar mensajes.");
					System.out.println("4. Ver todos los stickers que si están disponibles.");
					System.out.println("5. Darle excepción a un alumno (Solo pueden hacerlo los administradores).");
					System.out.println("6. Ver historial de mensajes enviados.");
					System.out.println("7. Salir.");
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
						
					case "7":
						System.out.println("Has Salido Exitosamente");
						break;
						
					default:
						System.out.println("Ingrese una opcion valida");
						break;
					}
					
				}while(!opcion.equals("7")); //Mientras sea distinto de 7
				
			}

}
