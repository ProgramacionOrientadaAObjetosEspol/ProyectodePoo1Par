
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class RolPlanificador {

    
    
    public void crearCurso() {
        Curso ob = new Curso();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    public void crearProfesor() {
        ProfesorRegistro ob = new ProfesorRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    public void crearEstudiante() {
        EstudianteRegistro ob = new EstudianteRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    public void verHorarios() {
        Horario ob = new Horario();
        ob.planificador();
        System.out.println(ob.toString()+"\n");
    }

    public void listadorEstudiante() {

    }
}
