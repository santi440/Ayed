/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed.tp1.ejercicio5;

/**
 *
 * @author Administrador
 */
public class Datos {
    private int max = -99999;
    private int min = 99999;
    private double promedio = 0.0;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public String toString() {
        return "Datos" + "max=" + max + ", min=" + min + ", promedio=" + promedio;
    }
}
