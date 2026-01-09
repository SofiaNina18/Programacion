import javax.swing.JButton;

public class Empleado extends Persona {
	//DATOS
	private int edad;
	private String direccion, telefono;
	
	//CONSTRUCTORES
	public Empleado() {
		super();
		edad=-1;
		this.direccion="";
		this.telefono="";
	}
	
	public Empleado(String nombre, String correo, String web, int edad, String direccion, String telefono) {
		super(nombre, correo, web);
		this.edad=edad;
		this.direccion=direccion;
		this.telefono=telefono;
	}
	
	public Empleado(Persona per, int edad, String direccion, String telefono) {
		super(per.getNombre(), per.getCorreo(), per.getWeb());
		this.edad=edad;
		this.direccion=direccion;
		this.telefono=telefono;
	}

	//GETTERS y SETTERS 
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}








