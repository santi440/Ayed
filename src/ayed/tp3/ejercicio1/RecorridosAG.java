package ayed.tp3.ejercicio1;
import java.util.*;
import ayed.tp1.ejercicio8.Queue;
public class RecorridosAG {

	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){ //cambio  firma agregando static para probar
		List<Integer> impar = new ArrayList<Integer>();
		if((a != null) && (!a.isEmpty())){
			PreOrden(impar,a,n);
		}
		return impar;
	}
	
	private static void PreOrden(List<Integer> impar,GeneralTree <Integer> a,Integer n){
		if((a.getData() % 2 != 0) && (a.getData() >= n)) {
			impar.add(a.getData());
		}
		List<GeneralTree<Integer>> hijos = new LinkedList<GeneralTree<Integer>>();
		hijos = a.getChildren();
		for (int i= 0; i < hijos.size(); i++){
			PreOrden(impar, hijos.get(i), n);
		}
		
	}
	
	public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> impar = new ArrayList<Integer>();
		if((a != null) && (!a.isEmpty())){
			InOrden(impar,a,n);
		}
		return impar;
	}
	
	private static void InOrden(List<Integer> impar,GeneralTree <Integer> a,Integer n){
		List<GeneralTree<Integer>> hijos = new LinkedList<GeneralTree<Integer>>();
		hijos = a.getChildren();
		if(hijos.size() > 0) {
			InOrden(impar, hijos.get(0), n);
		}
		
		if((a.getData() % 2 != 0) && (a.getData() >= n)) {
			impar.add(a.getData());
		}
		for (int i= 1; i<hijos.size(); i++){
			InOrden(impar, hijos.get(i), n);
		}
		
	}
	
	public static  List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> impar = new ArrayList<Integer>();
		if((a != null) && (!a.isEmpty())){
			PostOrden(impar,a,n);
		}
		return impar;
	}
	
	private static void PostOrden(List<Integer> impar,GeneralTree <Integer> a,Integer n){
		List<GeneralTree<Integer>> hijos = new LinkedList<GeneralTree<Integer>>();
		hijos = a.getChildren();
		for (GeneralTree<Integer> i:hijos){
			PostOrden(impar, i, n);
		}
		if((a.getData() % 2 != 0) && (a.getData() >= n)) {
			impar.add(a.getData());
		}
	}
	
	public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> impar = new ArrayList<Integer>();
		if((a != null) && (!a.isEmpty())){
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(a);
			cola.enqueue(null);
			int nivel= 1;
			System.out.println("nivel " + nivel);
			while (!cola.isEmpty()) {
				GeneralTree<Integer> actual = cola.dequeue();
				if ((actual == null) && (!cola.isEmpty())) {
					cola.enqueue(actual);
					nivel++;
					System.out.println("nivel " + nivel);
				}else {
					if(actual!= null) {
					if((actual.getData() % 2 != 0) && (actual.getData() >= n)) {
						impar.add(actual.getData());
					}
					List<GeneralTree<Integer>> hijos = new LinkedList<GeneralTree<Integer>>();
					hijos = actual.getChildren();
					for (GeneralTree<Integer> i: hijos) {
						cola.enqueue(i);
						}
					}
				}
			}
		}
		return impar;
	}


	public static void main(String[] args) {
		        // Crear la raíz
		        GeneralTree<Integer> root = new GeneralTree<>(1);

		        // Nivel 1
		        GeneralTree<Integer> child1 = new GeneralTree<>(2);
		        GeneralTree<Integer> child2 = new GeneralTree<>(3);
		        GeneralTree<Integer> child3 = new GeneralTree<>(4);
		        root.addChild(child1);
		        root.addChild(child2);
		        root.addChild(child3);

		        // Nivel 2
		        GeneralTree<Integer> child1_1 = new GeneralTree<>(5);
		        GeneralTree<Integer> child1_2 = new GeneralTree<>(6);
		        GeneralTree<Integer> child1_3 = new GeneralTree<>(7);
		        child1.addChild(child1_1);
		        child1.addChild(child1_2);
		        child1.addChild(child1_3);

		        GeneralTree<Integer> child2_1 = new GeneralTree<>(8);
		        GeneralTree<Integer> child2_2 = new GeneralTree<>(9);
		        GeneralTree<Integer> child2_3 = new GeneralTree<>(10);
		        child2.addChild(child2_1);
		        child2.addChild(child2_2);
		        child2.addChild(child2_3);

		        GeneralTree<Integer> child3_1 = new GeneralTree<>(11);
		        GeneralTree<Integer> child3_2 = new GeneralTree<>(12);
		        GeneralTree<Integer> child3_3 = new GeneralTree<>(13);
		        child3.addChild(child3_1);
		        child3.addChild(child3_2);
		        child3.addChild(child3_3);
		        
		        
		        List<Integer> lista = numerosImparesMayoresQuePorNiveles(root,1);
		        System.out.println("Elementos de la lista:");
		        for (Integer elemento : lista) {
		            System.out.println(elemento);
		        }
		        
		        System.out.println(root.nivel(6));
	}
}
