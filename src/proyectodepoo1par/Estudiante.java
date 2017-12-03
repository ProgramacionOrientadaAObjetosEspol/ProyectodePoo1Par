package proyectodepoo1par;

import IntefazPrin.*;
import java.util.Scanner;

//Declaracion de la clase

/**
 * Clase Estudiante que hereda de la clase Miembros 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */

public class Estudiante extends Miembros {
    
    //Declaracion de atributos
    
    /**
     * variable default: Almancenara la entrada 
     */
    Scanner datos = new Scanner(System.in);
    
    /**
     * objeto nomal: Inicializacion del objeto de tipo normal como vacio 
     * para su posterior implementacion
     */
    Normal normal = null;
    
    /**
     * objeto metamorfomago: Inicializacion del objeto de tipo metamorfomago como vacio 
     * para su posterior implementacion
     */
    Metamorfomago metamorfomago = null;
    
    /**
     * objeto animago: Inicializacion del objeto de tipo animago como vacio 
     * para su posterior implementacion
     */
    Animagos animago = null;
    
    
    //Declaracion de contructores
    
    /**
     * Constructor Estudiante
     * @param usuario
     * @param contraseña
     * @param nombre
     * @param apellido
     * @param rol
     * @param edad
     * @param casa
     * @param varita 
     */
    public Estudiante(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }

    /**
     * Constructor Estudiante
     * @param edad
     * @param casa
     * @param varita 
     * @param nombre
     * @param apellido
     */
    public Estudiante(int edad, String casa, String varita, String nombre, String apellido) {
        super(edad, casa, varita, nombre, apellido);
    }
    
    //Declaracion de metodos 
    
     /**
     * Metodo TipoMago: permite al usuario seleccionar el tipo de mago
     * @return animago, si es de tipo animago
     *         metamorfomago, si es de tipo metamorfomago
     *         normal, es un mago normal
     *         Opcion incorrecta, si ingresa un numero diferente de las opciones
     *         null si no ingresa nada 
     */
    @Override
    public Object TipoMago() {
        System.out.println("Tipos de Magos/Brujas");
        System.out.println("1. Animago \n2. Metamorfomago \n3. Normal ");
        System.out.print("Elija el tipo de mago/bruja que es: ");
        int opc = datos.nextInt();
        datos.nextLine();
        while (true) {
            if (opc == 1) {
                animago = new Animagos();
                return animago;
            }
            else if (opc == 2) {
                metamorfomago = new Metamorfomago();
                return metamorfomago;
            }
            else if (opc == 3) {
                normal = new Normal();
                return normal;
            }
            else{
                System.out.println("Opcion incorrecta! ");
                return null;
            }
        }
    }
}
