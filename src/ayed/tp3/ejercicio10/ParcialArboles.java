package ayed.tp3.ejercicio10;

import java.util.ArrayList;
import java.util.List;

import ayed.tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
	    if(arbol != null && !arbol.isEmpty()) {
	        List<Integer> max = new ArrayList<Integer>();
	        Integer value = 0;
	        List<Integer> act = new ArrayList<Integer>();
	        recorrerLista(arbol, act, max, value);
	        return max;
	    } else {
	        return null;
	    }
	}

	private static Integer recorrerLista(GeneralTree<Integer> a, List<Integer> act, List<Integer> max, Integer valor){
	    act.add(a.getData());
	    if(a.isLeaf()) {
	        Integer suma = 0;
	        for (int i = 0; i < act.size(); i++) {
	            suma += act.get(i) * i;
	        }
	        if(valor < suma) {
	            valor = suma;
	            max.removeAll(max);
	            for (Integer i : act) {
	                if(i == 1) {
	                    max.add(i);
	                }
	            }
	        }
	    } else {
	        List<GeneralTree<Integer>> hijos = a.getChildren();
	        for (GeneralTree<Integer> i : hijos) {
	            valor = recorrerLista(i, act, max, valor);
	        }
	    }
	    act.remove(act.size()-1);
	    return valor;
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo1 =new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo2 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo3 =new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo4 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo5 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo6 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo7 =new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo8 =new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> hijo9 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo10 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo11 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo12 =new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo13 =new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> hijo14 =new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo15 =new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo16 =new GeneralTree<Integer>(0);
		
		
		arbol.addChild(hijo1);
		arbol.addChild(hijo2);
		arbol.addChild(hijo3);
		
		hijo1.addChild(hijo4);
		hijo1.addChild(hijo5);
		hijo2.addChild(hijo6);
		hijo2.addChild(hijo7);
		hijo3.addChild(hijo8);
		
		hijo4.addChild(hijo9);
		hijo4.addChild(hijo10);
		hijo4.addChild(hijo11);
		hijo7.addChild(hijo12);
		hijo8.addChild(hijo13);
		
		hijo12.addChild(hijo14);
		hijo13.addChild(hijo15);
		hijo13.addChild(hijo16);
		
		for (Integer i :resolver(arbol)) {
			System.out.print(i + " ");
		}

	}

}
