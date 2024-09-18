package ayed.tp3.ejercicio9;

import java.util.List;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> nodo = cola.dequeue();
			if(nodo != null) {
				Integer minimo = Integer.MAX_VALUE;
				if(nodo.isLeaf()) {
					minimo = nodo.getData();
				}
				else {
					List<GeneralTree<Integer>> hijos = nodo.getChildren();
					for (GeneralTree<Integer> i: hijos){
						minimo =Math.min(minimo, i.getData());
						cola.enqueue(i);
					}
				}
				if(minimo != nodo.getData()) {
					return false;
				}
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(nodo);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo1 =new GeneralTree<Integer>(2);
		GeneralTree<Integer> hijo2 =new GeneralTree<Integer>(3);
		GeneralTree<Integer> hijo3 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo4 =new GeneralTree<Integer>(5);
		GeneralTree<Integer> hijo5 =new GeneralTree<Integer>(2);
		GeneralTree<Integer> hijo6 =new GeneralTree<Integer>(7);
		GeneralTree<Integer> hijo7 =new GeneralTree<Integer>(7);
		
		arbol.addChild(hijo1);
		arbol.addChild(hijo2);
		arbol.addChild(hijo3);
		arbol.addChild(hijo4);
		
		hijo1.addChild(hijo5);
		hijo1.addChild(hijo6);
		
		hijo6.addChild(hijo7);
		
		System.out.print(esDeSeleccion(arbol));
	}
}
