/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed.tp1.ejercicio3;

/**
 *
 * @author Administrador
 */
public class main {
    public main(String[] args) {
        Estudiante[] alumnos = new Estudiante[2];
        Profesor[] docentes = new Profesor[3];
        
        alumnos[0] = new Estudiante();
        alumnos[1] = new Estudiante();
        
        docentes[0] = new Profesor();
        docentes[1] = new Profesor();
        docentes[2] = new Profesor();
        
        alumnos[0].setNombre("Jacinto");
        alumnos[0].setApellido("Gonzales");
        alumnos[0].setEmail("jacintog@gmail.com");
        alumnos[0].setComision("3a");
        alumnos[0].setDireccion("Av 1 520");
        
        alumnos[1].setNombre("Rodrigo");
        alumnos[1].setApellido("Rodriguez");
        alumnos[1].setEmail("rodri@gmail.com");
        alumnos[1].setComision("4b");
        alumnos[1].setDireccion("Av 123 10");
        
        docentes[0].setApellido("Alvarez");
        docentes[0].setCatedra("CADP");
        docentes[0].setEmail("hzp@gmail.com");
        docentes[0].setFacultad("Informatica");
        docentes[0].setNombre("Jose");
        
        docentes[1].setApellido("Rivolta");
        docentes[1].setCatedra("Mate 2");
        docentes[1].setEmail("anita@gmail.com");
        docentes[1].setFacultad("Informatica");
        docentes[1].setNombre("Ana");
        
        docentes[2].setApellido("Bracken");
        docentes[2].setCatedra("Contabilidad");
        docentes[2].setEmail("ce@gmail.com");
        docentes[2].setFacultad("Exactas");
        docentes[2].setNombre("Cecilia");
        
        System.out.println(alumnos[0].tusDatos());
        System.out.println(alumnos[1].tusDatos());
        
        System.out.println(docentes[0].tusDatos());
        System.out.println(docentes[1].tusDatos());
        System.out.println(docentes[2].tusDatos());
    }
    
}
