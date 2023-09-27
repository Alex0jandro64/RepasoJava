package util;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Empleado;

public class Utilidades {

	
	
	public static int opcionEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);
		// Metodo que imprime y captura un numero de empleado
		int numEmpleado;

		// Imprimos todos los empleados actuales en la lista para facilitar los numeros
		// de empleados
		for (Empleado empleado : listaEmpleadosAntigua) {
			System.out.println("Nº Empleado:" + empleado.getNumEmpleado() + " " + empleado.getNombre() + " "
					+ empleado.getApellidos());
		}

		System.out.println("Que empleado quiere seleccionar (nº Empleado) (Pulse 0 para salir): ");

		// Capturo el numero de empleado
		do {
			numEmpleado = capturarNumero();
			if (numEmpleado < 0 || numEmpleado > listaEmpleadosAntigua.size()) {
				System.out.println("El valor introducido no es correcto");
			}
		} while (numEmpleado < 0 || numEmpleado > listaEmpleadosAntigua.size());

		return numEmpleado;
	}

	public static String pideNombre() {
		Scanner leer = new Scanner(System.in);
		String nombre;
		do {
			// Compruebo que los tipos de datos son los correctos
			System.out.print("\nNombre: ");
			nombre = leer.nextLine();
			if (estaVacio(nombre)) {
				System.out.println("El nombre no puede estar vacio");
			} else if (contieneNumeros(nombre)) {
				System.out.println("El nombre no puede contener numero");
			}

		} while (estaVacio(nombre) || contieneNumeros(nombre));

		// Si sale del bucle es que esta correcto entonces devuelvo el dato
		return nombre;
	}

	public static String pideApellidos() {

		Scanner leer = new Scanner(System.in);
		String apellidos;
		do {
			// Compruebo que los tipos de datos son los correctos
			System.out.print("\nApellidos: ");
			apellidos = leer.nextLine();
			if (estaVacio(apellidos)) {
				System.out.println("El apellido no puede estar vacio");
			} else if (contieneNumeros(apellidos)) {
				System.out.println("El apellido no puede contener numero");
			}

		} while (estaVacio(apellidos) || contieneNumeros(apellidos));

		// Si sale del bucle es que esta correcto entonces devuelvo el dato
		return apellidos;
	}

	public static String pideDni() {
		Scanner leer = new Scanner(System.in);
		String dni;

		do {
			// Compruebo que los tipos de datos son los correctos
			System.out.print("\nDni: ");
			dni = leer.nextLine();
			if (estaVacio(dni)) {
				System.out.println("El dni no puede estar vacio");
			} else if (formatoErroneoDni(dni)) {
				System.out.println("El dni tiene que tener 9 caracteres");
			}

		} while (estaVacio(dni) || formatoErroneoDni(dni));

		// Si sale del bucle es que esta correcto entonces devuelvo el dato
		return dni;
	}

	public static String pideFecha() {

		Scanner leer = new Scanner(System.in);
		String fechaNacimiento;

		do {
			// Compruebo que los tipos de datos son los correctos
			System.out.print("\nFecha de Nacimiento: ");
			fechaNacimiento = leer.nextLine();
			if (estaVacio(fechaNacimiento)) {
				System.out.println("La fecha de nacimiento no puede estar vacia");
			}
		} while (estaVacio(fechaNacimiento));

		// Si sale del bucle es que esta correcto entonces devuelvo el dato
		return fechaNacimiento;
	}

	public static String pideTitulo() {

		Scanner leer = new Scanner(System.in);
		String titulacion;

		do {
			// Compruebo que los tipos de datos son los correctos
			System.out.print("\nTitulacion: ");
			titulacion = leer.nextLine();
			if (estaVacio(titulacion)) {
				System.out.println("La titulacion no puede estar vacia");
			}
		} while (estaVacio(titulacion));

		// Si sale del bucle es que esta correcto entonces devuelvo el dato
		return titulacion;
	}

	public static int pideNumSeguridadSocial() {
		boolean ok;
		int numeroSeguridadSocial = 0;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("\nNumero de la Seguridad Social: ");
			String input = scanner.nextLine();

			try {
				numeroSeguridadSocial = Integer.parseInt(input);
				ok = true;
			} catch (NumberFormatException e) {
				ok = false;
				System.out.println("El Numero de la Seguridad Social no puede tener caracteres no numericos");
			}
		} while (!ok);

		return numeroSeguridadSocial;
	}

	public static int pideNumCuenta() {
		boolean ok;
		int numCuenta = 0;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("\nNumero de Cuenta: ");
			String input = scanner.nextLine();

			try {
				numCuenta = Integer.parseInt(input);
				ok = true;
			} catch (NumberFormatException e) {
				ok = false;
				System.out.println("El Numero de Cuenta no puede tener caracteres no numericos");
			}
		} while (!ok);

		return numCuenta;
	}

	public static boolean estaVacio(String txt) {
		return txt.isEmpty();
	}

	// Metodo de ChatGPT
	public static boolean contieneNumeros(String texto) {
		// Define una expresión regular para buscar números en la cadena
		String patron = ".*\\d.*";

		// Crea un objeto Pattern
		Pattern pattern = Pattern.compile(patron);

		// Crea un objeto Matcher para buscar coincidencias
		Matcher matcher = pattern.matcher(texto);

		// Comprueba si hay coincidencias
		return matcher.matches();
	}

	public static boolean formatoErroneoDni(String dni) {
		return dni.length() != 9;
	}

	// Metodo de ChatGPT
	public static int capturarNumero() {
		int numero = 0;
		boolean entradaValida = false;
		Scanner leer = new Scanner(System.in);

		do {

			if (leer.hasNextInt()) {
				numero = leer.nextInt();
				entradaValida = true;
			} else {
				System.out.println("Entrada inválida. Por favor, ingresa un número válido.");
				leer.nextLine(); // Limpia el buffer de entrada
			}
		} while (!entradaValida);

		return numero;
	}

	public static int campoAModificar() {
		int numCampo;
		do {
			// Imprimo las opciones que se pueden modificar
			System.out.println("1.-Nombre");
			System.out.println("2.-Apellidos");
			System.out.println("3.-Dni");
			System.out.println("4.-Fecha de Nacimiento");
			System.out.println("5.-Titulacion");
			System.out.println("6.-Numero de la Seguridad Social");
			System.out.println("7.-Numero de Cuenta");
			System.out.print("Que campo quiere modificar: ");

			// Capturo la opcion
			numCampo = capturarNumero();

			if (numCampo < 1 || numCampo > 7) {
				System.out.println("El valor introducido no es correcto ");
			}
		} while (numCampo < 1 || numCampo > 7);

		return numCampo;
	}
}
