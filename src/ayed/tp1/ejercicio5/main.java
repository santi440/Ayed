/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed.tp1.ejercicio5;


public class main {
    
private static Datos global = new Datos();

public static Datos conReturn (int[] v){
    Datos info = new Datos();
    for (int i= 0; i< v.length; i++){
        if(info.getMax()< v[i]){
            info.setMax(v[i]);
        }
        if(info.getMin()> v[i]){
            info.setMin(v[i]);
        }
        info.setPromedio(info.getPromedio()+v[i]);
    }
    info.setPromedio(info.getPromedio()/v.length);
    return info;
}
    
public static Datos conParametro (int[] v, Datos info){
    for (int i= 0; i< v.length; i++){
        if(info.getMax()< v[i]){
            info.setMax(v[i]);
        }
        if(info.getMin()> v[i]){
            info.setMin(v[i]);
        }
        info.setPromedio(info.getPromedio()+v[i]);
    }
    info.setPromedio(info.getPromedio()/v.length);
    return info;
}

public static void AtadoDeManos (int[] v){
    for (int i= 0; i< v.length; i++){
        if(global.getMax()< v[i]){
            global.setMax(v[i]);
        }
        if(global.getMin()> v[i]){
            global.setMin(v[i]);
        }
        global.setPromedio(global.getPromedio()+v[i]);
    }
    global.setPromedio(global.getPromedio()/v.length);
}

    public static void main(String[] args) {
       int[] arreglo = new int[10];
       for (int i= 0; i<10; i++){
           arreglo[i]=i;
       }
       System.out.println(conReturn(arreglo).toString());
       Datos info= new Datos();
       System.out.println(conParametro(arreglo, info).toString());
       AtadoDeManos(arreglo);
       System.out.println(global.toString());
    }
    
}
