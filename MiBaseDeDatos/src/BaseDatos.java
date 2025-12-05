import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	
	private Connection cn;
	private String driver, cadenaConexion;
	
	public BaseDatos() {
		cadenaConexion = "jdbc:mysql://localhost:3306/socios";
		driver = "com.mysql.jdbc.Driver";
		try {
			cn=DriverManager.getConnection(cadenaConexion, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	//FUNCIONESc
	//OBTERNER DATOS (RESULTADO DE SELECT)
	public ResultSet obtenerTodos() {
		String sentencia;
		PreparedStatement sqlSent;
		ResultSet rs;
		sentencia = "SELECT * FROM socios";
		try {
			sqlSent=cn.prepareStatement(sentencia, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sqlSent.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public ResultSet obtenerDatos(String sentencia) {
		PreparedStatement sqlSent;
		ResultSet rs;
			try {
				sqlSent=cn.prepareStatement(sentencia, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs=sqlSent.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
	public int actulizarSocio(int numSocio, String nombre, String direccion, String telefono) {
		
		String sent;
		PreparedStatement sentencia;
		sent = "UPDATE socios SET nombre = ?, direccion = ?, telefono = ? WHERE numSocio = ?";
		try {
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, nombre);
			sentencia.setString(2, direccion);
			sentencia.setString(3, telefono);
			sentencia.setInt(4, numSocio);
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
	}
	public int actulizarSocio(String sent) {
		PreparedStatement sentencia;
		try {
			sentencia=cn.prepareStatement(sent);
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
		}
		
	public int eliminarSocio(int id) {
		String sent;
		PreparedStatement sentencia;
		sent = "DELETE FROM socios WHERE numSocio = ?";
		try {
			sentencia=cn.prepareStatement(sent);
			sentencia.setInt(1, id);
			return sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}return 0;
	}
	public int insertarSocio(String nombre, String direccion, String telefono) {
		//Devuelve el número de filas insertadas
		String sentencia;
		PreparedStatement sqlSent;
		sentencia = "INSERT INTO socios VALUES (null, '"+nombre+"', '"+direccion+"', '"+telefono+"')";
		
		//CON PARÁMETROS
		sentencia = "INSERT INTO socios VALUES (null, ?, ?, ?)";
		try {
			sqlSent=cn.prepareStatement(sentencia);
			sqlSent.setString(1, nombre);
			sqlSent.setString(2, direccion);
			sqlSent.setString(3, telefono);
			return sqlSent.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertarSocio(Socio socio) {
		return insertarSocio(socio.getNombre(), socio.getDireccion(), socio.getTelefono());
	}
	
	//GETTERS Y SETTERS
	
	public Connection getCn() {
		return cn;
	}
	
	public void setCn(Connection cn) {
		this.cn = cn;
	}
}
