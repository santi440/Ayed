package ayed.tp3.ejercicio5;

import ayed.tp3.ejercicio1.*;

public class testDeEsAncestro {

	public static void main(String[] args) {
			GeneralTree<Integer> root = new GeneralTree<Integer> (1);

	        // Nivel 1;
		 	GeneralTree<Integer> child1 = new GeneralTree<Integer>(13);
		 	GeneralTree<Integer> child2 = new GeneralTree<Integer>(25);
		 	GeneralTree<Integer> child3 = new GeneralTree<Integer>(10);
	        root.addChild(child1);
	        root.addChild(child2);
	        root.addChild(child3);

	        // Nivel 2;
	        GeneralTree<Integer> child1_1 = new GeneralTree<Integer>(19);
	        GeneralTree<Integer> child1_2 = new GeneralTree<Integer>(12);
	        GeneralTree<Integer> child1_3 = new GeneralTree<Integer>(9);
	        child1.addChild(child1_1);
	        child1.addChild(child1_2);
	        child1.addChild(child1_3);

	        GeneralTree<Integer> child2_1 = new GeneralTree<Integer>(18);
	        GeneralTree<Integer> child2_2 = new GeneralTree<Integer>(10);
	        GeneralTree<Integer> child2_3 = new GeneralTree<Integer>(6);
	        child2.addChild(child2_1);
	        child2.addChild(child2_2);
	        child2.addChild(child2_3);

	        GeneralTree<Integer> child3_1 = new GeneralTree<Integer>(5);
	        GeneralTree<Integer> child3_2 = new GeneralTree<Integer>(7);
	        GeneralTree<Integer> child3_3 = new GeneralTree<Integer>(4);
	        child3.addChild(child3_1);
	        child3.addChild(child3_2);
	        child3.addChild(child3_3);
	        
	        System.out.print(root.esAncestro(25,18));
	}

}
