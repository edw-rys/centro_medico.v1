package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private  Connection conection;
        final String nombreBaseDatos="centromedico";
	final String cadenaConexion="jdbc:mysql://localhost/"+nombreBaseDatos+"";
	final String User="root";
	final String password="";
	//constructor para la clase
	public ConexionBaseDatos(){
		this.conection=null;
	}
	//metodo para obtener la conexion
	public Connection getConection(){
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException e) {
			System.out.println("Class mysql no encontrada");
		}		
		try {
                this.conection= DriverManager.getConnection
                    (cadenaConexion,this.User,this.password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return this.conection;
	}
        
        
}
