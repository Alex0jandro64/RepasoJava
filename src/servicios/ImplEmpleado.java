package servicios;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Empleado;
import util.Utilidades;

public class ImplEmpleado implements InterfazEmpleado {

	public void registrarEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);

		// Creo el objeto Empleado
		Empleado empl1 = new Empleado();

		// Pido los datos del Empleado
		empl1.setNombre(Utilidades.pideNombre());
		empl1.setApellidos(Utilidades.pideApellidos());
		empl1.setDni(Utilidades.pideDni());
		empl1.setFechaNacimiento(Utilidades.pideFecha());
		empl1.setTitulacion(Utilidades.pideTitulo());
		empl1.setNumSeguridadSocial(Utilidades.pideNumSeguridadSocial());
		empl1.setNumCuenta(Utilidades.pideNumCuenta());

		empl1.setNumEmpleado(listaEmpleadosAntigua.size() + 1);

		listaEmpleadosAntigua.add(empl1);

	}

	public void modificarEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);

		// Metodo que imprime y captura un Empleado
		int numEmpleado = Utilidades.opcionEmpleado(listaEmpleadosAntigua);

		// Si pulsa 0 significa que el usuario quiere salir y no modificar
		boolean salir = false;
		if (numEmpleado == 0) {
			salir = true;
		}
		if (!salir) {
			numEmpleado--;

			// Pregunto que campo quiere modificar y llamo a su correspondiente metodo
			int numCampo = Utilidades.campoAModificar();

			switch (numCampo) {
			case 1:
				listaEmpleadosAntigua.get(numEmpleado).setNombre(Utilidades.pideNombre());
				break;
			case 2:
				listaEmpleadosAntigua.get(numEmpleado).setApellidos(Utilidades.pideApellidos());
				break;
			case 3:
				listaEmpleadosAntigua.get(numEmpleado).setDni(Utilidades.pideDni());
				break;
			case 4:
				listaEmpleadosAntigua.get(numEmpleado).setFechaNacimiento(Utilidades.pideFecha());
				break;
			case 5:
				listaEmpleadosAntigua.get(numEmpleado).setTitulacion(Utilidades.pideTitulo());
				break;
			case 6:
				listaEmpleadosAntigua.get(numEmpleado).setNumSeguridadSocial(Utilidades.pideNumSeguridadSocial());
				break;
			case 7:
				listaEmpleadosAntigua.get(numEmpleado).setNumCuenta(Utilidades.pideNumCuenta());
				break;

			}
		}

	}

	public void exportarFicher(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);
		int opcion;
		int numEmpleado;
		// Pregunto y capturo si quiere exportar a todos o solo a uno
		do {
			System.out.println("Quiere exportar todos los Empleados (1) o solo a uno (2): ");
			opcion = Utilidades.capturarNumero();
		} while (opcion < 1 || opcion > 2);

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("./Empleados.txt");
			pw = new PrintWriter(fichero);
			pw.println("Numero de Empleado;Nombre;Apellidos;Dni;Fecha de Nacimiento;Titulacion");
			if (opcion == 1) {
				for (Empleado empleado : listaEmpleadosAntigua) {
					pw.println(empleado.getNumEmpleado() + ";" + empleado.getNombre() + ";" + empleado.getApellidos()
							+ ";" + empleado.getDni() + ";" + empleado.getFechaNacimiento() + ";"
							+ empleado.getTitulacion());
				}
			} else {
				numEmpleado = Utilidades.opcionEmpleado(listaEmpleadosAntigua);

				// si pulsa 0 sale del programa
				boolean salir = false;
				if (numEmpleado == 0)
					salir = true;

				if (!salir) {
					numEmpleado--;
					pw.println(listaEmpleadosAntigua.get(numEmpleado).getNumEmpleado() + ";"
							+ listaEmpleadosAntigua.get(numEmpleado).getNombre() + ";"
							+ listaEmpleadosAntigua.get(numEmpleado).getApellidos() + ";"
							+ listaEmpleadosAntigua.get(numEmpleado).getDni() + ";"
							+ listaEmpleadosAntigua.get(numEmpleado).getFechaNacimiento() + ";"
							+ listaEmpleadosAntigua.get(numEmpleado).getTitulacion());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
}
