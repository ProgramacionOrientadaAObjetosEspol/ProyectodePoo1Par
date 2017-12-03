
package OpcEstudiante;

import java.util.ArrayList;
import proyectodepoo1par.Materias;
import proyectodepoo1par.Principal;
import proyectodepoo1par.ReadWriter;

//Declaracion de la clase
/**
 * Clase Planificacion 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */

public class Planificacion {     
    /*
     * variable privada lineasCurso: Array de array que contiene las lineas del documento curso.txt
    */ 
    private ArrayList<ArrayList<String>> lineasCurso = new ArrayList<>();
    
    /**
     * variable privada op_materias: Almacena el valor de la opcion de materia que escoja el usuario 
     */
    private int op_materias=0;
    
    /**
     * varaible array: Arreglo de materias del enum Materias 
     */
    Object[] arr = Materias.values();    
        
    //Declaracion de metodos 
    
    /**
     * Metodo planificar: permite leer el archivo curso.txt
     * y de acuerdo la opcion de materia que ingresa el usuario obtener la 
     * materia del arreglo lineasCurso 
     * objecto archivo de la clase ReadWriter 
     * variable lineasCurso: Almacena las lineas del archivo curso.txt
     */
    public void planificar(){
        
        ReadWriter archivo = new ReadWriter();
        lineasCurso = archivo.leerArchivo("cursos.txt");
        op_materias = new Principal().eligirMateria();
        System.out.println("\n");
    }
    
    /**
     * Metodo toString: permite devolver la informacion con el formato a continuacion 
     * @return "Materias", "Profesor","Horario" si la materia posee un curso asignado 
     * o el mensaje "Esta materia no posee curso asignado." si ocurre lo contrario
     */ 
    @Override
    public String toString() {
        for (ArrayList<String> linea : lineasCurso) {
            if (linea.get(0).equals(arr[op_materias-1].toString())) {
                return ("MATERIAS: " + linea.get(0) + "\nPROFESOR: " + linea.get(1) + "\nHORARIO: "+linea.get(2)+", "+linea.get(3));
            }
        }
        return ("Esta materia no posee curso asignado.");
    }
    
}
