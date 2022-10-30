/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1edd;

import interfaces.Home;

/**
 *
 * @author Daniela Gimenez
 */
public class Project1edd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int alto = 5;
        int ancho = 5;
        
        int totalNodos = alto*ancho;
        
        //Crea el grafo donde estaran los nodos
        Grafo grafoLista = new Grafo(totalNodos);
        
        //Te crea los nodos y asigna sus nombres/numeros
        for (int i = 1; i <= totalNodos; i++) {
            String nombre = Integer.toString(i);
            grafoLista.nuevoVertice(nombre);
        }
        
        //Crea las relaciones entre nodos 
        for (int i = 1; i <= grafoLista.tablAdc.length; i++) {
            if (i <= (totalNodos-ancho)) {
                String suma = Integer.toString(ancho+i);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, suma);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if (i > ancho) {
                String resta = Integer.toString(i-ancho);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, resta);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if (i%ancho != 0) {
                String suma = Integer.toString(i+1);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, suma);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if ((i-1)%3!=0) {
                String resta = Integer.toString(i-1);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, resta);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe" + numeroActual + resta);
                }
            }
        }
        
        
        for (int i = 0; i < grafoLista.tablAdc.length; i++) {
            System.out.println(grafoLista.tablAdc[i].toString());
            for (int j = 0; j < grafoLista.tablAdc[i].lad.size(); j++) {
                System.out.println(grafoLista.tablAdc[i].lad.get(j));
            }
        }
        
        //Para determinar entrada y salida del laberinto mediante un numero aleatorio
        int altoMin = alto - 2;
        int aleatorioEntrada = (int) (Math.random()*(((alto-1)-2)+1))+2;
        int aleatorioSalida = (int) (Math.random()*(((alto-1)-2)+1))+2;
        
        //son los numeros de los nodos de la entrada y la salida.
        int numeroNodoEntrada = (ancho * (aleatorioEntrada-1) ) +1;
        int numeroNodoSalida = (ancho * (aleatorioSalida-1) ) +1;
        //Falta incluir en los nodos que tipo de nodo es entrada, salida, pared camino
        
        
//        //Muestro Ventana del PreHome
//        Home ventana1 = new Home();
//        ventana1.setVisible(true);
    }
    
}
