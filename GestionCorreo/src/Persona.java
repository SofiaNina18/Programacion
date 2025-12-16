
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
	public boolean esCorreoCorrecto() {
		correo.matches("[a-zA-z0-9+_]+([.][a-zA-Z0-9+_]+)*[@]+");
		
		//QUE TENGA UNA ARROBA Y SOLO UNA (si la posicion de la primera y la ultima @ no son la misma -> false
		/*String str="Hola a todos, hoy es lunes";
		
		str.charAt(3);
		str.indexOf('1');
		str.lastIndexOf('1');
		
		str.indexOf(65);
		str.endsWith(".png");*/
		
		if(correo.indexOf('@')!=correo.lastIndexOf('@')) {
			return false;
		}	
		
		//que no contenga espacios
		if(correo.contains(" ")) {
			return false;
		}
		
		//DESPUES DEL ULTIMO PUNTO (DESPUES DE LA @) AL MENOS 2 LETRAS (para el dominio): roberto.almi@almi.es
		if(correo.lastIndexOf('.') < correo.lastIndexOf('@') && correo.lastIndexOf('.') + 3 >= correo.length()) {
			return false;
		}
		
		//QUE TENGA UN PUNTO DESPUES DE LA ARROBA AL MENOS LETRAS
		
		if(correo.lastIndexOf('.') < correo.indexOf('@') + 3) {
			return false;
		}
		
		
		//ANTES DE LA ARROBA AL MENOS DOS LETRAS
		if(correo.indexOf('@') < 2) {
			return false;
		}
		
		//ENTRE LA ARROBA Y EL PUNTO AL MENOS DOS LETRAS
		
		return true;
	}
	
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
