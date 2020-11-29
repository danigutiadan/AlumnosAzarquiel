package model;

public class Curso {
	
	private String curso;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String curso) {
		super();
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Curso [curso=" + curso + "]";
	}
	
}
