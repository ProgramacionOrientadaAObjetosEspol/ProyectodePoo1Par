package proyectodepoo1par;

//Declaracion de la clase

/**
 * Clase HechiceroPlanificador que hereda de la clase Rol
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */

public class HechiceroPlanificador extends Rol {

    
    //Declaracion del contructor
    
    /**
     * Constructor HechiceroPlanificador
     * @param usuario
     * @param contraseña
     * @param nombre
     * @param apellido
     * @param rol
    
     */
    public HechiceroPlanificador(String usuario, String contraseña, String nombre, String apellido, String rol) {
        super(usuario, contraseña, nombre, apellido, rol);
    }

    /**
     * Metodo TipoMago: metodo sobrescrito debido a la herencia 
     */
    @Override
    public Object TipoMago() {
        //Animagos, Metamorfomago y Normal
        return null;
    }
}
