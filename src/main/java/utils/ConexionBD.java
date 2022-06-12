package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase que permite a java conctarse con mysql
 * @author Javi
 *
 */

public abstract class ConexionBD {
	//Línea para conectarse con tu base de datos
	private final static String cadenaConexion = "jdbc:mysql://127.0.0.1:3306/dbpfinal";
	//Nombre del usuario de la BBDD
	private final static String usuarioBD = "root";
	//Contraseña del usuario de la BBDD
	private final static String passwordBD = "1234";
	private static Connection conexion; // singleton

	public static Statement conectar() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void desconectar() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
