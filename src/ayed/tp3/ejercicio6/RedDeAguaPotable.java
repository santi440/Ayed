package ayed.tp3.ejercicio6;

import java.util.List;

import ayed.tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	
	static GeneralTree<Character> arbol;
	
	public static double minimoCaudal(double caudal) {
		if((arbol == null) || (arbol.isEmpty())){
			return -1.0;
		}
		return minimoCaudal(arbol,caudal);
	}
	private static double minimoCaudal(GeneralTree<Character> a,double caudal) {
		if(a.isLeaf()) {
			return caudal;
		}
		List<GeneralTree<Character>> hijos = a.getChildren();
		Integer tamaño = hijos.size();
		Double minimo = Double.MAX_VALUE;
		for(GeneralTree<Character> i : hijos) {
			minimo = Math.min(minimo, minimoCaudal(i,caudal / tamaño));
		}
		return minimo;
	}
	public static void main(String[] args) {
		arbol = new GeneralTree<>('A');
        GeneralTree<Character> hijoB = new GeneralTree<>('B');
        GeneralTree<Character> hijoC = new GeneralTree<>('C');
        GeneralTree<Character> hijoD = new GeneralTree<>('D');
        GeneralTree<Character> hijoE = new GeneralTree<>('E');
        GeneralTree<Character> hijoF = new GeneralTree<>('F');
        
        arbol.addChild(hijoB);
        arbol.addChild(hijoC);
        arbol.addChild(hijoD);

        arbol.addChild(hijoE);
        hijoB.addChild(hijoF);
        
        System.out.println(minimoCaudal(1000.0));
	}

}
