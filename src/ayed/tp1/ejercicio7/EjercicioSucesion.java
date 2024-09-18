package ayed.tp1.ejercicio7;
import java.util.*;

public class EjercicioSucesion {
public  static List<Integer> calcularSucesion (int n,List<Integer> lista) {
	if(n == 1) {
		lista.add(1);
	}
	else if (n % 2 == 0) {
		lista.add(n);
		calcularSucesion(n/2, lista);
		}
	else {
		lista.add(n);
		calcularSucesion((3*n + 1),lista);
	}
	return lista;
	}
}


