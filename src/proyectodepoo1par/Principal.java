package proyectodepoo1par;

import OpcEstudiante.RolEstudiantes;
import OpcPlanificador.RolPlanificador;
import java.util.ArrayList;
import java.util.Scanner;

//Declaracion de la clase

/**
 * Clase Principal
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 03/12/17
 */
public class Principal {
   //Declaracion de atributos
    
    /**
     * variable estatica: Almancenara la entrada
     */
    static Scanner t = new Scanner(System.in);
    
    /**
     * variable estatica: Almancenara el usuario
     */
    static String usuario;
    
    /**
     * variable estatica: Almancenara la contraseña del usuario
     */
    static String contraseña;
    
    /**
     * variable estatica: Usada para validar el progreso 
     */
    static String validacion;
    
    /**
     * variable estatica: Almancenara en un array las lineas del archivo "usuarios.txt"
     * que es inicializado en null para su posterior implementacion
     */
    static ArrayList<ArrayList<String>> lineas = null;
    
    /**
     * variable estatica: Almancenara la opcion de lectura del archivo a usar,
     * es inicializado en null para su posterior implementacion
     */
    static ReadWriter archivo = null;
    
    /**
     * variable estatica: Se usara para validar el valor de ingreso dado por el usario
     */
    static int validacion_ingreso;
    
    //Declaracion de metodos 
    
     /**
     * Metodo main: Encargado del proceso de inicio de sesion, si el caso es 1 el
     * usuario ingresara de forma exitosa, si el caso es 2 el programa se cierra, 
     * caso contrario el usuario ingreso los datos de usuario y contraseña son incorrectos
     *@param args Sera un array de Strings
     */
    public static void main(String[] args){    
        new Principal().Bienvenida();
        
        OUTER:
        while (true) {
            Validacion();
            switch (validacion_ingreso) {
                case 1:
                    //Ingreso exitoso
                    System.out.println("Ingreso exitoso\n");
                    if(validacion.equals("planificador")){                  //Si ingresa como planificador
                        new Principal().opPlanificador();
                    }else{                                                  //Si ingresa como estudainte
                        new Principal().opEstudiante();
                    }   break;
                case 2:
                    //Cerrar
                    System.out.println("*** Adiós ***");
                    break OUTER;
                default:
                    System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.\n");
                    break; //Error de ingreso de datos(no try catch)
            }
        }
    }    
    
    
     /**
     * Metodo Bienvenida: Encargado de mostrar el mensaje "Bienvenido al sistema
     * del colegio Hogwarts de Hagia y Hechiceria  "
     */
    
    /**
    * Este es un mensaje de bienvenida
    */
    public void Bienvenida(){
        System.out.println("        _________\n" +
"       |   ___   \\   ___   _________   ___     __  ___         ___  __________   ___     __   ___   _____     ____     ______\n" +
"       |  |___|  |  |   | |    _____| |    \\  |  | \\  \\       /  / |    ______| |    \\  |  | |   | |     \\   /    \\   /  ___/\n" +
"       |        /   |   | |   |_____  |     \\ |  |  \\  \\     /  /  |   |______  |     \\ |  | |   | |  --  | |  --  |  \\  \\\n" +
"       |   ___  \\   |   | |    _____| |  |\\  \\|  |   \\  \\   /  /   |    ______| |  |\\  \\|  | |   | | |  | | | |  | |   \\  \\\n" +
"       |  |___|  |  |   | |   |_____  |  | \\     |    \\  \\_/  /    |   |______  |  | \\     | |   | |  --  | |  --  | ---   /\n" +
"       |________/   |___| |_________| |__|  \\____|     \\_____/     |__________| |__|  \\____| |___| |_____/   \\____/  \\____/\n" );
        
        System.out.println("Al sistema del colegio Hogwarts de Magia y Hechiceria");
    }
    
    
    
     /**
     * Metodo Validacion: Encargado del proceso de validacion del inicio de sesion
     * ademas muestras las opciones necesarias para que el usuario continue o no
     * con el proceso
     */
    public static void Validacion(){
        //Creacion de objetos para leer el archivo de usuarios.txt
        archivo = new ReadWriter();
        lineas = new ArrayList<>();
        validacion_ingreso = 0;
        
        OUTER:
        while (true) {
            System.out.println("*** Elija una opcion ***");
            System.out.println("Iniciar sesión:\n1. Continuar\n2. Cerrar");
            String n1 = t.nextLine();
            int n = Integer.parseInt(new Principal().validarNumero(n1));
            System.out.println();
            switch (n) {
                case 1:
                    //Inciando sesion
                    System.out.println("*** Eligió Iniciar sesión ***");
                    System.out.print("Ingrese su usuario: ");
                    usuario = t.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    contraseña = t.nextLine();
                    lineas = archivo.leerArchivo("usuarios.txt");
                    for(ArrayList<String> linea: lineas){
                        if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){validacion_ingreso++;}
                        if (validacion_ingreso == 1){
                            validacion = linea.get(4);
                            break;          //Cierro el ciclo for
                        }
                    }   
                    break OUTER;        //Cierro el while
                case 2:                     //Salir
                    validacion_ingreso=2;
                    break OUTER;
                default:
                    System.out.println("Intente de nuevo.\n");
                    break; //Intentar de nuevo
            }
        }
    }
    
    /**
     * Metodo opPlanficador: Encargado de recibir el resultado para planificador,
     * muestra el menu y valida los datos ingresados para dar paso a la creacion 
     * del curso. En caso de que el usuario no desee pueda cerrar la sesion.
     */
    public void opPlanificador(){
        
        OUTER:
        while (true) {
            int opcion = 0;
            System.out.println("----------------------------------------------------------------------------");
            RolPlanificador planificador = new RolPlanificador();
            System.out.println("1. Crear Curso \n2. Crear Profesor \n3. Crear Estudiante \n4. Ver Horarios Planificados \n5. Listado de estudiantes\n6. Salir ");
            System.out.print("Ingrese una opcion: ");
            while(opcion == 0){
                String n1 = t.nextLine();
                opcion = Integer.parseInt(new Principal().validarNumero(n1));
                if(opcion == 0){System.out.print("Intente de nuevo!\n\nIngrese una opcion: ");}
            }
            switch (opcion) {
                case 1:
                    planificador.crearCurso();
                    break;
                case 2:
                    planificador.crearProfesor();
                    break;
                case 3:
                    planificador.crearEstudiante();
                    break;
                case 4:
                    planificador.verHorarios();
                    break;
                case 5:
                    planificador.listadorEstudiante();
                    break;
                case 6:
                    System.out.println("Sesion cerrada.\nGracias por usar el programa.\n----------------------------------------------------------------------------");
                    break OUTER;
                default:
                    System.out.println("Opcion incorrecta intente de nuevo");
                    break;
            }
        }
    }
    
     /**
     * Metodo opEstudiante: Encargado de recibir el resultado para estudiante,
     * muestra el menu y valida los datos ingresados para dar paso a la creacion 
     * del curso. En caso de que el usuario no desee pueda cerrar la sesion.
     */
    public void opEstudiante(){
        OUTER_1:
        while (true) {
            int opcion = 0;
            System.out.println("----------------------------------------------------------------------------");
            RolEstudiantes estudiante = new RolEstudiantes();
            System.out.println("1. Ver cursos planificados\n2. Registro\n3. Descripcion de vuelo\n4. Salir ");
            System.out.print("Ingrese una opcion: ");
            while(opcion == 0){
                String n1 = t.nextLine();
                opcion = Integer.parseInt(new Principal().validarNumero(n1));
                if(opcion == 0){System.out.print("Intente de nuevo!\n\nIngrese una opcion: ");}
            }
            System.out.println("");
            switch (opcion) {
                case 1:
                    estudiante.VerCurso();
                    break;
                case 2:
                    estudiante.registrar(usuario, contraseña);
                    break;
                case 3:
                    estudiante.describir(usuario, contraseña);;
                    break;
                case 4:
                    System.out.println("Sesion cerrada.\nGracias por usar el programa.\n----------------------------------------------------------------------------");
                    break OUTER_1;
                default:
                    System.out.println("Opcion incorrecta intente de nuevo");
                    break;
            }
        }
    }
    
    /**
     * Metodo validarNumero: Encargado de validar que el numero que ingrese el 
     * usuario sea el correcto
     * @param letra1 indica la letra ingresa por teclado
     * @return letra1 
     *         "0" en caso de que el usuario no ingrese ningun numero o presione 
     *          enter por error
     */
    public String validarNumero(String letra1){
            Scanner teclado1 = new Scanner(letra1);
            if(teclado1.hasNextInt()){
                teclado1.nextLine();
                return letra1;
            }
            System.out.println("No ingresó un número!");
            return "0";
    }
    
    /**
     * Metodo elegirMateria: muestra las materias del arreglo y le permite al 
     * usuario escoger una, ademas valida que la opcion ingresada sea la correcta
     * @return op_materias 
     */
    public int eligirMateria(){
        Object[] arr = Materias.values();   //Array con las materias provenientes de enum Materias        
        int op_materias = 0, n = 1;
        System.out.println("\n/** MATERIAS **/ \n");
        for (Object i : arr) {
            System.out.println(n + ". " + i);
            n++;
        }
        System.out.print("Elija una materia del listado de materias: ");
        while(op_materias == 0){
            String n1 = t.nextLine();
            op_materias = Integer.parseInt(new Principal().validarNumero(n1));
            if(op_materias == 0){System.out.print("Intente de nuevo!\n\nElija una materia del listado de materias: ");}
        }
        return op_materias;
    }
}
