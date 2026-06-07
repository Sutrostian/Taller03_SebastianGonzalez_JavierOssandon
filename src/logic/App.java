//Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
//Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand/itsvoiiid
package logic;

import java.util.ArrayList;
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

			switch (opcion) {

			case "1": {

				System.out.print("Ingrese nombre del mago: ");
				String nombreMago = s.nextLine();

				if (nombreMago.trim().isEmpty()) {

					System.out.println("Debe ingresar un nombre.");

				} else if (sistema.buscarMago(nombreMago) != null) {

					System.out.println("El mago ya existe.");

				} else {

					sistema.crearMago(nombreMago, null);
					sistema.guardarMagos();

					System.out.println("Mago agregado correctamente.");
				}
				break;
			}

			case "2": {

				System.out.print("Ingrese nombre del mago: ");
				String nombreMagoModificar = s.nextLine();

				if (sistema.buscarMago(nombreMagoModificar) == null) {

					System.out.println("El mago no existe.");
					break;
				}

				System.out.println("1. Cambiar nombre.");
				System.out.println("2. Agregar hechizo.");
				System.out.println("3. Quitar hechizo.");
				System.out.print("Seleccione una opcion > ");

				String opcionModificar = s.nextLine();

				switch (opcionModificar) {

				case "1":

					System.out.print("Ingrese nuevo nombre: ");
					String nuevoNombre = s.nextLine();

					if (sistema.modificarNombreMago(nombreMagoModificar, nuevoNombre)) {

						sistema.guardarMagos();
						System.out.println("Nombre modificado correctamente.");
					}

					break;

				case "2":

					System.out.print("Ingrese nombre del hechizo: ");
					String nombreHechizoAgregar = s.nextLine();

					if (sistema.agregarHechizoAMago(nombreMagoModificar, nombreHechizoAgregar)) {

						sistema.guardarMagos();
						System.out.println("Hechizo agregado correctamente.");
					} else {

						System.out.println("No se pudo agregar el hechizo.");
					}

					break;

				case "3":

					System.out.print("Ingrese nombre del hechizo: ");
					String nombreHechizoEliminar = s.nextLine();

					if (sistema.quitarHechizoDeMago(nombreMagoModificar, nombreHechizoEliminar)) {

						sistema.guardarMagos();
						System.out.println("Hechizo eliminado correctamente.");
					} else {

						System.out.println("El hechizo no pertenece al mago.");
					}

					break;

				default:
					System.out.println("Opcion invalida.");
					break;
				}

				break;

				// AQUI TERMINA EL SUBMENU PARA NO CONFUNDIR
			}
			case "3": {

				System.out.print("Ingrese nombre del mago a eliminar: ");
				String nombreMagoEliminar = s.nextLine();

				if (sistema.eliminarMago(nombreMagoEliminar)) {

					sistema.guardarMagos();

					System.out.println("Mago eliminado correctamente.");

				} else {

					System.out.println("El mago no existe.");
				}

				break;

			}
			case "4": {

				System.out.print("Ingrese nombre del hechizo: ");
				String nombreHechizo = s.nextLine();

				if (nombreHechizo.trim().isEmpty()) {

					System.out.println("Debe ingresar un nombre.");
					break;
				}

				if (sistema.buscarHechizo(nombreHechizo) != null) {

					System.out.println("El hechizo ya existe.");
					break;
				}

				System.out.print("Ingrese tipo (Fuego/Tierra/Planta/Agua): ");
				String tipo = s.nextLine();

				System.out.print("Ingrese daño: ");
				int dano = leerEntero(s.nextLine());

				int atributo1 = 0;
				int atributo2 = 0;

				if (tipo.equalsIgnoreCase("Fuego")) {

					System.out.print("Ingrese duración quemadura: ");
					atributo1 = leerEntero(s.nextLine());
				}

				else if (tipo.equalsIgnoreCase("Tierra")) {

					System.out.print("Ingrese mejora defensa: ");
					atributo1 = leerEntero(s.nextLine());
				}

				else if (tipo.equalsIgnoreCase("Planta")) {

					System.out.print("Ingrese duración stun: ");
					atributo1 = leerEntero(s.nextLine());

					System.out.print("Ingrese cantidad plantas: ");
					atributo2 = leerEntero(s.nextLine());
				}

				else if (tipo.equalsIgnoreCase("Agua")) {

					System.out.print("Ingrese cantidad heal: ");
					atributo1 = leerEntero(s.nextLine());

					System.out.print("Ingrese presión agua: ");
					atributo2 = leerEntero(s.nextLine());
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

				if (h == null) {
					System.out.println("El hechizo no existe.");
					break;
				}

				System.out.println("Tipo: " + h.getTipo());
				System.out.print("Ingrese nuevo daño: ");
				int nuevoDano = leerEntero(s.nextLine());

				int nuevoAtributo1 = 0;
				int nuevoAtributo2 = 0;

				if (h instanceof HechizoFuego) {
					System.out.print("Ingrese nueva duración quemadura: ");
					nuevoAtributo1 = leerEntero(s.nextLine());
				} else if (h instanceof HechizoTierra) {
					System.out.print("Ingrese nueva mejora defensa: ");
					nuevoAtributo1 = leerEntero(s.nextLine());
				} else if (h instanceof HechizoPlanta) {
					System.out.print("Ingrese nueva duración stun: ");
					nuevoAtributo1 = leerEntero(s.nextLine());
					System.out.print("Ingrese nueva cantidad plantas: ");
					nuevoAtributo2 = leerEntero(s.nextLine());
				} else if (h instanceof HechizoAgua) {
					System.out.print("Ingrese nueva cantidad heal: ");
					nuevoAtributo1 = leerEntero(s.nextLine());
					System.out.print("Ingrese nueva presión agua: ");
					nuevoAtributo2 = leerEntero(s.nextLine());
				}

				sistema.modificarHechizo(nombreHechizoMod, nuevoDano, nuevoAtributo1, nuevoAtributo2);
				sistema.guardarHechizos();
				System.out.println("Hechizo modificado correctamente.");
				break;

			case "6":
				System.out.print("Ingrese nombre del hechizo a eliminar: ");
				String hechizoAEliminar = s.nextLine();

				if (sistema.eliminarHechizo(hechizoAEliminar)) {
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

		} while (!opcion.equals("0")); // Mientras sea distinto de 0

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

			switch (opcion) {

			case "1":
				ArrayList<Hechizo> ranking = new ArrayList<>(sistema.getHechizos());

				// Ordenamos de mayor a menor puntaje
				for (int i = 0; i < ranking.size() - 1; i++) { // recorremos ranking desde 0 hasta el ultimo
					for (int j = 0; j < ranking.size() - 1 - i; j++) { // recorremos ranking desde 0 hasta el uultimo
						if (ranking.get(j).calcularPuntaje() < ranking.get(j + 1).calcularPuntaje()) { // si el anterior
																										// es menor al
																										// siguiente
							Hechizo temp = ranking.get(j); // guardamos el anterior
							ranking.set(j, ranking.get(j + 1)); // donde estaba el anterior metemos el siguiente
							ranking.set(j + 1, temp); // donde estaba el siguiente metemos el anterior
						}
					}
				}

				System.out.println("===== TOP 10 MEJORES HECHIZOS =====");

				int limite;
				if (ranking.size() < 10) { // si hay menos de 10 en el ranking
					limite = ranking.size(); // el limite sera el size
				} else {
					limite = 10; // si no seran los top 10
				}

				for (int i = 0; i < limite; i++) {
					System.out.println((i + 1) + ". " + ranking.get(i).getNombreHechizo() + " - Puntaje: "
							+ ranking.get(i).calcularPuntaje());
				}
				break;

			case "2": {
				ArrayList<Mago> rankingMagos = new ArrayList<>(sistema.getMagos());

				// ordenaremos con la misma logica del case 1 de mayor a menor
				for (int i = 0; i < rankingMagos.size() - 1; i++) {
					for (int j = 0; j < rankingMagos.size() - 1 - i; j++) {
						if (sistema.calcularPuntajeMago(rankingMagos.get(j)) < sistema
								.calcularPuntajeMago(rankingMagos.get(j + 1))) {
							Mago temp = rankingMagos.get(j);
							rankingMagos.set(j, rankingMagos.get(j + 1));
							rankingMagos.set(j + 1, temp);
						}
					}
				}

				System.out.println("===== TOP 3 MEJORES MAGOS =====");

				int limiteMagos;
				if (rankingMagos.size() < 3) { // si hay menos de 3 magos, l limite es el size
					limiteMagos = rankingMagos.size();
				} else {
					limiteMagos = 3; // si no hacemos el top 3 normal
				}

				for (int i = 0; i < limiteMagos; i++) { // printeamos
					System.out.println((i + 1) + ". " + rankingMagos.get(i).getNombreMago() + " - Puntaje: "
							+ sistema.calcularPuntajeMago(rankingMagos.get(i)));
				}
				break;
			}

			case "3":
				System.out.println("===== TODOS LOS HECHIZOS =====");
				for (Hechizo h : sistema.getHechizos()) {
					System.out.println(h);
				}
				break;

			case "4":
				System.out.println("===== TODOS LOS MAGOS =====");
				for (Mago m : sistema.getMagos()) {
					System.out.println(m);
				}
				break;

			case "5": {
				System.out.println("===== HECHIZOS CON PUNTUACION =====");
				for (Hechizo h : sistema.getHechizos()) {
					System.out.println(h.getNombreHechizo() + " [" + h.getTipo() + "] - Puntaje: " + h.calcularPuntaje());
				}
				break;
			}

			case "6": {
				System.out.println("===== MAGOS CON PUNTUACION =====");
				for (Mago m : sistema.getMagos()) {
					System.out.println(m.getNombreMago() + " - Puntaje: " + sistema.calcularPuntajeMago(m));
				}
				break;
			}

			case "0":
				System.out.println("");
				break;

			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}

		} while (!opcion.equals("0")); // Mientras sea distinto de 0

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

			switch (opcion) {
			case "1":
				panelAdministrador();
				break;
			case "2":
				panelAnalista();
				break;
			case "0":
				System.out.println("Adios :3");
				break;
			default:
				System.out.println("Opcion invalida.");
				break;
			}
		} while (!opcion.equals("0"));
	}

	private static int leerEntero(String valor) { // eric ross leia con metodos, asi ahorramos codigo y controlamos errores altiro
	    while (true) {
	        try {
	            return Integer.parseInt(valor);
	        } catch (NumberFormatException e) {
	            System.out.println("Ingrese un numero valido.");
	            System.out.print("> ");
	            valor = s.nextLine();
	        }
	    }
	}
}
