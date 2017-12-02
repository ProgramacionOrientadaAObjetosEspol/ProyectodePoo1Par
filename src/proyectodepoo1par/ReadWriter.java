package proyectodepoo1par;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWriter {
    
    //Metodos    
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