/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mandelbrot_paralelo;

import static mandelbrot_paralelo.Hilo.maximo;
import static mandelbrot_paralelo.Hilo.tam;
import static mandelbrot_paralelo.Hilo.dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *Clase que genera la imagen de extensión "png" y lle da color al mandelbrot
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class CrearImagen {
    /**
     * Metodo acomoda por medio de colores y genera la imagen en un archivo .png. UJsa atributos de la clase Hilo
     * @throws IOException 
     */
    public static void crearImagen() throws IOException{
        BufferedImage imagen = new BufferedImage(tam,tam,BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                int k=dimension[i][j];
                float posicion;
                Color color;
                if(k==(int)maximo-maximo/2 || k==(int)maximo-maximo/3){
                    color = new Color(251,152,252);
                }
                else if(k<maximo/5){
                    color = new Color(64,64,64);
                }else if(k<maximo/2){
                    posicion=(float)k/(maximo/2);
                    color = new Color(posicion,posicion,posicion);
                }                
                else if(k<maximo){
                    color = new Color(255,255,255);
                }
                else{
                    color= new Color(234,137,154);
                }
                imagen.setRGB(i,j,color.getRGB());
            }
        }
        ImageIO.write(imagen,"PNG", new File("Imagen.png"));
    }
}
