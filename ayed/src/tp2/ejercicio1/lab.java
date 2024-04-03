package tp2.ejercicio1;
public class lab {

	public static void main(String[] args) {
		//int a = 10;
		//System.out.print(((Object)a).getClass().getName());
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		arbol.setData(1);
		arbol.addLeftChild(new BinaryTree<>(2));
		arbol.addRightChild(new BinaryTree<>(3));
		arbol.getLeftChild().addLeftChild(new BinaryTree<>(4));
		arbol.getLeftChild().addRightChild(new BinaryTree<>(5));
		arbol.getRightChild().addLeftChild(new BinaryTree<>(6));
		arbol.getRightChild().addRightChild(new BinaryTree<>(7));
		//arbol.entreNiveles(0, 2);
		
		BinaryTree<Integer> reverso = arbol.espejo();
		reverso.entreNiveles(0, 2);
		System.out.print(arbol.contarHojas());
		
	}

}
