package proyectodepoo1par;

import IntefazPrin.*;
import java.util.Scanner;

//Declaracion de la clase

/**
 * Clase Estudiante que hereda de la clase Miembros 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 03/12/17
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
     * @param usuario almacena el  usuario
     * @param contraseña almacena la contraseña del usuario
     * @param nombre almacena el nombre del usuario
     * @param apellido almacena el apellido del usuario
     * @param rol almacena el rol del usuario
     * @param edad almacena la edad del usuario
     * @param casa almacena la casa a la que pertenece el mago
     * @param varita almacena la varita que usa el mago
     */
    public Estudiante(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }

    /**
     * Constructor Estudiante
     * @param edad almacena la edad del usuario
     * @param casa almacena la casa a la que pertenece el mago
     * @param varita almacena la varita que usa el mago
     * @param nombre almacena el nombre del usuario
     * @param apellido almacena el apellido del usuario
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
        OUTER:
        while (true) {
            int validacion = 0;
            System.out.println("Tipos de Magos/Brujas");
            System.out.println("1. Animago \n2. Metamorfomago \n3. Normal ");
            System.out.print("Elija el tipo de mago/bruja que es: ");
            
            while(validacion == 0){
                String n1 = datos.nextLine();
                validacion = Integer.parseInt(new Principal().validarNumero(n1));
                if(validacion == 0){System.out.print("Intente de nuevo!\n\nElija el tipo de mago/bruja que es: ");}
            }
            System.out.println("");
            switch (validacion) {
                case 1:
                    animago = new Animagos();
                    return animago;
                    
                case 2:
                    metamorfomago = new Metamorfomago();
                    return metamorfomago;
                    
                case 3:
                    normal = new Normal();
                    return normal;
                    
                default: 
                     System.out.println("Intente de nuevo.\n");
                    break; //Intentar de nuevo
            }
        }

    }
}
