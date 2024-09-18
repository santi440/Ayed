package tp2.ejercicio9;

public class Totales {
	private int sum;
	private int dif;
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getDif() {
		return dif;
	}
	public void setDif(int dif) {
		this.dif = dif;
	}
	
	public Totales(int sum, int dif) {
		this.sum = sum;
		this.dif = dif;
	}
	
	public String toString () {
		return "Valor suma = " + sum +" Valor diferencia = " + dif;
	}
	
	
	
}
