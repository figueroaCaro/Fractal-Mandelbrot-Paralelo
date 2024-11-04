/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mandelbrot_paralelo;


/**
 * Clase principal del proyecto donde se forma el mandelbrot por medio de 4 hilos
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class Main {

    /**
     * Metodo principal con las instrucciones a realizar y la creacion de los hilos
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
       Long inicio=System.currentTimeMillis();
       Hilo thread1 = new Hilo(1);
       Hilo thread2 = new Hilo(2);
       Hilo thread3 = new Hilo(3);
       Hilo thread4 = new Hilo(4);
       
       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();
       thread1.join();
       thread2.join();
       thread3.join();
       thread4.join();
       
       Long fin=System.currentTimeMillis();
       System.out.println("Tiempo: "+((float)(fin-inicio)/1000)+" segundos");
       CrearImagen.crearImagen();
    }
    
}
