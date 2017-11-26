
package OpcEstudiante;

import java.util.Scanner;
import proyectodepoo1par.Materias;


public class Planificacion {
    Scanner t = new Scanner(System.in);
    
    public void planificar(){
        int op_materias;
        
         Object[] arr = Materias.values();        //Materias en array
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
        
        
    }
    
    @Override
    public String toString() {
        return "";
    }
    
}
