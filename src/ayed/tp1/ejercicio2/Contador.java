/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed.tp1.ejercicio2;

import java.util.Scanner;

public class Contador {
    
    public static int contar42 ( ) {
        try (Scanner s = new Scanner(System.in)) {
			int cantidad = 1 ;
			while (s.nextInt() != 42) {
			    cantidad++;
			}
   return cantidad;
		}
    }
    
    public static int[] multiplos ( ) {
        try (Scanner s = new Scanner(System.in)) {
			int cantidad = 1 ;
			int dimension = s.nextInt();
			int[] arreglo = new int[dimension];
			for(int i= 0;i<dimension;i++){
			    arreglo[i]=cantidad * dimension;
			    cantidad++;
			}
   return arreglo;
		}
    }

    public static void main(String[] args) {
        //System.out.println(contar42());
        int[] v= multiplos(); 
        for(int i=0;i< v.length; i++){
            System.out.println(v[i]);
        }
    }
    
}
