package ayed.tp1.ejercicio7;
import java.util.*;
import ayed.tp1.ejercicio3.Estudiante;
//import ayed.tp1.ejercicio7.EjercicioSucesion;
public class TestArrayList {

	public static void incisoD () {
		List<Estudiante> estudiantes = new ArrayList();
		estudiantes.add(new Estudiante("Jacinta","Mandala","3a","jacinta@gmail.com","Los tuertos 213"));
		estudiantes.add(new Estudiante("Nacho","pa lala","3b","n@gmail.com","Los mancos 123"));
		estudiantes.add(new Estudiante("Franco","anda","3c","f@gmail.com","Los aromos 456"));
		List<Estudiante> estudiantes2 = new ArrayList();
		estudiantes2 = estudiantes;
		for (Estudiante i : estudiantes) {
			System.out.println(i.tusDatos());
		}
		System.out.println("------------------------");
		for (Estudiante i : estudiantes2) {
			System.out.println(i.tusDatos());
		}
		
		System.out.println("------------------------");
		estudiantes2.set(0, new Estudiante("Jazmin","Mandala","3a","jacinta@gmail.com","Los tuertos 213"));
		for (Estudiante i : estudiantes) {
			System.out.println(i.tusDatos());
		}
		System.out.println("------------------------");
		for (Estudiante i : estudiantes2) {
			System.out.println(i.tusDatos());
		}
		
		//Si se copia la lista, los punteros apuntan al mismo alumno, se cambia en 1 (cualquiera) y el otro tamb se modifica
		
		//otras maneras de copiar es con addAll(), pasando el original como parametro o con clone(), todas les pasa lo mismo con modificar
		
		Estudiante e=new Estudiante("Jazmin","Mandala","3a","jacinta@gmail.com","Los tuertos 213");
		//estudiantes.add(e);  // si no sobreescribi el equals de estudiante
		//contains compara direcciones de memoria (equals)
		if(!(estudiantes.contains(e))) {
			estudiantes.add(e);
		}
		System.out.println("------------------------");
		for (Estudiante i : estudiantes) {
			System.out.println(i.tusDatos());
		}
	}
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		for (int i = 0; i< (int)lista.size()/2;i++) {
			if(lista.get(i) != lista.get(lista.size()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public  static void invertirArrayList(ArrayList<Integer> lista, int inicio, int fin) {
        if (inicio < fin) {
            int temp = lista.get(inicio);
            lista.set(inicio, lista.get(fin));
            lista.set(fin, temp);

            invertirArrayList(lista, inicio + 1, fin - 1);
        }
    }
    public static int sumarLinkedList(LinkedList<Integer> lista, Iterator iterador ){
        if(iterador.hasNext()){
            iterador.next();
            return sumarLinkedList(lista, iterador) + 1;
        }
        else{
            return 0;
        }
    }
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
        Iterator i1 = lista1.iterator();
        Iterator i2 = lista2.iterator();
        ArrayList<Integer> nuevo = new ArrayList(); 
        Integer temp1 = i1.hasNext() ? (int)i1.next(): null;
        Integer temp2 = i2.hasNext() ? (int)i2.next(): null;
        
        while(temp1 != null || temp2 != null){
            if(temp1 != null && temp2 != null && (temp1 <= temp2)){
                nuevo.add(temp1);
                temp1 = i1.hasNext() ? (int)i1.next(): null;
            }
            else if (temp2 != null){
                nuevo.add(temp2);
                temp2 = i2.hasNext() ? (int)i2.next() : null;
            }
        }
        return nuevo;
    }

	
	public static void main(String[] args) {
		
		//Con arrayList
		List<Integer> arreglo = new ArrayList();
		for (String i: args) {
			arreglo.add(Integer.valueOf(i));
		}
		
		//Imprimir cada valor 
		for (Integer i: arreglo) {
			System.out.println(i);
		}
		
		System.out.println("-----------------------------------------");
		//Con linked list
		List<Integer> lista = new LinkedList();
		for (String i: args) {
			lista.add(Integer.valueOf(i));
		}
		
		//Imprimir cada valor 
		for (Integer i: lista) {
			System.out.println(i);
		}
		//Otras alternativas para recorrer puede ser un for a size, o un iterator
		
		//incisoD();
		//System.out.println(esCapicua((ArrayList)arreglo));
		List<Integer> sucedido = new LinkedList();
		EjercicioSucesion.calcularSucesion(6, sucedido);
		System.out.println("------------------------");
		for (Integer i : sucedido) {
			System.out.println(i);
		}
		
		ArrayList<Integer> vector = new ArrayList();
        ArrayList<Integer> lista2 = new ArrayList();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        lista2.add(7);
        lista2.add(8);
        vector.add(9);
        lista2.add(10);
        lista2.add(15);
        lista2.add(123);
        for (int i: combinarOrdenado(vector, lista2)){
            System.out.println(i);
        }
        
        Iterator i= vector.iterator();
        invertirArrayList((ArrayList)vector, 0, vector.size()-1);
        // System.out.println(sumarLinkedList(vector, i));
        System.out.println(vector.size());
        for (Integer e: vector){
            System.out.println(e);
		
	}
	}
}
