//Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
//Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package logic;
import java.util.Scanner;

import domain.*;

public class App {

	private static Scanner s = new Scanner(System.in);
	private static ISistema sistema = new SistemaI();
	
	public static void main(String[] args) {
				
		sistema.LeerHechizos();
		sistema.LeerMagos();
	    menuPrincipal();
    
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
					System.out.println("0. Volver.");
					System.out.print("Seleccione una opcion >");
					
					opcion = s.nextLine();
					
					switch(opcion) {
					
					case"1":{

						System.out.print("Ingrese nombre del mago: ");
						String nombreMago = s.nextLine();

						if(nombreMago.trim().isEmpty()) {

							System.out.println("Debe ingresar un nombre.");

						}
						else if(sistema.buscarMago(nombreMago) != null) {

							System.out.println("El mago ya existe.");

						}
						else {

							sistema.crearMago(nombreMago, null);
							sistema.guardarMagos();

							System.out.println("Mago agregado correctamente.");
						}
						break;
					}
						
						
					case"2":{

						System.out.print("Ingrese nombre del mago: ");
						String nombreMagoModificar = s.nextLine();
						
						if(sistema.buscarMago(nombreMagoModificar) == null) {
							
							System.out.println("El mago no existe.");
							break;
						}
						
						System.out.println("1. Cambiar nombre.");
						System.out.println("2. Agregar hechizo.");
						System.out.println("3. Quitar hechizo.");
						System.out.print("Seleccione una opcion > ");
						
						String opcionModificar = s.nextLine();
						
						switch(opcionModificar) {
						
						case "1":
							
							System.out.print("Ingrese nuevo nombre: ");
							String nuevoNombre = s.nextLine();
							
							if(sistema.modificarNombreMago(nombreMagoModificar, nuevoNombre)) {
								
								sistema.guardarMagos();
								System.out.println("Nombre modificado correctamente.");
							}
							
							break;
							
						case "2":
							
							System.out.print("Ingrese nombre del hechizo: ");
							String nombreHechizoAgregar = s.nextLine();
							
							if(sistema.agregarHechizoAMago(nombreMagoModificar, nombreHechizoAgregar)) {
								
								sistema.guardarMagos();
								System.out.println("Hechizo agregado correctamente.");
							}
							else {
								
								System.out.println("No se pudo agregar el hechizo.");
							}
							
							break;
							
						case "3":
							
							System.out.print("Ingrese nombre del hechizo: ");
							String nombreHechizoEliminar = s.nextLine();
							
							if(sistema.quitarHechizoDeMago(nombreMagoModificar, nombreHechizoEliminar)) {
								
								sistema.guardarMagos();
								System.out.println("Hechizo eliminado correctamente.");
							}
							else {
								
								System.out.println("El hechizo no pertenece al mago.");
							}
							
							break;
							
						default:
							System.out.println("Opcion invalida.");
							break;
						}
						
						
						
						
						
						
						
						
						
						
						break;
					}
					case"3":{

						System.out.print("Ingrese nombre del mago a eliminar: ");
						String nombreMagoEliminar = s.nextLine();

						if(sistema.eliminarMago(nombreMagoEliminar)) {

							sistema.guardarMagos();

							System.out.println("Mago eliminado correctamente.");

						}else {

							System.out.println("El mago no existe.");
						}

						break;
										
					
					}
					case"4":{

						System.out.print("Ingrese nombre del hechizo: ");
						String nombreHechizo = s.nextLine();

						if(nombreHechizo.trim().isEmpty()) {

							System.out.println("Debe ingresar un nombre.");
							break;
						}

						if(sistema.buscarHechizo(nombreHechizo) != null) {

							System.out.println("El hechizo ya existe.");
							break;
						}

						System.out.print("Ingrese tipo (Fuego/Tierra/Planta/Agua): ");
						String tipo = s.nextLine();

						System.out.print("Ingrese daño: ");
						int dano = Integer.parseInt(s.nextLine());

						int atributo1 = 0;
						int atributo2 = 0;

						if(tipo.equalsIgnoreCase("Fuego")) {

							System.out.print("Ingrese duración quemadura: ");
							atributo1 = Integer.parseInt(s.nextLine());
						}

						else if(tipo.equalsIgnoreCase("Tierra")) {

							System.out.print("Ingrese mejora defensa: ");
							atributo1 = Integer.parseInt(s.nextLine());
						}

						else if(tipo.equalsIgnoreCase("Planta")) {

							System.out.print("Ingrese duración stun: ");
							atributo1 = Integer.parseInt(s.nextLine());

							System.out.print("Ingrese cantidad plantas: ");
							atributo2 = Integer.parseInt(s.nextLine());
						}

						else if(tipo.equalsIgnoreCase("Agua")) {

							System.out.print("Ingrese cantidad heal: ");
							atributo1 = Integer.parseInt(s.nextLine());

							System.out.print("Ingrese presión agua: ");
							atributo2 = Integer.parseInt(s.nextLine());
						}

						else {

							System.out.println("Tipo inválido.");
							break;
						}

						sistema.crearHechizo(nombreHechizo, tipo, dano, atributo1, atributo2);
						sistema.guardarHechizos();

						System.out.println("Hechizo agregado correctamente.");

						break;
					}
						
					
					
						
						
						
					case "5": 
					    System.out.print("Ingrese nombre del hechizo a modificar: ");
					    String nombreHechizoMod = s.nextLine();
					    
					    Hechizo h = sistema.buscarHechizo(nombreHechizoMod);
					    
					    if(h == null) {
					        System.out.println("El hechizo no existe.");
					        break;
					    }
					    
					    System.out.println("Tipo: " + h.getTipo());
					    System.out.print("Ingrese nuevo daño: ");
					    int nuevoDano = Integer.parseInt(s.nextLine());
					    
					    int nuevoAtributo1 = 0;
					    int nuevoAtributo2 = 0;
					    
					    if(h instanceof HechizoFuego) {
					        System.out.print("Ingrese nueva duración quemadura: ");
					        nuevoAtributo1 = Integer.parseInt(s.nextLine());
					    }
					    else if(h instanceof HechizoTierra) {
					        System.out.print("Ingrese nueva mejora defensa: ");
					        nuevoAtributo1 = Integer.parseInt(s.nextLine());
					    }
					    else if(h instanceof HechizoPlanta) {
					        System.out.print("Ingrese nueva duración stun: ");
					        nuevoAtributo1 = Integer.parseInt(s.nextLine());
					        System.out.print("Ingrese nueva cantidad plantas: ");
					        nuevoAtributo2 = Integer.parseInt(s.nextLine());
					    }
					    else if(h instanceof HechizoAgua) {
					        System.out.print("Ingrese nueva cantidad heal: ");
					        nuevoAtributo1 = Integer.parseInt(s.nextLine());
					        System.out.print("Ingrese nueva presión agua: ");
					        nuevoAtributo2 = Integer.parseInt(s.nextLine());
					    }
					    
					    sistema.modificarHechizo(nombreHechizoMod, nuevoDano, nuevoAtributo1, nuevoAtributo2);
					    sistema.guardarHechizos();
					    System.out.println("Hechizo modificado correctamente.");
					    break;
					
						
					case "6": 
					    System.out.print("Ingrese nombre del hechizo a eliminar: ");
					    String nombreHechizoEliminar = s.nextLine();

					    if(sistema.eliminarHechizo(nombreHechizoEliminar)) {
					        sistema.guardarHechizos();
					        sistema.guardarMagos();
					        System.out.println("Hechizo eliminado correctamente.");
					    } else {
					        System.out.println("El hechizo no existe.");
					    }
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
	private static void menuPrincipal() {
	    String opcion;
	    do {
	        System.out.println("===== MENU PRINCIPAL =====");
	        System.out.println("1. Panel Administrador.");
	        System.out.println("2. Panel Analista.");
	        System.out.println("0. Salir.");
	        System.out.print("Seleccione una opcion > ");
	        opcion = s.nextLine();

	        switch(opcion) {
	            case "1": panelAdministrador(); break;
	            case "2": panelAnalista(); break;
	            case "0": System.out.println("Adios :3"); break;
	            default: System.out.println("Opcion invalida."); break;
	        }
	    } while(!opcion.equals("0"));
	}
}
