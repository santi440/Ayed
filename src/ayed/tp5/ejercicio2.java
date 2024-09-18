package ayed.tp5;
import java.util.*;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class ejercicio2 {
	/*
	 public List<T> dfs(Graph<T> grafo) {
	        boolean[] marca = new boolean[grafo.getSize()];
	        List<T> lis = new LinkedList<T>(); 
	        for (int i = 0; i < grafo.getSize(); i++) {
	            if (!marca[i]) {
	                dfs(i, grafo, lis, marca);
	            }
	        }
	        return lis;
	    }
	    private void dfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
	        marca[i] = true;
	        Vertex<T> v = grafo.getVertex(i);
	        lis.add(v.getData());
	        List<Edge<T>> adyacentes = grafo.getEdges(v); 
	        for (Edge<T> e: adyacentes){
	            int j = e.getTarget().getPosition();
	            if (!marca[j]) {
	                dfs(j, grafo, lis, marca);
	            }
	        }
	    }

	    public List<T> bfs(Graph<T> grafo) {
	        boolean[] marca = new boolean[grafo.getSize()];
	        List<T> lis = new LinkedList<T>(); 
	        for (int i = 0; i < grafo.getSize(); i++) {
	            if (!marca[i]) {
	                bfs(i, grafo, lis, marca);
	            }
	        }
	        return lis;
	    }
	    
	    private void bfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
	        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
	        q.enqueue(grafo.getVertex(i));
	        marca[i] = true;
	        while (!q.isEmpty()) {
	            Vertex<T> w = q.dequeue();
	            lis.add(w.getData());
	            List<Edge<T>> adyacentes = grafo.getEdges(w);
	            for (Edge<T> e: adyacentes) {
	                int j = e.getTarget().getPosition();
	                if (!marca[j]) {
	                    marca[j] = true;
	                    q.enqueue(e.getTarget());
	                }
	            }
	        }
	    }
	    */
	public static LinkedList<LinkedList<String>> dfsConCosto(Graph<String> grafo) {
		 boolean[] marca = new boolean[grafo.getSize()];
		 LinkedList<String> lis = null;
		 LinkedList<LinkedList<String>> recorridos = new LinkedList<LinkedList<String>>();
		 int costo = 0;
		 for (int i=0; i<grafo.getSize(); i++) {
			 lis = new LinkedList<>();
			 lis.add(grafo.getVertex(i).getData().toString());
			 marca[i] = true;
			 dfsConCosto(i, grafo, lis, marca, costo, recorridos);
			 marca[i] = false;
		 	}
		 	return recorridos;
		 }
		 private static void dfsConCosto(int i, Graph<String> grafo, List<String> lis,boolean[] marca, int costo, LinkedList<LinkedList<String>> recorridos) {
			 Vertex<String> vDestino = null;
			 int p = 0, j = 0;
			 Vertex<String> v = grafo.getVertex(i);
			 List<Edge<String>> ady = grafo.getEdges(v);
			 for (Edge<String> e: ady) {
				 j= e.getTarget().getPosition();
				 if (!marca[j]) {
					 p = e.getWeight();
					 if ((costo + p) <= 10) {
						 vDestino = e.getTarget();
						 lis.add(vDestino.getData().toString());
						 marca[j] = true;
						 if ((costo+p) == 10)
							 recorridos.add(new LinkedList<String>(lis));
						 else
							 dfsConCosto(j, grafo, lis, marca, costo + p, recorridos);
						 lis.remove(vDestino.getData().toString());
						 marca[j] = false;
					 }
				 }
			 }
		 }
	public static void main(String[] args) {
		 Graph<String> ciudades = new AdjListGraph<>();
		 Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
		 Vertex<String> v2 = ciudades.createVertex("Santiago");
		 Vertex<String> v3 = ciudades.createVertex("Asunción");
		 Vertex<String> v4 = ciudades.createVertex("Caracas");
		 Vertex<String> v5 = ciudades.createVertex("Madrid");
		 Vertex<String> v6 = ciudades.createVertex("Paris");
		 Vertex<String> v7 = ciudades.createVertex("Tokio");
		 Vertex<String> v8 = ciudades.createVertex("Roma");
		 ciudades.connect(v1, v2,3); //"Buenos Aires", "Santiago"
		 ciudades.connect(v1, v3,6); //"Buenos Aires", "Asunción"
		 ciudades.connect(v3, v4,2); // Asuncion ,Caracas
		 ciudades.connect(v4, v5,2); // Caracas Madrid
		 ciudades.connect(v3, v5,10); // Asuncion Madrid
		 ciudades.connect(v2, v8,4); // Santiago Roma
		 ciudades.connect(v8, v6,4); // Roma Paris
		 ciudades.connect(v7, v6,35); // Tokio Paris
		 ciudades.connect(v4, v7,20); // Caracas Tokio
		 ciudades.connect(v8, v7,80); // Roma Tokio
		 ciudades.connect(v1, v7,10); // Buenos Aires Tokio
		 ciudades.connect(v5, v7,60); // Madrid Tokio
		 ciudades.connect(v5, v6,65); // Paris Madrid
		 
		 //LinkedList<String> a = dfs(ciudades);
		 //System.out.println(a);

	}

}
