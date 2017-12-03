package OpcPlanificador;

import java.util.ArrayList;
import proyectodepoo1par.Materias;
import proyectodepoo1par.Principal;
import proyectodepoo1par.ReadWriter;


//Declaracion de la clase

/**
 * Clase Horario
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class Horario {

    //Declaracion de atributos
        
    /**
     * variable privada lineasCurso: Almacenara las lineas del archivo "curso.txt"
     */
    private ArrayList<ArrayList<String>> lineasCurso = null;
    
    /**
     * variable privada lineasRegistro: Almacenara las lineas del archivo "registro.txt"
     */
    private ArrayList<ArrayList<String>> lineasRegistro = null;
    
    /**
     * variable privada op_materias: Almacenara la opcion de materia ingresa por 
     * el usuario
     */
    private int op_materias;
    
    /**
     * variable privada contador: Sera usada como contador en el metodo planificador
     */
    private int contador=0;
    
    /**
     * variable private arr: Almacena en un array de objetos las materias
     * de la clase enum Materias
     */
    private Object[] arr = Materias.values();        //Materias en array
    
    
    //Declaracion de metodos
    
    /**
     * Metodo planificador: permite leer el archivo curso.txt
     * y de acuerdo la opcion de materia que ingresa el usuario obtener la 
     * materia del arreglo lineasCurso 
     * objecto archivo de la clase ReadWriter 
     */
    public void planificador() {

        ReadWriter archivo = new ReadWriter();
        
        lineasCurso = archivo.leerArchivo("cursos.txt");
        lineasRegistro = archivo.leerArchivo("registro.txt");
        
        //
        op_materias = new Principal().eligirMateria();
        System.out.println("\n");
        
        //Cuenta cuantos alumnos hay en esa clase
        for (ArrayList<String> linea : lineasRegistro) {
           if (linea.get(3).equals(arr[op_materias - 1].toString())) {
               contador ++;
           }
        }
        lineasRegistro.clear();
    }

    /**
     * Metodo toString: muestra el mensaje de acuerdo al valor del contador op
     * @return "Sus datos se han guardado correctamente" si el usuario ingreso "S"
     * o "No se han gurdado sus datos" ssi el usuario ingreso "N"
     */
    @Override
    public String toString() {
        for (ArrayList<String> linea : lineasCurso) {
            if (linea.get(0).equals(arr[op_materias - 1].toString())) {
                return ("MATERIAS: " + linea.get(0) + "\nPROFESOR: " + linea.get(1) + "\nHORARIO: "+linea.get(2)+", "+linea.get(3)+"\nREGISTRADOS: "+contador);
            }
        }
        return ("Esta materia no posee curso asignado.");
    }
}
