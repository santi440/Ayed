package tp2.ejercicio4;

import tp2.ejercicio1.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> red;
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.red = a;
	}
	
	public int retardoReenvio() {
		return (!red.isEmpty()) ? retardoReenvio(red) : 0;
	}
	
	private int retardoReenvio(BinaryTree<Integer> red) {
		int Left = 0;
		int Right = 0;
		if(red.hasLeftChild()) {
			Left = retardoReenvio(red.getLeftChild());
		}
		if(red.hasRightChild()) {
			Right = retardoReenvio(red.getRightChild());
		}
		return Math.max(Left, Right) + red.getData();
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree<Integer>(4);
		a.addLeftChild(new BinaryTree<>(2));
		a.addRightChild(new BinaryTree<>(3));
		a.getLeftChild().addLeftChild(new BinaryTree<>(4));
		a.getLeftChild().addRightChild(new BinaryTree<>(5));
		a.getRightChild().addLeftChild(new BinaryTree<>(6));
		a.getRightChild().addRightChild(new BinaryTree<>(7));
		RedBinariaLlena r = new RedBinariaLlena(a);
		
		System.out.println(r.retardoReenvio());
	}
}
