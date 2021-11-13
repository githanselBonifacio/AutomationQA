
package traductor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main {
 
    public static void main(String[] args) {
        OperacionesTexto opt = new OperacionesTexto("./archivos/diccionario.txt");
        JOptionPane.showMessageDialog(null,"Bienvenido a nuestro diccionario de ingles");
        try {
           
            while(true){
        
                String palabra = JOptionPane.showInputDialog("Ingrese la palagra que quiera traducir");
                if(opt.ConsultarPalabra(palabra).isEmpty()){
                    JOptionPane.showMessageDialog(null,"Esta palabra no se encuentra en nuestro diccionario");
                    JOptionPane.showMessageDialog(null,opt.Leer()); 
                    int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar esta palabra al diccionario?");
                    if(respuesta ==0){
                        String clave =  JOptionPane.showInputDialog("Escriba la palabra en español: ");
                        String valor = JOptionPane.showInputDialog("Escriba su traducción al ingles: ");
                        opt.AgregarPalabra(clave, valor);
                        JOptionPane.showMessageDialog(null,"Palabra agregada con exito!! ");
                        respuesta = JOptionPane.showConfirmDialog(null,"Desea traducir otra palabra?"); 
                        if(respuesta == 1){
                            JOptionPane.showMessageDialog(null,"gracias por usar el diccionario");
                            break;
                             }
                        
                    }else{
                        respuesta = JOptionPane.showConfirmDialog(null,"Desea consultar otra palabra?");
                        if(respuesta == 0){
                               continue;
                        }else{
                                JOptionPane.showMessageDialog(null,"gracias por usar el diccionario");
                                break;
                        }
                    }        
                    
                }else{
                    JOptionPane.showMessageDialog(null,palabra + " en ingles se dice "+opt.ConsultarPalabra(palabra));
                    int respuestaOp2 = JOptionPane.showConfirmDialog(null,"Desea traducir otra palabra?"); 
                    if(respuestaOp2 == 1){
                         JOptionPane.showMessageDialog(null,"gracias por usar el diccionario");
                         break;
                     }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
