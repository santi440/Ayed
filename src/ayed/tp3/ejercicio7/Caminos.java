package ayed.tp3.ejercicio7;

import java.util.LinkedList;
import java.util.List;

import ayed.tp3.ejercicio1.GeneralTree;

public class Caminos {
	
	static GeneralTree<Integer> arbol;
	
	 public static List<Integer> caminoAHojaMasLejana (){
		 List<Integer> camino = new LinkedList<>();
		 List<Integer> maximo = new LinkedList<>();
		 caminoAHojaMasLejana(arbol,camino,maximo);
		 return maximo;
	 }
	 
	 private static void caminoAHojaMasLejana(GeneralTree<Integer> a, List<Integer> camino, List<Integer> maximo) {
		 camino.add(a.getData());
		 if(a.isLeaf() && camino.size()> maximo.size()) {
			 maximo.removeAll(maximo);
			 maximo.addAll(camino);
		 }
		 else {
			 List<GeneralTree<Integer>> hijos = a.getChildren();
			 for (GeneralTree<Integer> i : hijos) {
				 caminoAHojaMasLejana(i, camino, maximo);
			 }
		 }
		 camino.remove(camino.size()-1);
	 }
	public static void main(String[] args) {
		arbol = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo1 =new GeneralTree<Integer>(2);
		GeneralTree<Integer> hijo2 =new GeneralTree<Integer>(3);
		GeneralTree<Integer> hijo3 =new GeneralTree<Integer>(4);
		GeneralTree<Integer> hijo4 =new GeneralTree<Integer>(5);
		GeneralTree<Integer> hijo5 =new GeneralTree<Integer>(6);
		GeneralTree<Integer> hijo6 =new GeneralTree<Integer>(7);
		GeneralTree<Integer> hijo7 =new GeneralTree<Integer>(8);
		
		arbol.addChild(hijo1);
		arbol.addChild(hijo2);
		arbol.addChild(hijo3);
		arbol.addChild(hijo4);
		
		hijo1.addChild(hijo5);
		hijo1.addChild(hijo6);
		
		hijo6.addChild(hijo7);
		
		System.out.print(caminoAHojaMasLejana());
		}

}
