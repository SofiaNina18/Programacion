import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

public class BaseDatos {
	//DATOS
	private Connection cn;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String cadenaConex = "jdbc:mysql://localhost:3306/gestioncorreo";
	
	public BaseDatos() {
		try {
			cn = DriverManager.getConnection(cadenaConex ,"root","");
		} catch (Exception e) {
			e.printStackTrace();
			cn = null;
		}
		
	}
	
	//ACCIONES SOBRE LA BASE DE DATOS
	public int insertar(Persona per) {
		//ESCRBIR LA ESTENCIA
		//PREPAARLA
		//LANZARLA	
		String strSent;
		PreparedStatement sentencia;
		Empleado emp;
		strSent = "INSERT INTO personas (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			//AIGNAR LOS VALORES A LOS PARAMETROS (?). LOS DE EMPLEADO VACIOS (esEmpleado a false)
			try {
				sentencia = cn.prepareStatement(strSent);
				sentencia.setString(1, per.getNombre());
				sentencia.setString(2, per.getCorreo());
				sentencia.setString(3, per.getWeb());
				sentencia.setBoolean(4, false);
				sentencia.setNull(5, Types.INTEGER);
				sentencia.setNull(6, Types.VARCHAR);
				sentencia.setNull(7, Types.VARCHAR);
				
				
				if(per.getClass() == Empleado.class) {
					emp = (Empleado) per;
					sentencia.setBoolean(4, true);
					sentencia.setInt(5, emp.getEdad());
					sentencia.setString(6, emp.getDireccion());
					sentencia.setString(7, emp.getTelefono());
					
				}return sentencia.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
			
		
	
	//GETTERS AND SETTERS
	public Connection getCn() {
		return cn;
	}
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	public ArrayList<Persona> obtenerPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet obtenerDatos() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
