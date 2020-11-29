package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class DAOEmail {
	
	//Método para añadir un email (email) a un alumno según su (dni)
	public void insertEmail(String dni, String email){
		
		Connection con = Conexion.conecta();
		PreparedStatement ps = null;
		
		try {
			String ordenSql = "insert into emilio values('?','?')";
			ps = con.prepareStatement(ordenSql);		
			ps.setString(1,dni);
			ps.setString(2,email);		
			ps.executeUpdate();
				
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
	}

	//Método para eliminar un email (email) de un alumno en concreto (dni).
	public void deleteEmail (String dni, String email){
	
		Connection con = Conexion.conecta();
		PreparedStatement ps = null;
		
		try {
			String ordenSql = "delete from emilio where dni = '?' and email = '?'";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			ps.setString(2, email);
			ps.executeUpdate();
			
			ps.close();
			con.close();
	
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}
	
}
