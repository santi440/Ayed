package ayed.tp3.ejercicio8;

import java.util.List;

import ayed.tp3.ejercicio1.GeneralTree;

public class Navidad {
	
	static GeneralTree<Integer> abeto;
	
	public static String esAbetoNavidenio() {
		return esAbetoNavidenio(abeto);
	}
	
	private static String esAbetoNavidenio(GeneralTree<Integer> act) {
		List<GeneralTree<Integer>> hijos = act.getChildren();
		int cant = 0;
		boolean corte = false;
		for (GeneralTree<Integer> i: hijos) {
			if(i.isLeaf()) {
				cant++;
			}
			else {
				if(esAbetoNavidenio(i) == "no") {
					corte = true;
					break;
				}
			}
		}
		if(cant < 3 || corte) {
			return "no";
		}
		return "yes";
	}
	
	public static void main(String[] args) {
		abeto = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo1 =new GeneralTree<Integer>(2);
		GeneralTree<Integer> hijo2 =new GeneralTree<Integer>(3);
		GeneralTree<Integer> hijo3 =new GeneralTree<Integer>(4);
		GeneralTree<Integer> hijo4 =new GeneralTree<Integer>(5);
		GeneralTree<Integer> hijo5 =new GeneralTree<Integer>(6);
		GeneralTree<Integer> hijo6 =new GeneralTree<Integer>(7);
		GeneralTree<Integer> hijo7 =new GeneralTree<Integer>(8);
		
		abeto.addChild(hijo1);
		abeto.addChild(hijo2);
		abeto.addChild(hijo3);
		abeto.addChild(hijo4);
		
		hijo1.addChild(hijo5);
		hijo1.addChild(hijo6);
		hijo1.addChild(hijo7);
		
		System.out.print(esAbetoNavidenio());
	}

}
