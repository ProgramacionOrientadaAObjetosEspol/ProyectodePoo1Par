package proyectodepoo1par;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


//Declaracion de la clase

/**
 * Clase ReadWriter 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class ReadWriter {
    
    //Declaracion de metodos 
    
     /**
     * Metodo leerArchivo: Encargado de leer el archivo que se desea haciendo uso
     * de la direccion, ademas se utliza el metodo try/catch para evitar algun
     * error debido al uso de archivos, en caso de que lo haya lo mostrara en un 
     * mensaje con el tipo de error
     * @param nombre almacena el nombre del usuario
     * @return lista de lineas del archivo leido
     */
  
    public ArrayList<ArrayList<String>> leerArchivo(String nombre){
        ArrayList<ArrayList<String>> list_lineas = new ArrayList<>();

        File f = new File("");
        String dire = f.getAbsolutePath();
        String direccion = dire.substring(0,dire.indexOf("ProyectodePoo1Par")+17)+"\\doc\\"+nombre;
        File fichero = new File(direccion);
        
        try {
            String linea;
            // Leemos el contenido del fichero
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            // Leemos linea a linea el fichero
            while ((linea = br.readLine()) != null) {       //linea leida
                ArrayList<String> list_palabras = new ArrayList<>();
                
                //linea separada
                String[] separa = linea.split("[\\,]");
                for(String var: separa){
                    list_palabras.add(var);
                }
                list_lineas.add(list_palabras);             //guardamos la linea
            }
            br.close();                                     //cerramos
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return list_lineas;
    }
    
    /**
     * Metodo leerArchivo: Encargado de sobreescribir el archivo que se desea haciendo uso
     * de la direccion, ademas se utliza el metodo try/catch para evitar algun
     * error debido al uso de archivos, en caso de que lo haya lo mostrara en un 
     * mensaje con el tipo de error
     * @param nombre almacena el nombre del usuario
     * @param lineas almancena las lineas del archivo leido
     */
    public void sobreEscribirArchivo(ArrayList<ArrayList<String>> lineas, String nombre){
	File f = new File("");
        String dire = f.getAbsolutePath();
        String direccion = dire.substring(0,dire.indexOf("ProyectodePoo1Par")+17)+"\\doc\\"+nombre;
        
	try {
            FileWriter fichero = new FileWriter(direccion);
            
            // Escribimos linea a linea en el fichero
            for (ArrayList<String> linea : lineas) {
                String oracion="";
                int a = linea.size(),n=0;
                for (String palabra : linea) {
                    n++;
                    if(n<a){
                        oracion+=palabra+",";
                    }else{
                        oracion+=palabra + "\n";
                    }
                }
                fichero.write(oracion);
            }
            fichero.close();    //cerramos
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
    
    /**
     * Metodo AgregarAlArchivo: Encargado de agregar el archivo que se desea haciendo uso
     * de la direccion, ademas se utliza el metodo try/catch para evitar algun
     * error debido al uso de archivos, en caso de que lo haya lo mostrara en un 
     * mensaje con el tipo de error
     * @param nombre almacena el nombre del usuario
     * @param linea almancena las lineas del archivo leido
     */
    public void AgregarAlArchivo(ArrayList<String> linea, String nombre){
        File f = new File("");
        String dire = f.getAbsolutePath();
        String direccion = dire.substring(0,dire.indexOf("ProyectodePoo1Par")+17)+"\\doc\\"+nombre;
        
        //File archivo = new File(nombre);
	try {
            FileWriter fichero = new FileWriter(direccion,true);
            int a = linea.size(),n=0;
            String oracion="";
            
            for (String palabras : linea) {
                n++;
                if(n<a){
                    oracion+=palabras+",";
                }else{
                    oracion+=palabras;
                }
            }
            fichero.write(oracion + "\n");    // Escribimos la linea en el fichero
            fichero.close();    //cerramos
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
}