package ayed.tp3.ejercicio4;
import java.util.LinkedList;
import java.util.List;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp3.ejercicio1.*;

public class AnalizadorArbol {

	public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int nivel= 0;
		int total = 0;
		int cant = 0;
		double promedio = 0;
		while (!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> actual = cola.dequeue();
			if ((actual != null)) {
				cant++;
				total+= actual.getData().getTiempo();
				List<GeneralTree<AreaEmpresa>> hijos = new LinkedList<GeneralTree<AreaEmpresa>>();
				hijos = actual.getChildren();
				for (GeneralTree<AreaEmpresa> i: hijos) {
					cola.enqueue(i);
				}
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					System.out.println("nivel " + nivel + " promedio = " + total/cant);
					promedio = Math.max(promedio, total/cant);
					cant = 0;
					total = 0;
					nivel++;
					}
				}
			}
		System.out.println("nivel " + nivel + " promedio = " + total/cant);
		promedio = Math.max(promedio, total/cant);
		return promedio;
	}
	public static void main(String[] args) {
		// Crear la raíz
        GeneralTree<AreaEmpresa> root = new GeneralTree<AreaEmpresa>(new AreaEmpresa(14, "A"));

        // Nivel 1
        GeneralTree<AreaEmpresa> child1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(13, "A"));
        GeneralTree<AreaEmpresa> child2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(25, "A"));
        GeneralTree<AreaEmpresa> child3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(10, "A"));
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        // Nivel 2
        GeneralTree<AreaEmpresa> child1_1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(19, "A"));
        GeneralTree<AreaEmpresa> child1_2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(12, "A"));
        GeneralTree<AreaEmpresa> child1_3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(9, "A"));
        child1.addChild(child1_1);
        child1.addChild(child1_2);
        child1.addChild(child1_3);

        GeneralTree<AreaEmpresa> child2_1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(18, "A"));
        GeneralTree<AreaEmpresa> child2_2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(10, "A"));
        GeneralTree<AreaEmpresa> child2_3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(6, "A"));
        child2.addChild(child2_1);
        child2.addChild(child2_2);
        child2.addChild(child2_3);

        GeneralTree<AreaEmpresa> child3_1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(5, "A"));
        GeneralTree<AreaEmpresa> child3_2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(7, "A"));
        GeneralTree<AreaEmpresa> child3_3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa(4, "A"));
        child3.addChild(child3_1);
        child3.addChild(child3_2);
        child3.addChild(child3_3);
        
        System.out.print(devolverMaximoPromedio(root));
	}

}
