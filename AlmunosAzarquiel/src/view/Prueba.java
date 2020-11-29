package view;

import java.util.ArrayList;

import daos.DAOAlumno;
import daos.DAOCurso;
import model.Alumno;
import model.Curso;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bucle para probar si se muestran todos los alumnos con sus datos

		ArrayList<Alumno> alumnos = new DAOAlumno().getAlumnosByCurso("2013-2014");
		System.out.println("PRUEBA DE BÚSQUEDA DE TODOS LOS ALUMNOS:");
		for (Alumno alumno : alumnos) {
			System.out.println("DNI del alumno: " + alumno.getDni());
			System.out.println("Nombre del alumno: " + alumno.getNombre());
			System.out.println("Curso del alumno: " + alumno.getCurso());
			System.out.println("Teléfonos del alumno: " + alumno.getTelefonos());
			System.out.println("Emails del alumno: " + alumno.getEmails());
			System.out.println();
		}
		
		
		// Bucle para probar si se muestran alumnos en concreto según nombre y curso, por ejemplo JOSE del curso 2007-2008:
		ArrayList<Alumno> alumnos2 = new DAOAlumno().getAlumnosByCurso("2015-2016");
		System.out.println("PRUEBA DE BÚSQUEDA DE UN DETERMINADO ALUMNO:");
		for (Alumno alumno : alumnos2) {
			System.out.println("DNI del alumno: " + alumno.getDni());
			System.out.println("Nombre del alumno: " + alumno.getNombre());
			System.out.println("Curso del alumno: " + alumno.getCurso());
			System.out.println("Teléfonos del alumno: " + alumno.getTelefonos());
			System.out.println("Emails del alumno: " + alumno.getEmails());
			System.out.println();
		}
		// Bucle para probar si se insertan alumnos a la base de datos, sin al principio añadir Teléfonos o Emails:
		//DAOAlumno insercionAlumno = new DAOAlumno();
		//insercionAlumno.addAlumno("12345678A", "Pepe Sanchez", "2020-2021");
		
		// Bucle para probar si se modifican los datos básicos de un alumno, como su nombre, dni o curso:
		//DAOAlumno edicionAlumno = new DAOAlumno();
		//edicionAlumno.modificarAlumno("12345678A", "87654321A", "Paco Sanchez", "2020-2021");
		
		// Bucle para probar si se borran todos los datos de un alumno en concreto
		//DAOAlumnoView borradoAlumno = new DAOAlumnoView();
		//borradoAlumno.deleteAlumno("12345678A");
		
		// Bucle para probar si se añade un teléfono a un alumno en concreto
		//DAOTelefono insercionTlf = new DAOTelefono();
		//insercionTlf.addTelefono("12345678A", 600600601);
		
		// Bucle para probar si se elimina un teléfono de un alumno en concreto
		//DAOTelefono borradoTlf = new DAOTelefono();
		//borradoTlf.deleteTelefono("12345678A", 600600600);
		
		// Bucle para probar si se añade un email a un alumno en concreto
		//DAOEmail insercionEmail = new DAOEmail();
		//insercionEmail.addEmail("12345678A", "emaildeprueba@pruebamail.com");
		
		// Bucle para probar si se elimina un email de un alumno en concreto
		//DAOEmail borradoEmail = new DAOEmail();
		//borradoEmail.deleteEmail("12345678A", "emaildeprueba@pruebamail.com");
		
		// Bucle para probar si se muestran todos los cursos
		ArrayList<Curso> cursos = new DAOCurso().getCursos();
		
		System.out.println("LISTADO DE CURSOS: ");
		for (Curso curso : cursos) {
			
			System.out.println(curso.getCurso());
		}
		
		// Bucle para probar si se añade un nuevo curso
		//DAOCurso insercionCurso = new DAOCurso();
		//insercionCurso.addCurso("2018-2019");

		// Bucle para probar si se elimina un nuevo curso
		// OJO!! Al eliminar un curso se eliminarán todos los alumnos de dicho curso!! 
		//DAOCurso borradoCurso = new DAOCurso();
		//borradoCurso.deleteCurso("2020-2021");

}
}
