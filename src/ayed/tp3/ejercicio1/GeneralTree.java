package ayed.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ayed.tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if(this.isEmpty()) {
			return -1;
		}
		if(this.isLeaf()) {
			return 0;
		}
		
		int alt = 0;
		List<GeneralTree<T>> hijos = new ArrayList<GeneralTree<T>>();
		hijos = this.getChildren();
		for (GeneralTree<T> i: hijos) {
			alt = Math.max(alt, i.altura());
		}
		
		return alt +1;
		
	}
	
	public int nivel(T dato){
		if(this.getData() == dato) {
			return 1;
		}
		if(this.isLeaf()) {
			return -1;
		}
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel= 1;
		//System.out.println("nivel " + nivel);
		while (!cola.isEmpty()) {
			GeneralTree<T> actual = cola.dequeue();
			if ((actual != null)) {
				if(actual.getData() == dato) {
					return nivel;
				}
				List<GeneralTree<T>> hijos = new LinkedList<GeneralTree<T>>();
				hijos = actual.getChildren();
				for (GeneralTree<T> i: hijos) {
					cola.enqueue(i);
				}
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(actual);
					nivel++;
					//System.out.println("nivel " + nivel);
					}
				}
			}
		return -1;
		}
	
	public int ancho(){
		if (this.isEmpty()) {
			return 0;
		}
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		//int nivel= 1;
		int cantActual = 0;
		int cantMax = 0;
		//System.out.println("nivel " + nivel);
		while (!cola.isEmpty()) {
			GeneralTree<T> actual = cola.dequeue();
			if ((actual != null)) {
				List<GeneralTree<T>> hijos = new LinkedList<GeneralTree<T>>();
				hijos = actual.getChildren();
				for (GeneralTree<T> i: hijos) {
					cola.enqueue(i);
					cantActual++; 
				}
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(actual);
					//nivel++;
					cantMax = Math.max(cantActual, cantMax);
					cantActual = 0;
					//System.out.println("nivel " + nivel);
					}
				}
			}
		return cantMax;
	}
	
	public boolean esAncestro(T a, T b) {
		GeneralTree<T> ancestro = estaNum(a);
		if( ancestro != null) {
				return ancestro.estaDescendiente(b);
		}
		return false;
	}
	
	private GeneralTree<T> estaNum (T a) {
		if(this.isEmpty()) {
			return null;
		}
		//estoy en el
		if (this.getData() == a) {
			return this;
		}
		//busco hijos
		List<GeneralTree<T>> hijos = new LinkedList<GeneralTree<T>>();
		hijos = this.getChildren();
		GeneralTree<T> nodo;
		for (GeneralTree<T> i: hijos) {
			 nodo  = i.estaNum(a); 
			 if (nodo != null) {
				 return nodo;
			 }
		}
		//retorno null si ninguna se cumplio 
		return null;
	}
	
	private	boolean estaDescendiente (T b) {
		if(this.isEmpty()) {
			return false;
		}
		//estoy en el
		if (this.getData() == b) {
			return true;
		}
		//busco hijos
		List<GeneralTree<T>> hijos = new LinkedList<GeneralTree<T>>();
		hijos = this.getChildren();
		boolean nodo;
		for (GeneralTree<T> i: hijos) {
			 nodo  = i.estaDescendiente(b); 
			 if (nodo) {
				 return true;
			 }
		}
		//retorno null si ninguna se cumplio 
		return false;
	}
	
}