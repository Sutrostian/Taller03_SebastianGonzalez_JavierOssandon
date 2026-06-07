package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

import domain.*;

public class SistemaI implements ISistema {

	private ArrayList<Mago> magos = new ArrayList<Mago>();
	private ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();

	@Override
	public void crearHechizo(String nombreHechizo, String tipo, int dano, int atributo1, int atributo2) {

		Hechizo nuevoHechizo = null;

		if (tipo.equalsIgnoreCase("Fuego")) {
			nuevoHechizo = new HechizoFuego(nombreHechizo, tipo, dano, atributo1);
		}

		if (tipo.equalsIgnoreCase("Tierra")) {
			nuevoHechizo = new HechizoTierra(nombreHechizo, tipo, dano, atributo1);
		}

		if (tipo.equalsIgnoreCase("Planta")) {
			nuevoHechizo = new HechizoPlanta(nombreHechizo, tipo, dano, atributo1, atributo2);
		}

		if (tipo.equalsIgnoreCase("Agua")) {
			nuevoHechizo = new HechizoAgua(nombreHechizo, tipo, dano, atributo1, atributo2);
		}

		hechizos.add(nuevoHechizo);

	}

	@Override
	public void crearMago(String nombreMago, Hechizo hechizo) {

		Mago m = new Mago(nombreMago, new ArrayList<Hechizo>());

		if (hechizo != null) {

			m.agregarHechizo(hechizo);
		}

		magos.add(m);

	}

	@Override
	public Hechizo buscarHechizo(String nombreHechizo) {

		for (Hechizo h : hechizos) {

			if (h.getNombreHechizo().equalsIgnoreCase(nombreHechizo)) {
				return h;
			}
		}
		return null;
	}

	@Override
	public Mago buscarMago(String nombreMago) {

		for (Mago m : magos) {

			if (m.getNombreMago().equalsIgnoreCase(nombreMago)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public void mostrarHechizos() {

		System.out.println("===== HECHIZOS =====");

		for (Hechizo h : hechizos) {
			System.out.println(h);
		}

	}

	@Override
	public void mostrarMagos() {

		System.out.println("===== MAGOS =====");

		for (Mago m : magos) {
			System.out.println(m);
		}

	}

	@Override
	public void LeerHechizos() {
		File arch = new File("Hechizos.txt");
		try {
			Scanner lector = new Scanner(arch);
			while (lector.hasNextLine()) {
				String[] partes = lector.nextLine().split(";");
				String nombreHechizo = partes[0];
				String tipo = partes[1];
				int dano = Integer.parseInt(partes[2]);
				int atributo1 = 0;
				int atributo2 = 0;

				if (tipo.equalsIgnoreCase("Agua") || tipo.equalsIgnoreCase("Planta")) {

					String[] atributos = partes[3].split(",");

					atributo1 = Integer.parseInt(atributos[0]);
					atributo2 = Integer.parseInt(atributos[1]);

				} else {

					atributo1 = Integer.parseInt(partes[3]);
				}
				crearHechizo(nombreHechizo, tipo, dano, atributo1, atributo2);
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void LeerMagos() {
		File arch = new File("Magos.txt");
		try {
			Scanner lector = new Scanner(arch);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine().trim();
				if (linea.isEmpty())
					continue;

				String[] partes = linea.split(";");
				String nombreMago = partes[0];

				crearMago(nombreMago, null);
				Mago m = buscarMago(nombreMago);

				// si es que hay algo después del ";"
				if (partes.length > 1 && !partes[1].trim().isEmpty()) { // el .trim es para elimina espacios en blanco
																		// de un string
					String[] hechizosNombres = partes[1].split("\\|");
					for (String nombreHechizo : hechizosNombres) {
						Hechizo h = buscarHechizo(nombreHechizo.trim());
						if (h != null) {
							m.agregarHechizo(h);
						}
					}
				}
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void guardarMagos() {
		File arch = new File("Magos.txt");

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(arch));

			for (Mago m : magos) {

				bw.write(m.getNombreMago() + ";");

				for (int i = 0; i < m.getHechizos().size(); i++) {

					bw.write(m.getHechizos().get(i).getNombreHechizo());

					if (i < m.getHechizos().size() - 1) {
						bw.write("|");
					}
				}

				bw.newLine();
			}

			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean eliminarMago(String nombreMago) {

		for (int i = 0; i < magos.size(); i++) {

			if (magos.get(i).getNombreMago().equalsIgnoreCase(nombreMago)) {

				magos.remove(i);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean modificarNombreMago(String nombreActual, String nuevoNombre) {

		Mago m = buscarMago(nombreActual);

		if (m == null) {
			return false;
		}

		m.setNombreMago(nuevoNombre);

		return true;
	}

	@Override
	public boolean agregarHechizoAMago(String nombreMago, String nombreHechizo) {

		Mago m = buscarMago(nombreMago);
		Hechizo h = buscarHechizo(nombreHechizo);

		if (m == null || h == null) {
			return false;
		}

		for (Hechizo hechizo : m.getHechizos()) {

			if (hechizo.getNombreHechizo().equalsIgnoreCase(nombreHechizo)) {
				return false;
			}
		}

		m.agregarHechizo(h);

		return true;
	}

	@Override
	public boolean quitarHechizoDeMago(String nombreMago, String nombreHechizo) {

		Mago m = buscarMago(nombreMago);

		if (m == null) {
			return false;
		}

		return m.eliminarHechizo(nombreHechizo);
	}

	@Override
	public void guardarHechizos() {

		File arch = new File("Hechizos.txt");

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(arch));

			for (Hechizo h : hechizos) {

				if (h instanceof HechizoFuego) {

					HechizoFuego hf = (HechizoFuego) h;

					bw.write(hf.getNombreHechizo() + ";" + hf.getTipo() + ";" + hf.getDano() + ";"
							+ hf.getDuracionQuemadura());
				}

				if (h instanceof HechizoTierra) {

					HechizoTierra ht = (HechizoTierra) h;

					bw.write(ht.getNombreHechizo() + ";" + ht.getTipo() + ";" + ht.getDano() + ";"
							+ ht.getMejoraDefensa());
				}

				if (h instanceof HechizoPlanta) {

					HechizoPlanta hp = (HechizoPlanta) h;

					bw.write(hp.getNombreHechizo() + ";" + hp.getTipo() + ";" + hp.getDano() + ";"
							+ hp.getDuracionStun() + "," + hp.getCantPlantas());
				}

				if (h instanceof HechizoAgua) {

					HechizoAgua ha = (HechizoAgua) h;

					bw.write(ha.getNombreHechizo() + ";" + ha.getTipo() + ";" + ha.getDano() + ";"
							+ ha.getCantidadHeal() + "," + ha.getPresionAgua());
				}

				bw.newLine();
			}

			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean eliminarHechizo(String nombreHechizo) {
		for (int i = 0; i < hechizos.size(); i++) {
			if (hechizos.get(i).getNombreHechizo().equalsIgnoreCase(nombreHechizo)) {
				// Como hay que eliminarlo de todos los magos, hacemos esto
				for (Mago m : magos) {
					m.eliminarHechizo(nombreHechizo);
				}
				hechizos.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificarHechizo(String nombreHechizo, int dano, int atributo1, int atributo2) {

		Hechizo h = buscarHechizo(nombreHechizo); // buscamos el echizo

		if (h == null)
			return false; // si no existe no hay nada que modificar

		h.setDano(dano);

		// hacemos casting a h para poder usar los metodos que le corresponda segun su
		// tipo

		if (h instanceof HechizoFuego) { // si h es de fuego
			((HechizoFuego) h).setDuracionQuemadura(atributo1);
		} else if (h instanceof HechizoTierra) { // si h es de tierra
			((HechizoTierra) h).setMejoraDefensa(atributo1);
		} else if (h instanceof HechizoPlanta) { // si h es de planta
			((HechizoPlanta) h).setDuracionStun(atributo1);
			((HechizoPlanta) h).setCantPlantas(atributo2);
		} else if (h instanceof HechizoAgua) { // si h es de agua
			((HechizoAgua) h).setCantidadHeal(atributo1);
			((HechizoAgua) h).setPresionAgua(atributo2);
		}

		return true;
	}

	@Override
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	@Override
	public ArrayList<Mago> getMagos() {
		return magos;
	}

	@Override
	public double calcularPuntajeMago(Mago mago) {
		double total = 0;
		for (Hechizo h : mago.getHechizos()) {
			total += h.calcularPuntaje();
		}
		return total;
	}

}
