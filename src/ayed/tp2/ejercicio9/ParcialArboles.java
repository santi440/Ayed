package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;


public class ParcialArboles {
	public BinaryTree<Totales> sumAndDif(BinaryTree<Integer> arbol){
		int sum = 0;
		return sumAndDifHelper(arbol,sum,0);
	}
	
	private BinaryTree<Totales> sumAndDifHelper(BinaryTree<Integer> arbol, int sum,int valorPadre ) {
		sum = sum + arbol.getData();
		BinaryTree<Totales> nuevo = new BinaryTree<Totales>(new Totales(sum,arbol.getData()-valorPadre));
		if(arbol.hasLeftChild()) {
			nuevo.addLeftChild(sumAndDifHelper(arbol.getLeftChild(),sum,arbol.getData()));
		}
		if(arbol.hasRightChild()) {
			nuevo.addRightChild(sumAndDifHelper(arbol.getRightChild(),sum,arbol.getData()));
		}
		return nuevo;
	}
	
	public void imprimir(BinaryTree<Totales> arbol1) {
		System.out.print(arbol1.toString() + "\n");
		if(arbol1.hasLeftChild()) imprimir(arbol1.getLeftChild());
        if(arbol1.hasRightChild()) imprimir(arbol1.getRightChild());
	}
	public static void main(String[] args) {
		BinaryTree<Integer> arbol1 = new BinaryTree<>(20);
	    arbol1.addLeftChild(new BinaryTree<>(5));
	    arbol1.addRightChild(new BinaryTree<>(30));
	    //arbol1.getLeftChild().addRightChild(new BinaryTree<Integer>(4));

	    
		ParcialArboles p = new ParcialArboles();
		p.imprimir((p.sumAndDif(arbol1)));
		

	}
}
