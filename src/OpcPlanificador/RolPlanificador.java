
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class RolPlanificador {

    
    
    public void crearCurso() {
        Curso ob = new Curso();
        ob.crear();
    }

    public void crearProfesor() {
        ProfesorRegistro ob = new ProfesorRegistro();
        ob.crear();
    }

    public void crearEstudiante() {
        EstudianteRegistro ob = new EstudianteRegistro();
        ob.crear();
    }

    public void verHorarios() {
        Horario ob = new Horario();
        ob.planificador();
    }

    public void listadorEstudiante() {

    }
}
