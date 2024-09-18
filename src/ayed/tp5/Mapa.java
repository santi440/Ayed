package ayed.tp5;

import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

public class Mapa {
	
	static Graph<String> mapaCiudades = new AdjListGraph<>();
	
	public static List<String> devolverCamino (String ciudad1, String ciudad2) {
		boolean[]visitados = new boolean[mapaCiudades.getSize()];
		List<String> resultado = new LinkedList<String>();
		List<String> camino = new LinkedList<String>();
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if(origen != null) {
			int i = origen.getPosition();
			devolverCamino(i, ciudad2, visitados,camino,resultado);
		}
		return resultado;
	}
	
	private static void devolverCamino(int i,String ciudad2, boolean[] visitados,List<String> camino, List<String> resultado) {
		Vertex<String> v = mapaCiudades.getVertex(i);
		camino.add(v.getData());
		if(v.getData() == ciudad2) {
			resultado.addAll(camino);
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(v);
			for(Edge<String> a: ady) {
				Vertex<String> destino = a.getTarget();
				if(!visitados[destino.getPosition()]) {
					visitados[destino.getPosition()] = true;
					devolverCamino(destino.getPosition(), ciudad2, visitados, camino, resultado);
				}
			}
		}
		
	}
	
	public  static List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades) {
		List<String> resultado = new LinkedList<String>();
		List<String> camino = new LinkedList<String>();
		boolean[] marcados = new boolean[mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if(origen != null) {
			marcados[origen.getPosition()] = true;
			devolverCaminoExceptuando(origen.getPosition(), ciudad2, ciudades,resultado,camino,marcados);
		}
		return resultado;
	}
	private static  void devolverCaminoExceptuando (int i, String ciudad2, List<String> ciudades, List<String> resultado, List<String> camino, boolean[] marcados) {
		Vertex<String> act = mapaCiudades.getVertex(i);
		//System.out.println(act.getData());
		boolean prohibido = false;
		int a = 0;
		while(!prohibido && a<ciudades.size()) {
			if(ciudades.get(a).equals(act.getData())) {
				prohibido = true;
			}
			a++;
		}
		//System.out.println(prohibido);
		if(!prohibido) {
			camino.add(act.getData());
			if(act.getData().equals(ciudad2)) {
				resultado.addAll(camino);
			}
			else {
				List<Edge<String>> ady = mapaCiudades.getEdges(act);
				for(Edge<String> e: ady) {
					Vertex<String> destino = e.getTarget();
					//System.out.print(destino.getData());
					if(!marcados[destino.getPosition()]) {
						marcados[destino.getPosition()] = true;
						devolverCaminoExceptuando(destino.getPosition(), ciudad2, ciudades, resultado,camino, marcados);
						marcados[destino.getPosition()] = false;
					}
				}
			}
			camino.remove(camino.size()-1);
		}
	}
	
	public static List<String> caminoMasCorto(String ciudad1, String ciudad2){
		boolean[] marcados = new boolean[mapaCiudades.getSize()];
		List<String> resultado = new LinkedList<String>();
		List<String> camino = new LinkedList<String>();
		int distancia = 0;
		int maximo = Integer.MAX_VALUE;
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if(origen != null) {
			marcados[origen.getPosition()] = true;
			caminoMasCorto(origen.getPosition(), ciudad2, marcados,resultado,camino,distancia, maximo);
		}
		return resultado;
	}
	
	private static void caminoMasCorto (int i,String ciudad2,boolean[] marcados,List<String> resultado, List<String> camino, int distancia, int maximo) {
		Vertex<String> act = mapaCiudades.getVertex(i);
		camino.add(act.getData());
		//System.out.println(camino);
		if(act.getData().equals(ciudad2) && distancia< maximo) {
			resultado.removeAll(resultado);
			resultado.addAll(camino);
			maximo = distancia;
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(act);
			for(Edge<String> a: ady) {
				Vertex<String> destino = a.getTarget();
				if(!marcados[destino.getPosition()]) {
					distancia += a.getWeight();
					marcados[destino.getPosition()] = true;
					caminoMasCorto(destino.getPosition(), ciudad2, marcados, resultado, camino, distancia, maximo);
					marcados[destino.getPosition()] = false;
					distancia -= a.getWeight();
				}
			}
		}
		camino.remove(camino.size()-1);
	}
	
	public static List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		boolean[] marcados = new boolean[mapaCiudades.getSize()];
		List<String> resultado = new LinkedList<String>();
		List<String> act = new LinkedList<String>();
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if(origen != null) {
			marcados[origen.getPosition()] = true;
			caminoSinCargarCombustible(origen.getPosition(),ciudad2,tanqueAuto,resultado,act,marcados);
		}
		return resultado;
	}
	
	private static void caminoSinCargarCombustible(int i, String ciudad2,int tanqueAuto,List<String> resultado,List<String> lista, boolean[] marcados) {
		Vertex<String> v = mapaCiudades.getVertex(i);
		lista.add(v.getData());
		if(ciudad2.equals(v.getData())) {
			resultado.removeAll(resultado); // devuelvo el ultimo que encontre 
			resultado.addAll(lista);
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(v);
			for(Edge<String> a: ady) {
				if(tanqueAuto - a.getWeight() >= 0) {		//supongo el peso de la arista como lo que se gasta en ir
					Vertex<String> destino = a.getTarget();
					if(!marcados[destino.getPosition()]) {
						tanqueAuto -= a.getWeight();
						marcados[destino.getPosition()] = true;
						caminoSinCargarCombustible(destino.getPosition(), ciudad2, tanqueAuto, resultado, lista, marcados);
						marcados[destino.getPosition()] = false;
						tanqueAuto += a.getWeight();
					}
				}
			}
		}
		lista.remove(lista.size()-1);
	}
	
	public static List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		boolean[]marcas = new boolean[mapaCiudades.getSize()];
		List<String> resultado = new ArrayList<String>();
		List<String> camino = new LinkedList<String>();
		int contador = 0;
		int maximo = Integer.MAX_VALUE;
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		if(origen != null) {
			marcas[origen.getPosition()] = true;
			caminoConMenorCargaDeCombustible(origen.getPosition(),ciudad2,tanqueAuto,tanqueAuto,marcas,resultado,camino,contador,maximo);
		}
		return resultado;
	}
	
	private static void caminoConMenorCargaDeCombustible(int i,String ciudad2,int tanqueActual, int tanqueMaximo,boolean[] marcas, List<String> resultado, List<String> camino, int contador,int maximo) {
		Vertex<String> act = mapaCiudades.getVertex(i);
		camino.add(act.getData());
		if(act.getData() == ciudad2 && contador< maximo) {
			resultado.removeAll(resultado);
			resultado.addAll(camino);
			maximo = contador;
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(act);
			for(Edge<String> a: ady) {
				Vertex<String> destino = a.getTarget();
				if(!marcas[destino.getPosition()]) {
					marcas[destino.getPosition()] = true;
					if(a.getWeight()> tanqueActual) {
						tanqueActual = tanqueMaximo;
						contador ++;
						//System.out.println("Cargue para ir a " + destino.getData() + " desde " + act.getData());
					}
					tanqueActual -= a.getWeight();
					caminoConMenorCargaDeCombustible(destino.getPosition(), ciudad2, tanqueActual, tanqueMaximo, marcas, resultado, camino, contador, maximo);
					marcas[destino.getPosition()] = false;
					tanqueActual += a.getWeight();
				}
			}
		}
		camino.remove(camino.size()-1);
	}
	public static void main(String[] args) {
		 Vertex<String> v1 = mapaCiudades.createVertex("Buenos Aires");
		 Vertex<String> v2 = mapaCiudades.createVertex("Santiago");
		 Vertex<String> v3 = mapaCiudades.createVertex("Asunción");
		 Vertex<String> v4 = mapaCiudades.createVertex("Caracas");
		 Vertex<String> v5 = mapaCiudades.createVertex("Madrid");
		 Vertex<String> v6 = mapaCiudades.createVertex("Paris");
		 Vertex<String> v7 = mapaCiudades.createVertex("Tokio");
		 Vertex<String> v8 = mapaCiudades.createVertex("Roma");
		 //Vertex<String> v9 = mapaCiudades.createVertex("Berlin");
		 mapaCiudades.connect(v1, v2,3); //"Buenos Aires", "Santiago"
		 mapaCiudades.connect(v1, v3,6); //"Buenos Aires", "Asunción"
		 mapaCiudades.connect(v3, v4,2); // Asuncion ,Caracas
		 mapaCiudades.connect(v4, v5,2); // Caracas Madrid
		 mapaCiudades.connect(v3, v5,10); // Asuncion Madrid
		 mapaCiudades.connect(v2, v8,4); // Santiago Roma
		 mapaCiudades.connect(v6, v8,4); // Paris Roma
		 mapaCiudades.connect(v6, v7,35); // Paris tokio
		 mapaCiudades.connect(v4, v7,20); // Caracas Tokio
		 mapaCiudades.connect(v8, v7,80); // Roma Tokio
		 mapaCiudades.connect(v7, v1,10); // Tokio Buenos Aires
		 mapaCiudades.connect(v5, v7,60); // Madrid Tokio
		 mapaCiudades.connect(v6, v5,65); // Paris Madrid
		 
		 List<String> excepto = new LinkedList<String>();
		 //excepto.add("Buenos Aires");
		 excepto.add("Asunción");
		 //System.out.print(devolverCaminoExceptuando("Buenos Aires", "Tokio",excepto));
		 
		 System.out.print(caminoConMenorCargaDeCombustible("Buenos Aires", "Tokio",60));

	}

}
