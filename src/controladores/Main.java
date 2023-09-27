package controladores;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Empleado;
import servicios.ImplEmpleado;
import servicios.ImplMenu;
import servicios.InterfazEmpleado;
import servicios.InterfazMenu;


public class Main {

	public static void main(String[] args) {
		
		//Implementamos
		InterfazMenu implMenu = new ImplMenu();
		InterfazEmpleado implEmpleado = new ImplEmpleado();
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Scanner leer = new Scanner(System.in);
		
		//Ejecucion del programa
		int opcionMenu;
		
		do {
			//Muestro y capturo la opcion
			do {
				implMenu.Menu();
				opcionMenu = leer.nextInt();
			}while(opcionMenu < 1 || opcionMenu > 4);
			
			switch (opcionMenu) {
				case 1:
					System.out.println("---------Registrar Empleado---------");
					implEmpleado.registrarEmpleado(listaEmpleados);
					break;
					
				case 2:
					System.out.println("---------Modificar Empleado---------");
					implEmpleado.modificarEmpleado(listaEmpleados);
					break;
					
				case 3:
					System.out.println("---------Exportar Empleados---------");
					implEmpleado.exportarFicher(listaEmpleados);
					break;
			}
			
			
		}while(opcionMenu != 4);
		

	}
	

}
