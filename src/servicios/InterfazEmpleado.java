package servicios;

import java.util.List;

import entidades.Empleado;

public interface InterfazEmpleado {
	
	public void registrarEmpleado(List<Empleado> listaEmpleadosAntigua);
	
	public void modificarEmpleado(List<Empleado> listaEmpleadosAntigua);
	
	public void exportarFicher(List<Empleado> listaEmpleadosAntigua);
	
	public int opcionEmpleado(List<Empleado> listaEmpleadosAntigua);
	
}
