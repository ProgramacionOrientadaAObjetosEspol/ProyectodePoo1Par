package proyectodepoo1par;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriter {
    
    //Metodos    
    public ArrayList<ArrayList<String>> leerArchivo(String nombre){
        ArrayList<ArrayList<String>> list_lineas = new ArrayList<>();

        // Fichero del que queremos leer
        File archivo = new File(nombre);
        File fichero = new File(archivo.getAbsolutePath()); 
        Scanner s = null;
        String linea; 
        try {
            // Leemos el contenido del fichero
            s = new Scanner(fichero); 
            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                ArrayList<String> list_palabras = new ArrayList<>();
                //linea leida
                linea = s.nextLine();
                //linea separada
                String[] separa = linea.split("[\\,]");
                for(String var: separa){
                    list_palabras.add(var);
                }
                list_lineas.add(list_palabras);  // guardamos la linea
            }
            s.close();  //cerramos
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return list_lineas;
    }
    
    public void sobreEscribirArchivo(ArrayList<ArrayList<String>> lineas, String nombre){
	FileWriter fichero = null;
        File archivo = new File(nombre);
	try {
            fichero = new FileWriter(archivo.getAbsolutePath());
            // Escribimos linea a linea en el fichero
            for (ArrayList<String> linea : lineas) {
                    String oracion="";
                    int a = linea.size(),n=0;
                    for (String palabra : linea) {
                        n++;
                        if(n<a){
                            oracion+=palabra+",";
                        }else{
                            oracion+=palabra;
                        }
                    }
                    fichero.write(oracion + "\n");
		}
            fichero.close();    //cerramos
            } catch (Exception ex) {
        	System.out.println("Mensaje: " + ex.getMessage());
            }
    }
    
    public void AgregarAlArchivo(ArrayList<String> linea, String nombre){
	FileWriter fichero = null;
        File archivo = new File(nombre);
	try {
            fichero = new FileWriter(archivo.getAbsolutePath(),true);
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
            } catch (Exception ex) {
        	System.out.println("Mensaje: " + ex.getMessage());
            }
    }
}