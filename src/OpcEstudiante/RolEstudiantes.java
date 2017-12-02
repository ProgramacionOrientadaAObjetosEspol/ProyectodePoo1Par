package OpcEstudiante;

//Declaracion de la clase
/**
 * Clase RolEstudiante
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class RolEstudiantes {
    
    //Declaracion de metodos
    
    /**
     * Metodo VerCurso: instancia un objeto de tipo planificacion y llama al metodo
     * planificar de la clase Planificacion
     */
    public void VerCurso() {
        Planificacion p = new Planificacion();
        p.planificar();
        System.out.println(p.toString()+"\n");
    }

    /**
     * Metodo registrar: instancia un objeto de tipo registro que recibe parametros
     * y llama al metodo registrar de la clase registro
     * @param usuario
     * @param contraseña
     */
    public void registrar(String usuario, String contraseña) {
        Registro r = new Registro(usuario, contraseña);
        r.registrar();
        System.out.println(r.toString());
    }

    /**
     * Metodo describir: instancia un objeto de tipo vuelo y llama a los metodos
     * getNomApe y describir de la clase Vuelo
     * @param usuario
     * @param contraseña
     */
    public void describir(String usuario, String contraseña) {
        Vuelo v= null; 
        v.getNomApe();
        v.describir();
    }

}
