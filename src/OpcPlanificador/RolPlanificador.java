
package OpcPlanificador;

//Declaracion de la clase
/**
 * Clase RolEstudiante
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class RolPlanificador {
    
    //Declaracion de metodos
    
    /**
     * Metodo crearCurso: instancia un objeto de tipo curso y llama al metodo
     * crear de la clase curso e imprime la informacion con el metodo toString 
     */

    //Opcion 1
    public void crearCurso() {
        Curso ob = new Curso();
        ob.crear();
        System.out.println(ob.toString());
    }

    
    /**
     * Metodo crearProfesor: instancia un objeto de tipo ProfesorRegistro que
     * llama al metodo crear de la clase ProfesorRegistro e imprime la informacion
     * con el metodo toString 
     */
    //Opcion 2
    public void crearProfesor() {
        ProfesorRegistro ob = new ProfesorRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    
    /**
     * Metodo crearEstudiante: instancia un objeto de tipo EstudianteRegistro que
     * llama al metodo crear de la clase EstudianteRegistro e imprime la informacion
     * con el metodo toString 
     */
    //Opcion 3
    public void crearEstudiante() {
        EstudianteRegistro ob = new EstudianteRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    
    /**
     * Metodo verHorarios: instancia un objeto de tipo Horario que
     * llama al metodo planificador de la clase Horario e imprime la informacion
     * con el metodo toString 
     */
    //Opcion 4
    public void verHorarios() {
        Horario ob = new Horario();
        ob.planificador();
        System.out.println(ob.toString());
    }

    /**
     * Metodo listadorEstudiante: instancia un objeto de tipo Lista que
     * llama al metodo listar de la clase Lista
     */
    //Opcion 5
    public void listadorEstudiante() {
        Lista ob1 = new Lista();
        ob1.listar();
        System.out.println(ob1.toString());
    }
}
