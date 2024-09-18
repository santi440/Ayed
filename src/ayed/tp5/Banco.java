package ayed.tp5;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;
import ayed.tp1.ejercicio8.Queue;
import java.util.*;

public class Banco {

	public static List<String> recorridoPorNivel(Graph<Persona> grafo,Persona empleado, int distancia){
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		boolean[] marcados = new boolean[grafo.getSize()];
		List<String> lista = new ArrayList<String>();
		Vertex<Persona> origen = grafo.search(empleado);
		int actual = -1;
		if(origen != null) {
			cola.enqueue(origen);
			marcados[origen.getPosition()] = true;
			cola.enqueue(null);
			
			while(!cola.isEmpty() && actual < distancia) {
				//System.out.print(cola);
				Vertex<Persona> v = cola.dequeue();
				if(v != null) {
					if(!v.getData().esEmpleado() && lista.size()<40) {
						lista.add(v.getData().getNombre());
					}
					List<Edge<Persona>> ady = grafo.getEdges(v);
					for (Edge<Persona> a: ady) {
						Vertex<Persona> destino = a.getTarget();
						marcados[destino.getPosition()] = true;
						cola.enqueue(destino);
					}
				}
				else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						actual++;
					}
				}
			}
		}
		return lista;
	}
	public static void main(String[] args) {
		Graph<Persona> personas = new AdjListGraph<Persona>();

		Vertex<Persona> p1 = personas.createVertex(new Persona("Alice", "Empleado", "Calle 1"));
		Vertex<Persona> p2 = personas.createVertex(new Persona("Bob", "Jubilado", "Calle 2"));
		Vertex<Persona> p3 = personas.createVertex(new Persona("Charlie", "Empleado", "Calle 3"));
		Vertex<Persona> p4 = personas.createVertex(new Persona("Diana", "Jubilado", "Calle 4"));
		Vertex<Persona> p5 = personas.createVertex(new Persona("Edward", "Jubilado", "Calle 5"));
		Vertex<Persona> p6 = personas.createVertex(new Persona("Fiona", "Jubilado", "Calle 6"));
		Vertex<Persona> p7 = personas.createVertex(new Persona("George", "Jubilado", "Calle 7"));
		Vertex<Persona> p8 = personas.createVertex(new Persona("Hannah", "Jubilado", "Calle 8"));
		Vertex<Persona> p9 = personas.createVertex(new Persona("Ian", "Jubilado", "Calle 9"));
		Vertex<Persona> p10 = personas.createVertex(new Persona("Jane", "Jubilado", "Calle 10"));
		Vertex<Persona> p11 = personas.createVertex(new Persona("Kevin", "Empleado", "Calle 11"));
		Vertex<Persona> p12 = personas.createVertex(new Persona("Laura", "Jubilado", "Calle 12"));

		// Conexiones entre personas (unidireccionales)
		personas.connect(p1, p2, 10); // Alice -> Bob
		personas.connect(p2, p3, 15); // Bob -> Charlie
		
		personas.connect(p3, p4, 20); // Charlie -> Diana
		personas.connect(p4, p5, 25); // Diana -> Edward
		personas.connect(p5, p6, 30); // Edward -> Fiona
		personas.connect(p3, p7, 35); // Charlie -> George
		personas.connect(p7, p8, 40); // George -> Hannah
		personas.connect(p8, p9, 45); // Hannah -> Ian
		personas.connect(p9, p10, 50); // Ian -> Jane
		personas.connect(p10, p11, 55); // Jane -> Kevin
		personas.connect(p11, p12, 60); // Kevin -> Laura
		personas.connect(p12, p1, 65); // Laura -> Alice
		
		System.out.println(recorridoPorNivel(personas,new Persona("Charlie", "Empleado", "Calle 3") , 2));
	}

}
