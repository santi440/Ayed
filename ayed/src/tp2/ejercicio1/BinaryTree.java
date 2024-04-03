package tp2.ejercicio1;
import tp1.Queue;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cLeft = 0,cRight = 0;
		if (isEmpty()) return 0;
		else if (isLeaf())return 1;
		else {
			if(hasLeftChild()) {
				cLeft = getLeftChild().contarHojas();
			}
			if(hasRightChild()) {
				cRight = getRightChild().contarHojas();
			}
		}
		return cRight + cLeft;
	   
	}
		
    public BinaryTree<T> espejo(){
    	BinaryTree<T> nuevo = new BinaryTree<T>(getData());
    	if (hasLeftChild()) {
    		nuevo.addRightChild(getLeftChild().espejo());
    	}
    	if(hasRightChild()) {
    		nuevo.addLeftChild(getRightChild().espejo());
    	}   
    	return nuevo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this != null) {
			Queue<BinaryTree<T>> queue = new Queue<>();
        	queue.enqueue(this);
        
        	int level = 0;

        	while (!queue.isEmpty()) {
        		int size = queue.size(); // Tamaño de la cola en este nivel
            	if (level >=n) 
            		System.out.print("Nivel " + level + ": ");
            
            	for (int i = 0; i < size; i++) {
            		BinaryTree<T> current = queue.dequeue();
            		if(level>= n)
            			System.out.print(current.getData() + " ");

            		if (current.getLeftChild() != null) {
            			queue.enqueue(current.getLeftChild());
            		}
            		if (current.getRightChild() != null) {
            			queue.enqueue(current.getRightChild());
            		}
            	}
            	if (level>=n)
            		System.out.println(); // Salto de línea para separar niveles
            	level++; // Incrementar el nivel actual
            	if (level > m) break;
        	}
		}
	}
	
	public void imprimirArbol() {
        if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
        System.out.print(this.getData() + " ");
        if(this.hasRightChild()) this.getRightChild().imprimirArbol();
    }
		
}

