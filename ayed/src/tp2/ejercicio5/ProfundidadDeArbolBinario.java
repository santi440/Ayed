package tp2.ejercicio5;
import tp2.ejercicio1.*;
import tp1.Queue;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		arbol = a;
	}
	
	public int sumaElementosProfundidad (int p) {
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(arbol);
		
		int level = 0;
		int sum= 0;
		while (!cola.isEmpty()) {
			int tam = cola.size();
			for (int i= 0; i<tam ;i++) {
				BinaryTree<Integer> nodo = cola.dequeue();
				if(level == p) {
					sum = sum + nodo.getData();
				}
				if(nodo.hasLeftChild()) {
					cola.enqueue(nodo.getLeftChild());
				}
				if(nodo.hasRightChild()) {
					cola.enqueue(nodo.getRightChild());
				}
			}
			level++;
		}
		System.out.print("El total de la profundidad " + p + " es " + sum);
		return sum;
	}
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<Integer>(4);
		a.addLeftChild(new BinaryTree<>(2));
		a.addRightChild(new BinaryTree<>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<>(4));
		a.getLeftChild().addRightChild(new BinaryTree<>(5));
		a.getRightChild().addLeftChild(new BinaryTree<>(6));
		a.getRightChild().addRightChild(new BinaryTree<>(7));
		ProfundidadDeArbolBinario n = new ProfundidadDeArbolBinario(a);
		n.sumaElementosProfundidad(2);
	}
}
