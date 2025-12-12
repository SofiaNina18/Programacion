
public class Persona {
	
	//DATOS
	private int id;
	private String nombre, correo, web;
	
	//CONSTRUCTOR
	public Persona() {
		id = -1;
		nombre = "";
		correo = "";
		web = "";
	}
	public Persona(String nombre, String correo, String web) {
		id = -1;
		this.nombre = nombre;
		this.correo = correo;
		this.web = web;
	}
	//METODOS
	
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	
	
}
