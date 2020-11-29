package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;


public class DAOTelefono {
	//Método para añadir un teléfono (telefono) a un alumno según su (dni)
	public void insertTelefono (String dni, String telefono){
		
		Connection con = Conexion.conecta();
		PreparedStatement ps = null;
		
		try {
			String ordenSql = "insert into telefono values('?','?')";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1,dni);
			ps.setString(2,telefono);		
			ps.executeUpdate();	
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}
	
	//Método para eliminar un teléfono (telefono) de un alumno en concreto (dni).
	public void deleteTelefono (String dni, long telefono){
		
		Connection con = Conexion.conecta();
		PreparedStatement ps = null;
		
		try {
			String ordenSql = "delete from telefono where dni = ? and tlf = ?";
			ps = con.prepareStatement(ordenSql);	
			ps.setString(1, dni);
			ps.setLong(2, telefono);
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}
	
}


