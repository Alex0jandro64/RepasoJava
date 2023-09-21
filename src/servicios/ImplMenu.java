package servicios;

public class ImplMenu implements InterfazMenu{

	public void Menu() {
		System.out.println("1.-Registrar Empleado");
		System.out.println("2.-Modificar Empleado");
		System.out.println("3.-Exportar Empleados");
		System.out.println("4.-Cerrar Aplicacion");
	}
	
	public void limpiar(int lineas)
	{
	 for (int i=0; i < lineas; i++)
	 {
	  System.out.println();
	 }
	}
}
