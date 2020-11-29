package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DAOAlumno;
import daos.DAOCurso;
import model.Alumno;
import model.Curso;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
		
		if (op.equals("inicio")) {
			
			//Subimos datos a la sesión
			ArrayList<Curso> cursos = new DAOCurso().getCursos();
			session.setAttribute("cursos", cursos);
			//Refrescamos la vista, con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		} else if (op.equals("alumnosByCurso")) {
				
			try {
				//Recuperamos datos de la sesión
				String curso = (String) request.getParameter("curso");
				//Subimos datos a la sesión
				ArrayList<Alumno> alumnos = new DAOAlumno().getAlumnosByCurso(curso);
				request.setAttribute("alumnos", alumnos);
			} catch (NullPointerException e) {
				System.out.println("Error al recuperar los alumnos de la sesión: "+e.getMessage());
			}
			
			//Refrescamos la vista, con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
