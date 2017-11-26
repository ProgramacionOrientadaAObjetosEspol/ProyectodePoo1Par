package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class Horario {

    Scanner t = new Scanner(System.in);
    private ArrayList<ArrayList<String>> lineasCurso = new ArrayList<>();
    private ArrayList<ArrayList<String>> lineasRegistro = new ArrayList<>();
    private int op_materias,contador=0;
    private Object[] arr = Materias.values();        //Materias en array
    
    public void planificador() {

        ReadWriter archivo = new ReadWriter();
        
        lineasCurso = archivo.leerArchivo("cursos.txt");
        lineasRegistro = archivo.leerArchivo("registro.txt");
        
        //Materias
        System.out.println("\n/** MATERIAS **/ \n");
        int n = 1;
        for (Object i : arr) {
            System.out.println(n + ". " + i);
            n++;
        }
        System.out.print("Elija una materia del listado de materias: ");
        op_materias = t.nextInt();
        t.nextLine();
        System.out.println("\n");
        
        //Cuenta cuantos alumnos hay en esa clase
        for (ArrayList<String> linea : lineasRegistro) {
           if (linea.get(3).equals(arr[op_materias - 1].toString())) {
               contador ++;
           }
        }
    }

    @Override
    public String toString() {
        for (ArrayList<String> linea : lineasCurso) {
            if (linea.get(0).equals(arr[op_materias - 1].toString())) {
                return ("MATERIAS: " + linea.get(0) + "\nPROFESOR: " + linea.get(1) + "\nHORARIO: "+linea.get(2)+", "+linea.get(3)+"\nREGISTRADOS: "+contador);
            }
        }
        return "";
    }
}
