package ayed.tp5;

public class Persona {

	private String nombre;
	private String tipo;
	private String domicilio;
	
	public Persona (String nombre,String tipo, String domicilio) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean esEmpleado() {
		return tipo == "Empleado";
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public boolean equals (Object obj) {
		if (obj instanceof Persona) {
	        Persona tmpPersona = (Persona) obj;
	            if (this.nombre.equals(tmpPersona.nombre) && this.tipo.equals(tmpPersona.tipo) && this.domicilio.equals(tmpPersona.domicilio)) {
	            	return true;
	            }
		}
		return false;
	}
	
}
