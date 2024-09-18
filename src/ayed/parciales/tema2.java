package ayed.parciales;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class tema2 {
	
	public static String resolver(Graph<recinto> sitios, int tiempo) {
		String retorna = "No Alcanzable";
		if(sitios != null && !sitios.isEmpty()) {
			List<Vertex<recinto>> vertices = sitios.getVertices();
			int i= 0;
			Vertex<recinto> origen = null;
			boolean encontre = false;
			while(i<vertices.size() && !encontre) {
				if(vertices.get(i).getData().getNombre().equals("Entrada")) {
					origen = vertices.get(i);
					encontre = true;
				}
				i++;
			}
			if(origen != null) {
				boolean[] visitados = new boolean[sitios.getSize()];
				int cant = 0;
				retorna = dfs(origen,sitios,visitados,tiempo,cant);
			}
		}
		return retorna;
	}
	
	private static String dfs ( Vertex<recinto> act, Graph<recinto> sitios, boolean[] visitado, int tiempo, int cant) {
		visitado[act.getPosition()] = true;
		tiempo -= act.getData().getTiempo();
		String corte = "No Alcanzable";
		if(tiempo >= 0) {
			cant++;
			if(cant == sitios.getSize()) {
				corte = "Alcanzable";
			}
			else {
				List<Edge<recinto>> ady = sitios.getEdges(act);
				int i = 0;
				while(i< ady.size() && !corte.equals("Alcanzable")) {
					Edge<recinto> conexion = ady.get(i);
					if(!visitado[conexion.getTarget().getPosition()] && tiempo - conexion.getWeight() >= 0) {
						corte = dfs(conexion.getTarget(),sitios,visitado,tiempo-conexion.getWeight(),cant);
					}
					i++;
				}
			}
		}
		visitado[act.getPosition()] = false;
		return corte;
	}

	public static void main(String[] args) {
		Graph<recinto> zoologico = new AdjListGraph<recinto>();

		// Creación de recintos
		Vertex<recinto> entrada = zoologico.createVertex(new recinto("Entrada", 15));
		Vertex<recinto> cebras = zoologico.createVertex(new recinto("Cebras", 10));
		Vertex<recinto> tigres = zoologico.createVertex(new recinto("Tigres", 10));
		Vertex<recinto> tortugas = zoologico.createVertex(new recinto("Tortugas", 10));
		Vertex<recinto> pumas = zoologico.createVertex(new recinto("Pumas", 10));
		Vertex<recinto> wallabies = zoologico.createVertex(new recinto("Wallabies", 30));
		Vertex<recinto> murcielagos = zoologico.createVertex(new recinto("Murciélagos", 20));
		Vertex<recinto> flamencos = zoologico.createVertex(new recinto("Flamencos", 10));

		// Conexiones entre recintos (unidireccionales)
		// Conexiones bidireccionales entre recintos
		zoologico.connect(entrada, cebras, 10); // Entrada -> Cebras
		zoologico.connect(cebras, entrada, 10); // Cebras -> Entrada

		zoologico.connect(entrada, tigres, 15); // Entrada -> Tigres
		zoologico.connect(tigres, entrada, 15); // Tigres -> Entrada

		zoologico.connect(entrada, murcielagos, 20); // Entrada -> Murciélagos
		zoologico.connect(murcielagos, entrada, 20); // Murciélagos -> Entrada

		zoologico.connect(entrada, flamencos, 25); // Entrada -> Flamencos
		zoologico.connect(flamencos, entrada, 25); // Flamencos -> Entrada

		zoologico.connect(cebras, tortugas, 5); // Cebras -> Tortugas
		zoologico.connect(tortugas, cebras, 5); // Tortugas -> Cebras

		zoologico.connect(tigres, cebras, 8); // Tigres -> Cebras
		zoologico.connect(cebras, tigres, 8); // Cebras -> Tigres

		zoologico.connect(murcielagos, wallabies, 10); // Murciélagos -> Wallabies
		zoologico.connect(wallabies, murcielagos, 10); // Wallabies -> Murciélagos

		zoologico.connect(tortugas, wallabies, 10); // Tortugas -> Wallabies
		zoologico.connect(wallabies, tortugas, 10); // Wallabies -> Tortugas
		
		zoologico.connect(wallabies, pumas, 2);
		zoologico.connect(pumas, wallabies, 2);

		zoologico.connect(tortugas, pumas, 15); // Tortugas -> Pumas
		zoologico.connect(pumas, tortugas, 15); // Pumas -> Tortugas

		zoologico.connect(flamencos, murcielagos, 25); // Flamencos -> Murciélagos
		zoologico.connect(murcielagos, flamencos, 25); // Murciélagos -> Flamencos
		
		System.out.print(resolver(zoologico,1));
	}

}
