
public class Socio {
	//DATOS (private)
	private int numSocio;
	private String nombre, direccion, telefono;
	
	
	//CONSTRUCTOR/ES
	
	public Socio() {
		numSocio = 1;
		nombre = "";
		direccion = "";
		telefono = "";
	}
		
	public Socio(int numSocio, String nombre, String direccion, String telefono) {
		this.numSocio = numSocio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		
		
	}
	
	//MÉTODOS (FUNCIONES)
	
	
	//GETTERS Y SETTERS
	
	public int getNumSocio() {
		return numSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	
	
	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
