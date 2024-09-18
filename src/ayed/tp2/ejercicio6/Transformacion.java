package tp2.ejercicio6;
import tp2.ejercicio1.*;
public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> a) {
		arbol = a;
	}
	
	public BinaryTree<Integer> suma(){
		sumarHijos(arbol);
		return arbol;
	}
	
	public int sumarHijos(BinaryTree<Integer> nodo) {
		int L, R, act;
		L = nodo.hasLeftChild() ? sumarHijos(nodo.getLeftChild()) : 0;
		R = nodo.hasRightChild() ? sumarHijos(nodo.getRightChild()) : 0;
		act = nodo.getData();
		nodo.setData(L+R);
		return L+R+act;
	}
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<Integer>(4);
		a.addLeftChild(new BinaryTree<>(2));
		a.addRightChild(new BinaryTree<>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<>(4));
		a.getLeftChild().addRightChild(new BinaryTree<>(5));
		a.getRightChild().addLeftChild(new BinaryTree<>(6));
		a.getRightChild().addRightChild(new BinaryTree<>(7));
		Transformacion T = new Transformacion(a);
		T.arbol.entreNiveles(0, 2 );
		T.suma();
		T.arbol.entreNiveles(0, 2);
	}
}
