package OpcEstudiante;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

//Declaracion de la clase
/**
 * Clase Registro
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */

public class Registro {
    
    //Declaracion de variables
    
    /**
     * variable privada: Almancenara el usuario 
     */
    private String usuario; 
    
    /**
     * variable privada: Almancenara la contraseña del usuario
     */
    private String contraseña;
    
     /**
     * variable publica estatica: Almancenara el nombre del usuario
     */
    public static String nombre;
    
    /**
     * variable publica estatica: Almancenara el apellido del usuario
     */
    public static String apellido;
    
    /**
     * variable publica estatica: Almacenara la fecha de registro del estudiante 
     */
    public static String fecha;
    
    /**
     * variable default estatica: Entrada de scanner 
     */

    static Scanner t = new Scanner(System.in);
    
    /**
     * Objeto archivo de la clase ReadWriter inicializado null para su posterior uso
     */
    ReadWriter archivo = null;
    
    /**
     * variable default estatica: Almacenara la opcion de materia que ingrese el usuario 
     */
    static int op_materias=0;
    
     /**
     * variable default estatica: Contador para saber si el usuario cuenta con la edad 
     * necesaria para ver la materia escogida
     */
    static int extraodinario= 0;
    
    /**
     * variable default estatica: Almacena "S/N" si el usuario desea o no continuar con el proceso
     */
    static String op_crear;
    
    /**
     * variable lineas: Almacenara las lineas del archivo curso.txt 
     */
    ArrayList<ArrayList<String>> lineas = null; 
    
    /**
     * variable lineas1: Almacenara las lineas del archivo estudiantes.txt 
     */
    ArrayList<ArrayList<String>> lineas1 = null;
    
    /**
     * variable lineas2: Almacenara las lineas del archivo registrar.txt 
     */
    ArrayList<String> lineas2 = null;
    
    /**
     * variable estatica arr: Almacena en un array de objetos las materias
     * de la clase enum Materias
     */
    static Object[] arr = Materias.values(); 
    
    //Declaracion del constructor
    
    /**
     *Constructor de la clase 
     * @param usuario 
     * @param contraseña
     */
    public Registro(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Declaracion del metodos
    
    /**
     * 
     * Metodo registrar: se encarga de leer la opcion de materia
     * que el usuario ingrese, ademas valida que el usuario cumpla con la restriccion
     * de edad para la materia que escogio
     */
    public void registrar() {
        archivo = new ReadWriter();
        lineas = new ArrayList<>();
        lineas1 = new ArrayList<>();
        
        lineas = archivo.leerArchivo("cursos.txt");
        
        //Elegir la opcion de las materias
        eligirMateria();
        
        for(ArrayList<String> linea: lineas){
            if(linea.get(0).equals(arr[op_materias-1].toString())){
                System.out.print("El horario de "+ arr[op_materias-1] +" es "+ linea.get(2) +", "+ linea.get(3));
            }            
        }
        
        //Registrarse
        System.out.print("\n¿Desea registrarse? (S/N) ");
        op_crear = t.nextLine();
        System.out.println();
        
        getNomApe();
        lineas1 = archivo.leerArchivo("estudiantes.txt"); 
        if (op_crear.equals("S")) {
            for(ArrayList<String> linea: lineas1){
                //Compara nombre y apellidos
                if(linea.get(0).equals(nombre) && linea.get(1).equals(apellido)){
                    //compara si pertemece a una de las materias con restriccion
                    if(arr[0].toString().equals(arr[op_materias-1].toString()) || arr[1].toString().equals(arr[op_materias-1].toString()) || arr[2].toString().equals(arr[op_materias-1].toString())){
                        //Vemos si es menor de lo requerido
                        if (Integer.valueOf(linea.get(2)) <= 15){
                            extraodinario++;
                        }
                    }
                    registrarArchivo();
                }
                
            }
        }
    }
    
    /**
     * Metodo elegirMateria: muestra las materias del arreglo 
     * y le permite al usuario escoger una 
     */
    public static void eligirMateria(){
        //Materias
        System.out.println("\n/** MATERIAS **/ \n");
        int n = 1;
        for (Object i : arr) {
            System.out.println(n + ". " + i);
            n++;
        }
        System.out.print("Elija una materia del listado de materias: ");
        op_materias = t.nextInt();
        t.nextLine();
        System.out.println("\n");
    }

    /**
     * Metodo toString: muestra el mensaje de acuerdo a la opcion
     * escogida por el usuario para continuar con el registro
     * @return "Se ha registrado en la materia" si el estudiante ingreso la opcion "s"
     * o "No se ha registrado en la materia" si el estudiano ingreso la opcion "N"
     */
    @Override
    public String toString() {
        if (op_crear.equals("S")) {
            return "Se ha registrado en la materia";
        } else {
            return "No se ha registrado en la materia";
        }
    }
    
    /**
     * Metodo registrarArchivo: permite almacenar en el archivo
     * "registro.txt" los datos del usuario obtenidos durante el registro
     */
    public void registrarArchivo(){
        lineas2 = new ArrayList<>();
        
        //FECHA
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día, 
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String f = Integer.toString(dia)+"/"+String.valueOf(mes+1)+"/"+String.valueOf(año);

        lineas2.add(f);
        lineas2.add(nombre);
        lineas2.add(apellido);
        lineas2.add(arr[op_materias-1].toString());
        if(extraodinario == 0){
            lineas2.add("N");
        }else{
            lineas2.add("E");
        }
        archivo.AgregarAlArchivo(lineas2, "registro.txt");
    }
    
    
    /**
     * Metodo getNomApe: permite obtener el nombre y el apellido
     * del usuario mediante el recorrido el archivo "usuario.txt.2
     */
    public void getNomApe(){
        lineas = archivo.leerArchivo("usuarios.txt");
        for(ArrayList<String> linea: lineas){
            if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){
                nombre = linea.get(2);
                apellido = linea.get(3);
            }
        }
    }
}

//Falta!
//Aumentar el numero de registrados en ese curso