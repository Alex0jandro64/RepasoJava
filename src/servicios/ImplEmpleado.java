package servicios;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import entidades.Empleado;

public class ImplEmpleado implements InterfazEmpleado {

	public void registrarEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);

		// Creo el objeto Empleado
		Empleado empl1 = new Empleado();

		// Pido los datos del Empleado
		System.out.println("Nombre: ");
		empl1.setNombre(leer.nextLine());
		System.out.println("Apellidos: ");
		empl1.setApellidos(leer.nextLine());
		System.out.println("DNI: ");
		empl1.setDni(leer.nextLine());
		System.out.println("Fecha de Nacimiento: ");
		empl1.setFechaNacimiento(leer.nextLine());
		System.out.println("Titulacion: ");
		empl1.setTitulacion(leer.nextLine());
		System.out.println("Numero de Seguridad Social: ");
		empl1.setNumSeguridadSocial(leer.nextInt());
		System.out.println("Numero de Cuenta: ");
		empl1.setNumCuenta(leer.nextInt());
		empl1.setNumEmpleado(listaEmpleadosAntigua.size());

		listaEmpleadosAntigua.add(empl1);

	}

	public void modificarEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);

		// Metodo que imprime y captura un Empleado
		int numEmpleado = opcionEmpleado(listaEmpleadosAntigua);

		// Pido y modifico los datos del empleado seleccionado
		System.out.println("Nombre: ");
		listaEmpleadosAntigua.get(numEmpleado).setNombre(leer.nextLine());

		System.out.println("Apellidos: ");
		listaEmpleadosAntigua.get(numEmpleado).setApellidos(leer.nextLine());

		System.out.println("Dni: ");
		listaEmpleadosAntigua.get(numEmpleado).setDni(leer.nextLine());

		System.out.println("Fecha Nacimiento: ");
		listaEmpleadosAntigua.get(numEmpleado).setFechaNacimiento(leer.nextLine());

		System.out.println("Titulacion: ");
		listaEmpleadosAntigua.get(numEmpleado).setTitulacion(leer.nextLine());

		System.out.println("Numero de Seguridad Social: ");
		listaEmpleadosAntigua.get(numEmpleado).setNumSeguridadSocial(leer.nextInt());

		System.out.println("Numero de Cuenta: ");
		listaEmpleadosAntigua.get(numEmpleado).setNumCuenta(leer.nextInt());

	}

	public void exportarFicher(List<Empleado> listaEmpleadosAntigua) {
		
		Scanner leer = new Scanner(System.in);
		int opcion;
		int numEmpleado;
        //Pregunto y capturo si quiere exportar a todos o solo a uno
		do {
			System.out.println("Quiere exportar todos los Empleados (1) o solo a uno (2): ");
			opcion = leer.nextInt();
		}while(opcion < 1 || opcion > 2);
		
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("./Empleados.txt");
			pw = new PrintWriter(fichero);
			pw.println("Numero de Empleado;Nombre;Apellidos;Dni;Fecha de Nacimiento;Titulacion");
			if(opcion==1) {
				for (Empleado empleado : listaEmpleadosAntigua) {
					pw.println(empleado.getNumEmpleado()+";"+empleado.getNombre()+";"+empleado.getApellidos()+";"+empleado.getDni()+";"+empleado.getFechaNacimiento()+";"+empleado.getTitulacion());
				}
			}else {
				numEmpleado = opcionEmpleado(listaEmpleadosAntigua);
				pw.println(listaEmpleadosAntigua.get(numEmpleado).getNumEmpleado()+";"+listaEmpleadosAntigua.get(numEmpleado).getNombre()+";"+listaEmpleadosAntigua.get(numEmpleado).getApellidos()+";"+listaEmpleadosAntigua.get(numEmpleado).getDni()+";"+listaEmpleadosAntigua.get(numEmpleado).getFechaNacimiento()+";"+listaEmpleadosAntigua.get(numEmpleado).getTitulacion());
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

	public int opcionEmpleado(List<Empleado> listaEmpleadosAntigua) {

		Scanner leer = new Scanner(System.in);
		// Metodo que imprime y captura un numero de empleado
		int numEmpleado;

		// Imprimos todos los empleados actuales en la lista para facilitar los numeros
		// de empleados
		for (Empleado empleado : listaEmpleadosAntigua) {
			System.out.println("Nº Empleado:" + empleado.getNumEmpleado() + " " + empleado.getNombre() + " "
					+ empleado.getApellidos());
		}

		System.out.println("Que empleado quiere seleccionar (nº Empleado): ");

		// Capturo el numero de empleado
		do {
			numEmpleado = leer.nextInt();
			if (numEmpleado < 0 || numEmpleado > listaEmpleadosAntigua.size()) {
				System.out.println("El valor introducido no es correcto");
			}
		} while (numEmpleado < 0 || numEmpleado > listaEmpleadosAntigua.size());

		return numEmpleado;
	}
}
