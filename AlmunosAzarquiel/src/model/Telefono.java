package model;

public class Telefono {

	private String telefono;
	private String dni;
	
	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefono(String telefono, String dni) {
		super();
		this.telefono = telefono;
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Telefono [telefono=" + telefono + ", dni=" + dni + "]";
	}
	
}
