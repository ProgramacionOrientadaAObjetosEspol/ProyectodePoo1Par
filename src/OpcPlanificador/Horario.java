package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class Horario {

    Scanner t = new Scanner(System.in);
    ArrayList<ArrayList<String>> lineasCurso = new ArrayList<>();
    ArrayList<ArrayList<String>> lineasRegistro = new ArrayList<>();
    
    
    public void planificador() {

        ReadWriter archivo = new ReadWriter();
        Object[] arr = Materias.values();        //Materias en array

        //variables
        int op_materias,contador=0;
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

        for (ArrayList<String> palabra : lineasRegistro) {
           if (palabra.get(3).equals(arr[op_materias - 1].toString())) {
               contador ++;
           }
        }
        for (ArrayList<String> linea : lineasCurso) {
            if (linea.get(0).equals(arr[op_materias - 1].toString())) {
                System.out.println("MATERIAS: " + linea.get(0) + "\n" + "PROFESOR: " + linea.get(1) + "\n" +"HORARIO: "+linea.get(2)+", "+linea.get(3)+"\n" +"REGISTRADOS: "+contador);
            }
        }
    }

//    @Override
//    public String toString() {
//        return ("MATERIAS: " + lineas.get(0) + "\n" + "PROFESOR: " + lineas.get(1));
//    }
}
