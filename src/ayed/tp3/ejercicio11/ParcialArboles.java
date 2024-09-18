package ayed.tp3.ejercicio11;

import ayed.tp3.ejercicio1.GeneralTree;

import java.util.List;

import ayed.tp1.ejercicio8.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if(arbol != null && !arbol.isEmpty()) {
			Queue<GeneralTree<Integer>> cola =  new Queue<GeneralTree<Integer>>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			Integer cant = 0;
			Integer nivel = 1;
			while(!cola.isEmpty()) {
				GeneralTree<Integer> act = cola.dequeue();
				if(act != null) {
					cant ++;
					List<GeneralTree<Integer>> hijos = act.getChildren();
					for (GeneralTree<Integer> i: hijos) {
						cola.enqueue(i);
					}
				}
				else {
					if(!cola.isEmpty()) {
						cola.enqueue(act);
						if(cant != nivel) {
							return false;
						}
						nivel++;
						cant = 0;
					}
				}
			}
			if(cant == nivel) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo1 =new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo2 =new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo4 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo5 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo6 =new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo9 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo10 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo11 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo12 =new GeneralTree<Integer>(0);
		
		
		
		arbol.addChild(hijo1);
		arbol.addChild(hijo2);
		
		hijo1.addChild(hijo4);
		hijo1.addChild(hijo5);
		hijo2.addChild(hijo6);
		
		hijo4.addChild(hijo9);
		hijo4.addChild(hijo10);
		hijo4.addChild(hijo11);
		hijo4.addChild(hijo12);
		
		System.out.print(resolver(arbol));

	}

}
