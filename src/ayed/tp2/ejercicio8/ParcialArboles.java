package tp2.ejercicio8;
import tp1.Queue;
import tp2.ejercicio1.*;

public class ParcialArboles {
	
	public boolean esPrefijoNO(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean isPrefix = true;
		Queue<BinaryTree<Integer>> cola1 = new Queue<BinaryTree<Integer>>();
		Queue<BinaryTree<Integer>> cola2 = new Queue<BinaryTree<Integer>>();
		cola1.enqueue(arbol1);
		cola2.enqueue(arbol2);
		int level= 0;
		while(!cola1.isEmpty() && !cola2.isEmpty() && isPrefix) {
			int size = cola1.size() == cola2.size() ? cola1.size() : 0;
			int i= 0;
			while (i<size && isPrefix) {
				System.out.print("Nivel " + level +": ");
				BinaryTree<Integer> currentA1 = cola1.dequeue();
				BinaryTree<Integer> currentA2 = cola2.dequeue();
				if(currentA1.getData() == currentA2.getData()) {
					if(currentA1.hasLeftChild()== true == currentA2.hasLeftChild()) {
						cola1.enqueue(currentA1.getLeftChild());
						cola2.enqueue(currentA2.getLeftChild());
					}
					else isPrefix = false;
					if(currentA1.hasRightChild() == true == currentA2.hasRightChild()) {
						cola1.enqueue(currentA1.getRightChild());
						cola2.enqueue(currentA2.getRightChild());
					}
					else isPrefix = false;
				}
				System.out.print("Todo coincide. ");
				i++;
			}
			System.out.println();
			level++;
		}
		return isPrefix;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if(arbol1 == null) return true;
		if(arbol2 == null) return false;
		if(arbol1.getData() == arbol2.getData()) {
			boolean aux = true;
			if(arbol1.hasLeftChild() && !(arbol2.hasLeftChild())) 
				return false;
			else
				aux = aux && esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
			if(arbol1.hasRightChild() && !(arbol2.hasRightChild())) {
				return false;
			}
			else
				aux = aux && esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
			return aux;
		}
		else 
			return false;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arbol1 = new BinaryTree<>(1);
	    arbol1.addLeftChild(new BinaryTree<>(2));
	    arbol1.addRightChild(new BinaryTree<>(3));
	    //arbol1.getLeftChild().addRightChild(new BinaryTree<Integer>(4));

	    BinaryTree<Integer> arbol2 = new BinaryTree<>(1);
	    arbol2.addLeftChild(new BinaryTree<>(2));
	    arbol2.addRightChild(new BinaryTree<>(3));
	    arbol2.getLeftChild().addLeftChild(new BinaryTree<>(4));
		
		ParcialArboles p = new ParcialArboles();
		System.out.print(p.esPrefijo(arbol2, arbol1));

	}

}
