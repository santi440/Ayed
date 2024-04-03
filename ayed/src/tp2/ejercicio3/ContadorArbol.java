package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.*;
public class ContadorArbol {
	private BinaryTree<Integer> arbol = new BinaryTree<Integer>(); 
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public ArrayList<Integer> numerosParesA(){
		ArrayList<Integer> pares = new ArrayList<Integer>();
		if(!arbol.isEmpty()) {
			agregarIn(pares,arbol);
		}
		return pares;
	}
	
	private void agregarIn(ArrayList<Integer> pares,BinaryTree<Integer> nodo){
		if(nodo.hasLeftChild()) {
			agregarIn(pares,nodo.getLeftChild());
		}
		if(nodo.getData() != null) {
			if(nodo.getData() % 2 == 0)
				pares.add(nodo.getData());
		}
		if(nodo.hasRightChild()) {
			agregarIn(pares,nodo.getRightChild());
		}
	}
	
	private void agregarPost(ArrayList<Integer> pares,BinaryTree<Integer> nodo){
		if(nodo.hasLeftChild()) {
			agregarPost(pares,nodo.getLeftChild());
		}
		if(nodo.hasRightChild()) {
			agregarPost(pares,nodo.getRightChild());
		}
		if(nodo.getData() != null) {
			if(nodo.getData() % 2 == 0)
				pares.add(nodo.getData());
		}
}
	
	public ArrayList<Integer> numerosParesB(){
		ArrayList<Integer> pares = new ArrayList<Integer>();
		if(!arbol.isEmpty()) {
			agregarPost(pares,arbol);
		}
		return pares;
	}
	
	public static void main(String[] args) {
		System.out.println("Test numeros Pares");
        BinaryTree<Integer> a = new BinaryTree<Integer>(4);
		a.addLeftChild(new BinaryTree<>(2));
		a.addRightChild(new BinaryTree<>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<>(4));
		a.getLeftChild().addRightChild(new BinaryTree<>(5));
		a.getRightChild().addLeftChild(new BinaryTree<>(6));
		a.getRightChild().addRightChild(new BinaryTree<>(7));
		ContadorArbol c = new ContadorArbol(a);
		
		System.out.println("Test inOrden");
		ArrayList<Integer> pares = c.numerosParesA();
		for(int i:pares) {
			System.out.println(i);
		}
		
		System.out.println("Test PostOrden");
		ArrayList<Integer> pares2 = c.numerosParesB();
		for(int i:pares2) {
			System.out.println(i);
		}
		
	}
}
