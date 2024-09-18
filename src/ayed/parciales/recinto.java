package ayed.parciales;

public class recinto {
	private String nombre;
	private int tiempo;
	
	public recinto (String unNombre, int unTiempo) {
		this.nombre = unNombre;
		this.tiempo = unTiempo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTiempo() {
		return this.tiempo;
	}
}
