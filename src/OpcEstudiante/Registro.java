package OpcEstudiante;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;
import proyectodepoo1par.Principal;

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
    static int op_materias;
    
    /**
     * variable default: Contador para saber si el usuario cuenta con la edad 
     * necesaria para ver la materia escogida
    */
    int extraodinario;
    
    /**
     * variable privada contador: Sera usada como contador en el metodo planificador
     */
    private int contador;
    
    /**
     * variable default: Almacena "S/N" si el usuario desea o no continuar con el proceso
     */
    String op_crear;
    
    /**
     * variable lineasFileCurso: Almacenara las lineas del archivo curso.txt 
     */
    ArrayList<ArrayList<String>> lineasFileCurso = null; 
    
    /**
     * variable lineasFileEstudiantes: Almacenara las lineas del archivo estudiantes.txt 
     */
    ArrayList<ArrayList<String>> lineasFileEstudiantes = null;
    
    /**
     * variable lineasFileRegistro: Almacenara las lineas del archivo registro.txt 
     */
    ArrayList<ArrayList<String>> lineasFileRegistro = null;
    
    /**
     * variable lineasAddFile: Almacenara las lineas para agregar al archivo registro.txt 
     */
    ArrayList<String> lineasAddFile = null;
    
    /**
     * variable estatica arr: Almacena en un array de objetos las materias
     * de la clase enum Materias
     */
    static Object[] arr = Materias.values(); 
    
    //Declaracion del constructor
    
    /**
     *Constructor de la clase 
     * @param usuario Almancenara el usuario 
     * @param contraseña Almancenara la contraseña del usuario
     */
    public Registro(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Declaracion del metodos
    
    //Principal
    /**
     * 
     * Metodo registrar: se encarga de leer la opcion de materia
     * que el usuario ingrese, ademas valida que el usuario cumpla con la restriccion
     * de edad para la materia que escogio
     */
    public void registrar() {
        op_crear = "N"; 
        contador = 0;
        extraodinario = 0;
        archivo = new ReadWriter();        
        
        
        //Elegir la opcion de las materias
        op_materias = new Principal().eligirMateria();
        lineasFileRegistro = archivo.leerArchivo("registro.txt");
        
        getNomApe();
        
        //Cuenta cuantos alumnos hay en esa clase
        for (ArrayList<String> linea : lineasFileRegistro) {
           if (linea.get(3).equals(arr[op_materias - 1].toString())) {
               contador ++;
           }
           if(linea.get(1).equals(nombre) && linea.get(2).equals(apellido) && linea.get(3).equals(arr[op_materias-1].toString())){
               System.out.println("\nYa está registrado en la materia.");return;
           }
        }
        
        System.out.print("");
        int comprobacion = 0;
        lineasFileCurso = archivo.leerArchivo("cursos.txt");
        for(ArrayList<String> linea: lineasFileCurso){
            if(linea.get(0).equals(arr[op_materias-1].toString())){
                //Comprobamos si el curso esta lleno
                int capacidad = Integer.parseInt(linea.get(4));
                if(capacidad == contador){System.out.println("\nEl curso esta lleno.");return;}
                //Mostramos el horario disponible
                System.out.print("\nEl horario de "+ arr[op_materias-1] +" es "+ linea.get(2) +", "+ linea.get(3));
                comprobacion+=1;
            }            
        }
        
        if(comprobacion==0){System.out.println("\nEsta materia no tiene curso asignado.");return;}
        
        lineasFileRegistro.clear(); //Liberamos memoria
        lineasFileCurso.clear();    //liberamos memoria
        
        //Registrarse
        System.out.print("\n¿Desea registrarse? (S/N) ");
        op_crear = t.nextLine();
        System.out.println();
        
        if (op_crear.equals("S")) {
            extraodinario = 0;
            lineasFileEstudiantes = archivo.leerArchivo("estudiantes.txt"); 
            for(ArrayList<String> linea: lineasFileEstudiantes){
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
            lineasFileEstudiantes.clear();
        }
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
        lineasAddFile = new ArrayList<>();
        
        //FECHA
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día, 
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String f = Integer.toString(dia)+"/"+String.valueOf(mes+1)+"/"+String.valueOf(año);

        lineasAddFile.add(f);
        lineasAddFile.add(nombre);
        lineasAddFile.add(apellido);
        lineasAddFile.add(arr[op_materias-1].toString());
        if(extraodinario == 0){
            lineasAddFile.add("N");
        }else{
            lineasAddFile.add("E");
        }
        archivo.AgregarAlArchivo(lineasAddFile, "registro.txt");
    }
    
    
    /**
     * Metodo getNomApe: permite obtener el nombre y el apellido
     * del usuario mediante el recorrido el archivo "usuario.txt.2
     */
    public void getNomApe(){
        lineasFileCurso = archivo.leerArchivo("usuarios.txt");
        for(ArrayList<String> linea: lineasFileCurso){
            if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){
                nombre = linea.get(2);
                apellido = linea.get(3);
            }
        }
    }
}