package proyectodepoo1par;

import IntefazPrin.*;
import java.util.Scanner;

//Declaracion de la clase

/**
 * Clase Profesor que hereda de la clase Miembros 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 03/12/17
 */
public class Profesor extends Miembros {
    
    //Declaracion de atributos
    
    /**
     * variable datos: Almancenara la entrada
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
    
    /**
     * variable privada: Almancenara la fecha de ingreso del curso
     */
    private String fechaRegistro;

    
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
    public Profesor(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }

    /**
     * Constructor Estudiante
     * @param edad almacena la edad del usuario
     * @param casa almacena la casa a la que pertenece el mago
     * @param varita almacena la varita que usa el mago
     * @param nombre almacena el nombre del usuario
     * @param apellido almacena el apellido del usuario
     * @param fechaRegistro almacena la fecha en que se realiza el registro
     */
    public Profesor(String fechaRegistro, int edad, String casa, String varita, String nombre, String apellido) {
        super(edad, casa, varita, nombre, apellido);
        this.fechaRegistro = fechaRegistro;
    }
    
    //Declaracion de metodos 
    
     /**
     * Metodo TipoMago: devuelve el tipo de mago 
     */
    public void tipoMago(){ 
    }

    /**
     * Metodo getFechaRegistro: Devuelve la fecha de Registro 
     * @return fechaRegistro 
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    
    /**
     * Metodo setFechaRegistro: establece la fecha de registro a la variable 
     * del contructor
     * @param fechaRegistro Almacena la fecha en que se realiza el registro
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
     /**
     * Metodo TipoMago: permite al usuario seleccionar el tipo de mago
     * @return animago, si es de tipo animago si realiza hechizos
     *         metamorfomago, si es de tipo metamorfomago si toma una pocion
     *         normal, es un mago normal dependiendo si practica un deporte
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
                    System.out.print("En que clase de animal puede convertirse?: ");
                    String animal = datos.nextLine();

                    System.out.print("Ingrese su hechizo: ");
                    String hechizo = datos.nextLine();
                    animago = new Animagos(animal, hechizo);
                    return animago;
                    
                case 2:
                    System.out.print("Ingrese su pocion: ");
                    String pocion = datos.nextLine();

                    metamorfomago = new Metamorfomago(pocion);
                    return metamorfomago;
                    
                case 3:
                    System.out.print("Que clase de deporte practica: ");
                    String deporte = datos.nextLine();

                    normal = new Normal(deporte);
                    return normal;
                    
                default: 
                     System.out.println("Intente de nuevo.\n");
                    break; //Intentar de nuevo
            }
        }
    }
    
    /**
     * Metodo getAnimagoAnimal: devuelve si es animago que se convierte en animal
     * @return animago 
     */
    public String getAnimagoAnimal(){
        return (animago.getAnimal());
    }
    
    /**
     * Metodo getAnimagoHechizo: devuelve si es animago que hace hechizo 
     * @return animago 
     */
    public String getAnimagoHechizo(){
        return (animago.getHechizo());
    }
    
    /**
     * Metodo getMetamorfoPocion: devuelve si es metamorfomago que toma pocion 
     * @return metamorfomago 
     */
    public String getMetamorfoPocion(){
        return (metamorfomago.getPosión());
    }
    
    /**
     * Metodo getNormalDeporte: devuelve si es normal que realiza deporte
     * @return normal 
     */
    public String getNormalDeporte(){
        return (normal.getDeporte());
    }
}

