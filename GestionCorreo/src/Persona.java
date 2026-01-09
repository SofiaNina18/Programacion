
public class Persona {
	public static final int GUARDADO=0;
	public static final int MODIFICADO=1;
	public static final int NUEVO=2;
	//DATOS
	private int id;
	private String nombre, correo, web;
	private int estado;
	
	//CONSTRUCTOR/ES
	public Persona() {
		id=-1;
		nombre="";
		correo="";
		web="";
	}
	
	public Persona(String nombre, String correo, String web) {
		id=-1;
		this.nombre=nombre;
		this.correo=correo;
		this.web=web;
		this.estado=NUEVO;
	}

	//METODOS
	public boolean esCorreoCorrecto() {
		//correo.matches("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[@]+");	
		if(!correo.matches("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,}")) {
						//	  rober12     (.rober1)          @rober12.rober                   .uk
			return false;
		} else {
			return true;
		}
		/*
		//QUE NO CONTENGA UN ESPACIO 
		if(correo.contains(" ")) {
			return false;
		}
		//QUE TENGA UNA ARROBA Y SOLO UNA (si la posición de la 1ª y la última @ no son la misma -> false)
		if(correo.indexOf("@")!=correo.lastIndexOf("@")) {
			return false;
		}
		//DESPUÉS DEL ÚLTIMO PUNTO (después de la @) AL MENOS 2 LETRAS (para el dominio):  roberto.almi@almi.es
		if(correo.lastIndexOf(".")<correo.lastIndexOf("@") && correo.lastIndexOf(".")+3>correo.length()) {
			return false;
		}
		
		//ANTES DE LA ARROBA AL MENOS DOS LETRAS
		if(correo.indexOf("@")<2) {
			return false;
		}
		//ENTRE LA ARROBA Y EL "." AL MENOS DOS LETRAS
		if(correo.lastIndexOf(".")<correo.lastIndexOf("@")+3 ) {
			return false;
		}
		return true;*/
	}
	
	
	
	//GETTERS y SETTERS
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
