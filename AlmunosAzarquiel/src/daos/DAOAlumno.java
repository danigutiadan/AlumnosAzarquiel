package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Alumno;
import model.Email;
import model.Telefono;

public class DAOAlumno {
	

	//Método que añade un alumno con sus campos (dni, nombre, curso)
	public void insertAlumno(String dni, String nombre, String curso) {

		Connection con = Conexion.conecta();
		PreparedStatement ps = null;

		try {
			String ordenSql = "INSERT into alumno values ('?', '?', '?')";
			ps = con.prepareStatement(ordenSql);

			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, curso);

			ps.executeUpdate();

			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}
	
	
	//Método para obtener alumnos a partir de lo que escribas en la caja de texto 'Search'
	public ArrayList<Alumno> getAlumnosBySearch(String cadena) {
		
		ArrayList<Alumno> alumnos = null;	
		ArrayList<String> sqls = new ArrayList<String>();
		sqls.add("select * from alumno where upper(dni) like upper('%"+cadena+"%')");
		sqls.add("select * from alumno where upper(nombre) like upper('%"+cadena+"%')");
		sqls.add("select * from alumno where dni in (select dni from emilio where lower(email) like lower('%"+cadena+"%'))");
		sqls.add("select * from alumno where dni in (select dni from telefono where tlf like '%"+cadena+"%')");
		sqls.add("select * from alumno where curso like '%"+cadena+"%'");
		
		String sqlValida = "select * from alumno";
		
		for (int i=0;i<sqls.size()-1;i++) {
			
			String sql1 = sqls.get(i);
			String sql2 =sqls.get(i+1);
			
			if (getAlumnos(sql1).size() < getAlumnos(sql2).size()) {
				alumnos = getAlumnos(sql1);
				sqlValida = sql1;
				break;
			} else if (getAlumnos(sql1).size() > getAlumnos(sql2).size()) {
				alumnos = getAlumnos(sql2);
				sqlValida = sql2;
				break;
			}
			
		}
		
		alumnos = getAlumnos(sqlValida);
		return alumnos;	
	}
	
	
	//Método para obtener alumnos a partir de la opción seleccionada 
	//en la lista desplegable 'Selecciona curso'
	public ArrayList<Alumno> getAlumnosByCurso(String curso) {
		
		String sql = "select * from alumno where curso like '%"+curso+"%'";
		ArrayList<Alumno> alumnos = getAlumnos(sql);
		return alumnos;
	}	

	
	//Método que saca todos los alumnos de la base de datos junto con 
	//su DNI, Nombre, Curso, lista de teléfonos y lista de emails
	private ArrayList<Alumno> getAlumnos(String sql1) {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Connection con = Conexion.conecta();
		Statement st1;
		PreparedStatement ps2, ps3;	
		ResultSet rs1, rs2, rs3;
		String sql2, sql3;
		
		ps2 = null;
		ps3 = null;

		try {
			
			st1 = con.createStatement();
			rs1 = st1.executeQuery(sql1);

			while (rs1.next()) {
				
				Alumno alumno = new Alumno();
				alumno.setDni((rs1.getString("dni")));
				alumno.setNombre((rs1.getString("nombre")));
				alumno.setCurso((rs1.getString("curso")));

				// Una vez en un alumno concreto, se sacan todos sus teléfonos

				try {
					
					ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
					sql2 = "select tlf from telefono where dni = '?'";
					ps2 = con.prepareStatement(sql2);

					ps2.setString(1, rs1.getString("dni"));
					rs2 = ps2.executeQuery();
					
					while (rs2.next()) {
						Telefono telefono = new Telefono();
						telefono.setTelefono(rs2.getString("tlf"));
						telefonos.add(telefono);
					}
					
					alumno.setTelefonos(telefonos);
					
					rs2.close();
					ps2.close();
					
				} catch (SQLException e) {
					System.out.println("Error al acceder a la BDs: " + e.getMessage());
				}

				// Así como todos sus emails:

				try {
					
					ArrayList<Email> emails = new ArrayList<Email>();
					sql3 = "select email from emilio where dni = '?'";
					ps3 = con.prepareStatement(sql3);

					ps3.setString(1, rs1.getString("dni"));
					rs3 = ps3.executeQuery();

					while (rs3.next()) {
						Email email = new Email();
						email.setEmail(rs3.getString(1));
						emails.add(email);
					}

					alumno.setEmails(emails);
					
					rs3.close();
					ps3.close();
					
				} catch (SQLException e) {
					System.out.println("Error al acceder a la BDs: " + e.getMessage());
				}
				
				// Finalmente se añade el objeto alumno a la lista de alumnos
				alumnos.add(alumno);
			}

			rs1.close();
			st1.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return alumnos;
	}
	
	
	//Método que borra un alumno de la base de datos
	public void deleteAlumno(String dni) {

		Connection con = Conexion.conecta();
		PreparedStatement ps = null;
		String ordenSql;

		try {
			
			ordenSql = "DELETE from alumno where dni='?'";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			ps.executeUpdate();
			
			ordenSql = "DELETE from emilio where dni='?'";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			ps.executeUpdate();
			
			ordenSql = "DELETE from telefono where dni='?'";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}
	
	
}
