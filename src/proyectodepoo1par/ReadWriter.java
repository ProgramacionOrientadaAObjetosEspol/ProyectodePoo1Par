package proyectodepoo1par;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriter {
//  Para poner en el principal
//  File fichero = new File("p1.txt");
//  fichero.getAbsolutePath() -> da la direccion
    
    
//    Recorrerlo
//    for(String linea: lect){
//        String[] separado = linea.split("\\.");
//        for(String palabra: separado){
//            System.out.print(palabra+" ");
//        }
//        System.out.println();
//    }
    
    public ArrayList<String> leerArchivo(String direccion){
        ArrayList<String> lineas = new ArrayList<>();
        // Fichero del que queremos leer
        File fichero = new File(direccion); 
        Scanner s = null;
        try {
            // Leemos el contenido del fichero
            s = new Scanner(fichero); 
            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                lineas.add(s.nextLine());  // guardamos la linea
            }
            s.close();  //cerramos
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return lineas;
    }
    
    public void sobreEscribirArchivo(ArrayList<String> lineas, String direccion){
	FileWriter fichero = null;
	try {
            fichero = new FileWriter(direccion);
            // Escribimos linea a linea en el fichero
            for (String linea : lineas) {
		fichero.write(linea + "\n");    //escribimos la linea en el fichero
            }
            fichero.close();    //cerramos
            } catch (Exception ex) {
        	System.out.println("Mensaje: " + ex.getMessage());
            }
    }
    
    public void AgregarAlArchivo(String linea, String direccion){
	FileWriter fichero = null;
	try {
            fichero = new FileWriter(direccion,true);
            fichero.write(linea + "\n");    // Escribimos la linea en el fichero
            fichero.close();    //cerramos
            } catch (Exception ex) {
        	System.out.println("Mensaje: " + ex.getMessage());
            }
    }
}
