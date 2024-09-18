package tp2.ejercicio7;
import tp2.ejercicio1.*;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> a) {
		arbol = a;
	}
	
	public boolean isLeftTree (int num) {
		BinaryTree<Integer> nodo = buscar(num,arbol);
		if (nodo == null) {
			return false;
		}
		else {
			int L = nodo.hasLeftChild() ? recorrer(nodo.getLeftChild()) : -1;
			int R = nodo.hasRightChild() ? recorrer(nodo.getRightChild()) : -1;
			System.out.println(L);
			System.out.println(R);
			return L > R;
		}
	}
	
	private BinaryTree<Integer> buscar(int num, BinaryTree<Integer> nodo){
		if(nodo.getData() != num) {
			if(nodo.hasLeftChild()) {
				return buscar(num, nodo.getLeftChild());
			}
			if(nodo.hasRightChild()) {
				return buscar(num, nodo.getRightChild());
			}
			return null;
		}
		else
			return nodo;
	}
	
	private int recorrer(BinaryTree<Integer> nodo) {
		if((nodo.hasLeftChild()) && (!nodo.hasRightChild())) {
			return recorrer(nodo.getLeftChild()) + 1;
		}
		else if ((nodo.hasRightChild()) && (!nodo.hasLeftChild())) {
			return recorrer(nodo.getRightChild()) + 1;
		}
		else if(nodo.hasRightChild() && nodo.hasLeftChild()) {
			return recorrer(nodo.getLeftChild()) + recorrer(nodo.getRightChild());
		}
		else
			return 0;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<Integer>(1);
		a.addLeftChild(new BinaryTree<>(2));
		a.addRightChild(new BinaryTree<>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<>(4));
		a.getLeftChild().addRightChild(new BinaryTree<>(5));
		a.getRightChild().addLeftChild(new BinaryTree<>(6));
		a.getRightChild().addRightChild(new BinaryTree<>(7));
		ParcialArboles p = new ParcialArboles(a);
		System.out.print(p.isLeftTree(1));
	}
}
