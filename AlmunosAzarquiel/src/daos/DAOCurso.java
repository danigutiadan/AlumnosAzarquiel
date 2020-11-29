package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Curso;

public class DAOCurso {
	//M�todo que obtiene todos los cursos del listado.
	public ArrayList<Curso> getCursos() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Connection con = Conexion.conecta();
		Statement st;
		ResultSet rs;
	
		try {
			st = con.createStatement();
			String ordenSql = "select curso from curso";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCurso((rs.getString("curso")));
				cursos.add(curso);
			}
			rs.close();
			st.close();
			con.close();
			
		}	catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return cursos;
	}

	//M�todo que a�ade un curso.
	public void addCurso(String curso) {

		Connection con = Conexion.conecta();
		PreparedStatement ps = null;

		try {
			String ordenSql = "insert into curso values('?')";
			ps = con.prepareStatement(ordenSql);

			ps.setString(1, curso);
			ps.executeUpdate();

			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}

	//M�todo que borra un curso. 
	// OJO!! Al borrar un curso se eliminan todos los alumnos de dicho curso por lo que deber�a haber un mensaje de confirmaci�n.
	public void deleteCurso(String curso) {

		Connection con = Conexion.conecta();
		PreparedStatement ps = null;

		try {
			String ordenSql = "delete from curso where curso = '?'";
			ps = con.prepareStatement(ordenSql);

			ps.setString(1, curso);

			ps.execute();

			ps.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
	}

}
