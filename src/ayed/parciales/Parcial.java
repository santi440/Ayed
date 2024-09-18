package ayed.parciales;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class Parcial {
	
	public static int resolver (Graph<recinto> sitios, int tiempo) {
		int cant = 0;
		if(sitios!=null && !sitios.isEmpty()) {
			List<Vertex<recinto>> vertices = sitios.getVertices();
			boolean encontre = false;
			int i = 0;
			Vertex<recinto> origen = null;
			while (i<vertices.size() && !encontre) {
				if(vertices.get(i).getData().getNombre() == "Entrada") {
					origen = vertices.get(i);
					encontre = true;
				}
				i++;
			}
			if(origen != null) {
				boolean[] visitados = new boolean[sitios.getSize()];
				cant = helper(origen,sitios,visitados,cant,tiempo);
			}
		}
		return cant;
	}
	
	private static int helper (Vertex<recinto> act, Graph<recinto> grafo, boolean[]visitados, int actu, int tiempo) {
		visitados[act.getPosition()] = true;
		tiempo -= act.getData().getTiempo();
		//System.out.println(act.getData().getNombre());
	    int max = actu;
	    if (tiempo >= 0) {
	    	max++;
	    	actu++;
	        List<Edge<recinto>> ady = grafo.getEdges(act);
	        for (Edge<recinto> e : ady) {
	            if (!visitados[e.getTarget().getPosition()] && tiempo - e.getWeight() >= 0) {
	                max = Math.max(max, helper(e.getTarget(), grafo, visitados, actu, tiempo - e.getWeight()));
	            }
	        }
	    }
		visitados[act.getPosition()] = false;
		return max;
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

		zoologico.connect(tortugas, pumas, 15); // Tortugas -> Pumas
		zoologico.connect(pumas, tortugas, 15); // Pumas -> Tortugas

		zoologico.connect(flamencos, murcielagos, 25); // Flamencos -> Murciélagos
		zoologico.connect(murcielagos, flamencos, 25); // Murciélagos -> Flamencos
		
		System.out.print(resolver(zoologico, 1000));
	}

}
