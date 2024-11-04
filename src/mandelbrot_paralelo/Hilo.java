/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mandelbrot_paralelo;


import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 * Clase Hilo donde se define lo que le corresponderá a cada hilo, se declara como una subclase de Thread
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class Hilo extends Thread {
    
    final static int tam= 5025;
    final static int maximo= 30;
    static int[][] dimension = new int[tam][tam];
    int numhilo;
    /**
     * constructor para la creacion de hilos
     * @param numhilo identificacion para saber de que hilo se trata
     */
    public Hilo(int numhilo) {
        this.numhilo = numhilo;
    }
    
     
    /**
     * Metodo que especifica lo que le corresponderá hacer cada hilo cuando inicia
     */   
    public void run(){
        int inicio=0, fin=0;
        if(numhilo==1){
            inicio=0;
            fin=(tam/4)*1;
        }
        else if(numhilo==2){
            inicio=(tam/4)*1;
            fin=(tam/4)*2;
        }
        else if(numhilo==3){
            inicio=(tam/4)*2;
            fin=(tam/4)*3;
        }
        else if(numhilo==4){
            inicio=(tam/4)*3;
            fin=tam;
        }
        for(int i=inicio;i<fin;i++){
            for(int j=0;j<tam;j++){
                double aux1=(4.0*i-2*tam)/tam;
                double aux2=(4.0*j-2*tam)/tam;
                double aux3=aux1;
                double aux4=aux2;
                int cont=0;
                while(cont<maximo&& aux3*aux3+aux4*aux4<4.0){
                    double forma1= aux1+aux3*aux3-aux4*aux4;
                    double forma2= aux2+2*aux3*aux4;
                    aux3=forma1;
                    aux4=forma2;
                    cont++;
                } 
                dimension[i][j]=cont;
                        
            }
        }
    }

    
    
}

