
package OpcPlanificador;

import IntefazPrin.*;
import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Profesor;
import proyectodepoo1par.ReadWriter;

//Declaracion de la clase

/**
 * Clase ProfesorRegistro
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class ProfesorRegistro {
    
    //Declaracion de atributos
    
    /**
     * variable default: Almancenara la entrada 
     */
    Scanner datos = new Scanner(System.in);
    
    /**
     * variable default: Almancenara la informacion si el usuario desea continuar
     * con el registro
     */
    String op_crear ="";
    
    /**
     * objeto Profedor: Inicializacion del objeto de tipo profesor como vacio 
     * para su posterior implementacion
     */
    Profesor profesor = null;
    
    /**
     * objeto tipo: Inicializacion del objeto de tipo object como vacio 
     * para su posterior implementacion
     */
    Object tipo = null;
    
    
    //Declaracion de metodos
    
    /**
     * Metodo crearLista: Permite crear el profesor con los datos proporcionados por el usuario
     * gracias a la entrada, ademas almacena la informacion en el arraylist llamado listaDatos, 
     * el cual luego es guardo en el archivo "profesores.txt"
     * @param nombre almacena el nombre del usuario
     * @param apellido almacena el apellido del usuario
     * @param edad almacena la edad del usuario
     * @param varita almacena el tipo de varita que usa el usuario
     * @param fechaIngreso almacena la fecha de ingreso para la creacion de cursos
     * @param tipo almacena el tipo de mago que es el usuario
     * @param animal almacena que tipo de animal es el usuario
     * @param hechizo almacena el tipo de hechizo que realiza el mago
     * @param pocion almacena el tipo de pocion que toma el mago
     * @param deporte almacena el tipo de deporte que practica el mago
     */
    //Guardamos al profesor
    public void crearLista(String nombre,String apellido,String edad, String varita,String fechaIngreso, String tipo,String animal,String hechizo, String pocion, String deporte){
        ReadWriter archivo = new ReadWriter();
        
        ArrayList<String> listaDatos = new ArrayList<>();
        listaDatos.add(nombre);
        listaDatos.add(apellido);
        listaDatos.add(edad);
        listaDatos.add(varita);
        listaDatos.add(fechaIngreso);
        listaDatos.add(tipo);
        listaDatos.add(animal);
        listaDatos.add(hechizo);
        listaDatos.add(pocion);
        listaDatos.add(deporte);
        
        archivo.AgregarAlArchivo(listaDatos, "profesores.txt");
    }   
    
    
    /**
     * Metodo pedirDatos: Permite almacenar los datos proporcionados por el usuario
     * en las variables proporcionadas, ademas instancia el objeto de tipo profesor
     * y envia los datos al contructor 
     */
    //Pedir los datos
    public void pedirDatos(){
        System.out.println("CREAR PROFESOR");
        System.out.print("Ingrese nombre: ");
        String nombre = datos.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = datos.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = datos.nextInt();
        datos.nextLine();
        System.out.print("Varita: ");
        String varita = datos.nextLine();
        System.out.print("Fecha de ingreso: ");
        String fechaRegistro = datos.nextLine();
        
        profesor = new Profesor(fechaRegistro,edad, "null", varita, nombre, apellido);
    }
    
    
     /**
     * Metodo crear: Define el objeto tipo para pedir los datos al objeto profesor de
     * acuerdo al tipo de mago del usuario
     */
    //Principal
    public void crear(){
        pedirDatos();
        //Pedimos los datos con el objeto profesor
        tipo = profesor.TipoMago();

        //crear
        System.out.print("\n¿Desea guardar los datos? (S/N) ");
        op_crear = datos.nextLine();
        System.out.println();
        
        if(op_crear.equals("S")){
            if(tipo instanceof Animagos){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "A", profesor.getAnimagoAnimal(), profesor.getAnimagoHechizo(),"null","null");
            }else if(tipo instanceof Metamorfomago){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "M", "null","null",profesor.getMetamorfoPocion(),"null");
            }else if(tipo instanceof Normal){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "N", "null","null","null", profesor.getNormalDeporte());
            }
        }
    }

    
    /**
     * Metodo toString: muestra el mensaje de acuerdo al valor del contador op
     * @return "Sus datos se han guardado correctamente" si el usuario ingreso "S"
     * o "No se han gurdado sus datos" ssi el usuario ingreso "N"
     */
    
    @Override
    public String toString() {
        if(op_crear.equals("S")){
            return("Sus datos se han guardado correctamente.\n");
        }else {
            return("No se han gurdado sus datos.\n");
        }   
    }
    
    
}
