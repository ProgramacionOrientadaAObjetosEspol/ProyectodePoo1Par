
package OpcEstudiante;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;


public class Planificacion {
    Scanner t = new Scanner(System.in);
    private ArrayList<ArrayList<String>> lineasCurso = new ArrayList<>();
    private int op_materias=0;
    //Materias en array
        Object[] arr = Materias.values();    
        
    public void planificar(){
        
        ReadWriter archivo = new ReadWriter();
        lineasCurso = archivo.leerArchivo("cursos.txt");
       
        //Materias
        System.out.println("\n/** CURSOS PLANIFICADOS **/ \n");
        int n = 1;
        for (Object i : arr) {
            System.out.println(n + ". " + i);
            n++;
        }
        System.out.print("Elija una materia del listado de materias: ");
        op_materias = t.nextInt();
        t.nextLine();
        System.out.println("\n");
        
    }
    
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
