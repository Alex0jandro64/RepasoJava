package entidades;

public class Empleado {

	//Atributos
	String nombre, apellidos, dni, fechaNacimiento, titulacion;
	int numSeguridadSocial, numCuenta, numEmpleado;
	
	//Constructor
	public Empleado(String nombre, String apellidos, String dni, String fechaNacimiento, String titulacion,
			int numSeguridadSocial, int numCuenta, int numEmpleado) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.titulacion = titulacion;
		this.numSeguridadSocial = numSeguridadSocial;
		this.numCuenta = numCuenta;
		this.numEmpleado = numEmpleado;
	}
	
	public Empleado() {
		super();
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getNumSeguridadSocial() {
		return numSeguridadSocial;
	}

	public void setNumSeguridadSocial(int numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	
	
}
