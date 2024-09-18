package ayed.tp5;

import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;
public class VisitaOslo {

	public static List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		boolean[] marcados = new boolean[lugares.getSize()];
		List<String> resultado = new ArrayList<String>();
		List<String> camino = new ArrayList<String>();
		Vertex<String> origen = lugares.search("Ayuntamiento");
		if(origen != null && lugares.search(destino)!= null) {
			System.out.println("ENTRE1");
			marcados[origen.getPosition()] = true;
			paseoEnBici(lugares,origen.getPosition(),destino,maxTiempo,lugaresRestringidos,marcados,resultado,camino);
		}
		return resultado;
	}
		
	private static void paseoEnBici (Graph<String> lugares, int i, String destino, int maxTiempo, List<String> lugaresRestringidos,boolean[] marcados, List<String> resultado, List<String> camino) {
		Vertex<String> act = lugares.getVertex(i);
		System.out.println(act.getData());
		if((lugaresRestringidos.indexOf(act.getData()) == -1) && (resultado.isEmpty())){
			System.out.println("ENTRE");
			camino.add(act.getData());
			if(act.getData() == destino && resultado.isEmpty()) {
				resultado.addAll(camino);
			}
			else {
				List<Edge<String>> ady = lugares.getEdges(act);
				for(Edge<String> a: ady) {
					Vertex<String> v = a.getTarget();
					if(!marcados[v.getPosition()]) {
						maxTiempo -= a.getWeight();
						marcados[v.getPosition()] = true;
						paseoEnBici(lugares, v.getPosition(), destino, maxTiempo, lugaresRestringidos, marcados, resultado, camino);
						marcados[v.getPosition()] = false;
						maxTiempo += a.getWeight();
					}
				}
			}
			camino.remove(camino.size()-1);
		}
	}

	public static void main(String[] args) {
		Graph<String> lugares = new AdjListGraph<String>();
		Vertex<String> v1 = lugares.createVertex("Holmenkollen");
		Vertex<String> v2 = lugares.createVertex("Parque Vigeland");
		Vertex<String> v3 = lugares.createVertex("FolkMuseum");
		Vertex<String> v4 = lugares.createVertex("Museo Fram");
		Vertex<String> v5 = lugares.createVertex("Museo del Barco Polar");
		Vertex<String> v6 = lugares.createVertex("Museo Vikingo");
		Vertex<String> v7 = lugares.createVertex("Galería Nacional");
		Vertex<String> v8 = lugares.createVertex("Palacio Real");
		Vertex<String> v9 = lugares.createVertex("Ayuntamiento");
		Vertex<String> v10 = lugares.createVertex("Akker Brigge");
		Vertex<String> v11 = lugares.createVertex("Parque Botánico");
		Vertex<String> v12 = lugares.createVertex("Museo Munch");
		Vertex<String> v13 = lugares.createVertex("El Tigre");
		Vertex<String> v14 = lugares.createVertex("La Opera");
		Vertex<String> v15 = lugares.createVertex("Fortaleza Akershus");
		
		
		//no especifica direccion lo hice bidireccional, es fuertemente conexo
		lugares.connect(v1, v2, 30); // Holmenkollen - Parque Vigeland
		lugares.connect(v2, v1, 30); // Parque Vigeland - Holmenkollen

		lugares.connect(v2, v3, 20); // Parque Vigeland - FolkMuseum
		lugares.connect(v3, v2, 20); // FolkMuseum - Parque Vigeland

		lugares.connect(v3, v4, 5);  // FolkMuseum - Museo Fram
		lugares.connect(v4, v3, 5);  // Museo Fram - FolkMuseum

		lugares.connect(v4, v5, 5);  // Museo Fram - Museo del Barco Polar
		lugares.connect(v5, v4, 5);  // Museo del Barco Polar - Museo Fram

		lugares.connect(v3, v6, 5);  // FolkMuseum - Museo Vikingo
		lugares.connect(v6, v3, 5);  // Museo Vikingo - FolkMuseum

		lugares.connect(v6, v10, 30); // Museo Vikingo - Akker Brigge
		lugares.connect(v10, v6, 30); // Akker Brigge - Museo Vikingo

		lugares.connect(v6, v9, 20); // Museo Vikingo - Ayuntamiento
		lugares.connect(v9, v6, 20); // Ayuntamiento - Museo Vikingo

		lugares.connect(v10, v9, 20); // Akker Brigge - Ayuntamiento
		lugares.connect(v9, v10, 20); // Ayuntamiento - Akker Brigge

		lugares.connect(v9, v8, 5);  // Ayuntamiento - Palacio Real
		lugares.connect(v8, v9, 5);  // Palacio Real - Ayuntamiento

		lugares.connect(v8, v7, 5);  // Palacio Real - Galería Nacional
		lugares.connect(v7, v8, 5);  // Galería Nacional - Palacio Real

		lugares.connect(v7, v11, 15); // Galería Nacional - Parque Botánico
		lugares.connect(v11, v7, 15); // Parque Botánico - Galería Nacional

		lugares.connect(v11, v12, 1); // Parque Botánico - Museo Munch
		lugares.connect(v12, v11, 1); // Museo Munch - Parque Botánico

		lugares.connect(v12, v13, 15); // Museo Munch - El Tigre
		lugares.connect(v13, v12, 15); // El Tigre - Museo Munch

		lugares.connect(v13, v14, 5); // El Tigre - La Opera
		lugares.connect(v14, v13, 5); // La Opera - El Tigre

		lugares.connect(v14, v15, 10); // La Opera - Fortaleza Akershus
		lugares.connect(v15, v14, 10); // Fortaleza Akershus - La Opera
		 
		 List<String> excepto = new LinkedList<String>();
		 excepto.add("Akker Brigge");
		 excepto.add("Palacio Real");
		 System.out.print(paseoEnBici(lugares, "Museo Vikingo", 120, excepto));
	}
}
