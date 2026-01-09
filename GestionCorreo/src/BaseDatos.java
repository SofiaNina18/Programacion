import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	//DATOS
	private Connection cn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadenaConex="jdbc:mysql://localhost:3306/gestionCorreo";
	
	public BaseDatos() {
		try {
			cn=DriverManager.getConnection(cadenaConex, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cn=null;
		} 
	}

	//ACCIONES SOBRE LA BASE DE DATOS
	public int insertar(Persona per) {
		//ESCRIBIR LA SENTENCIA
		//PREPARARLA
		//LANZARLA
		String strSent;
		PreparedStatement sentencia;
		Empleado emp;
		strSent="INSERT INTO personas VALUES (null, ?,?,?,?,?,?,?)";
		//ASIGNAR LOS VALORES A LOS PARÁMETROS (?). LOS DE EMPLEADO VACÍOS (esEmpleado a false)
		try {
			sentencia=cn.prepareStatement(strSent);
			sentencia.setString(1, per.getNombre());
			sentencia.setString(2, per.getCorreo());
			sentencia.setString(3, per.getWeb());
			sentencia.setBoolean(4, false);
			sentencia.setInt(5, -1);
			sentencia.setString(6, null);
			sentencia.setString(7, null);

			if(per.getClass()==Empleado.class) {
				//ASIGNAR LOS VALORES DE LOS PARÁMETROS QUE SOLO SON DE EMPLEADO (esEmpleado a true)
				emp=(Empleado) per;
				sentencia.setBoolean(4, true);
				sentencia.setInt(5, emp.getEdad());
				sentencia.setString(6, emp.getDireccion());
				sentencia.setString(7, emp.getTelefono());
			}
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet obtenerDatos() { //DEVUELVE TODOS LOS DATOS DE TODOS LOS SOCIOS
		String sentencia;
		PreparedStatement sqlSent;
		ResultSet rs;
		sentencia="SELECT * FROM personas";
		try {
			sqlSent=cn.prepareStatement(sentencia, ResultSet.TYPE_SCROLL_INSENSITIVE, 
										ResultSet.CONCUR_UPDATABLE);
			rs=sqlSent.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}
	
	
}
