/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1edd;

import java.util.LinkedList;

/**
 *
 * @author Daniela Gimenez, Abraham Castillo, Andrea Pinto
 */
public class Nodo {
    String nombre;
    int numVertice;
    LinkedList<Object> lad;
    
    
    public Nodo(String x) {
        nombre = x;
        numVertice = -1;
        lad = new LinkedList();
    }
    
    // Devuelve verdadero si dos vertices se llaman igual
    public boolean equals(Object d) {
        Nodo dos = (Nodo) d;
        return nombre.equals(dos.nombre);
    }
    
    // Indica el número que identificará este vértice
    public void asigVert(int n) {
        numVertice = n;
    }
    
    // Devuelve el nombre del vértice
    public String nomVertice() {
        return nombre;
    }
    
    // Imprime el nombre y número de vértice
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }
    
}
