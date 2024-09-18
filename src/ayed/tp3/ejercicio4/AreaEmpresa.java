package ayed.tp3.ejercicio4;

public class AreaEmpresa {
	private int tiempo = 0; 
	private String identificador;
	
	public AreaEmpresa(int tiempo, String identificador) {
		this.tiempo = tiempo;
		this.identificador = identificador;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
