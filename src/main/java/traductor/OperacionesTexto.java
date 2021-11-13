
package traductor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OperacionesTexto {
    private String ruta;

    public OperacionesTexto(String ruta) {
        this.ruta = ruta;
    }
    
    
    public String ConsultarPalabra(String palabra) throws IOException {

        FileReader fileReader= null;
        BufferedReader bufferedReader=null;
        String temp = "";
        String traduccion ="";
        try {
            fileReader = new FileReader(ruta);
            bufferedReader = new BufferedReader(fileReader);
            while(temp != null){
                    temp = bufferedReader.readLine();
                    
                    if (temp != null){
                        if(temp.split(";")[0].equals(palabra)){
                            traduccion = temp.split(";")[1]; 
                        }
                    }else{
                       break;
                    }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e);
        } catch (IOException e) {
            System.out.println("no pudo leer el archivo " + e);
        }finally {
            fileReader.close();
            bufferedReader.close();
        }        
        return traduccion;
    }
 
    public String Leer() throws IOException {

        FileReader fileReader= null;
        BufferedReader bufferedReader=null;
        String temp = "";
        String texto="Las palabras de nuestro diccionario son: \n";
        try {
                fileReader = new FileReader(ruta);
                bufferedReader = new BufferedReader(fileReader);
                
                texto+= "\n"+String.format("%11s%16s%n","Español","Ingles")+"\n";
                while(temp != null){
                    temp = bufferedReader.readLine();
                    if (temp!= null){
                        String clave = temp.split(";")[0];
                        String valor = temp.split(";")[1];
                        String resultado = String.format("%10s %5s%10s",clave,"||",valor);
                        texto += resultado+"\n";
                        //texto += clave +"    ||    "+valor +"\n";
                    }else{
                        break;
                    }
                }
                System.out.println(texto);
        } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado: " + e);
        } catch (IOException e) {
                System.out.println("no pudo leer el archivo " + e);
        }finally {
            fileReader.close();
            bufferedReader.close();
        }
        return texto;
    }
    
    public void AgregarPalabra (String palabra,String traduccion ) throws IOException{
        FileWriter fileWriter = null;
        
        try {
            
            fileWriter = new FileWriter(ruta,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(palabra+";"+traduccion);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesTexto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        fileWriter.close();
        
        }
        
    }
}
