
package OpcPlanificador;

public class RolPlanificador {
    //Opcion 1
    public void crearCurso() {
        Curso ob = new Curso();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    //Opcion 2
    public void crearProfesor() {
        ProfesorRegistro ob = new ProfesorRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    //Opcion 3
    public void crearEstudiante() {
        EstudianteRegistro ob = new EstudianteRegistro();
        ob.crear();
        System.out.println(ob.toString()+"\n");
    }

    //Opcion 4
    public void verHorarios() {
        Horario ob = new Horario();
        ob.planificador();
        System.out.println(ob.toString()+"\n");
    }

    //Opcion 5
    public void listadorEstudiante() {
        Lista ob1 = new Lista();
        ob1.listar();
        //System.out.println(ob1.toString());
    }
}
