package proyectodepoo1par;

import OpcEstudiante.RolEstudiantes;
import OpcPlanificador.RolPlanificador;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    
    //atributos estaticos
    static Scanner t = new Scanner(System.in);
    static String usuario, contraseña, validacion;
    static ArrayList<ArrayList<String>> lineas = null;
    static ReadWriter archivo = null;
    static int validacion_ingreso;
    
    public static void main(String[] args){    
        new Principal().Bienvenida();
        
        while(true){
            Validacion();
            
            if (validacion_ingreso == 1){                               //Ingreso exitoso
                System.out.println("Ingreso exitoso\n");
                if(validacion.equals("planificador")){                  //Si ingresa como planificador
                    new Principal().opPlanificador();
                }else{                                                  //Si ingresa como estudainte
                    new Principal().opEstudiante();
                }
            }else if(validacion_ingreso == 2){                          //Cerrar
                System.out.println("Adios.");
                break;
            }else{System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.\n");}      //Error de ingreso de datos(no try catch)
        }
    }    
    
    /**
    * ESte es un mensaje de bienvenida
    */
    public void Bienvenida(){
        System.out.println("        _________\n" +
"       |   ___   \\   ___   _________   ___     __  ___         ___  __________   ___     __   ___   _____     ____     ______\n" +
"       |  |___|  |  |   | |    _____| |    \\  |  | \\  \\       /  / |    ______| |    \\  |  | |   | |     \\   /    \\   /  ___/\n" +
"       |        /   |   | |   |_____  |     \\ |  |  \\  \\     /  /  |   |______  |     \\ |  | |   | |  --  | |  --  |  \\  \\\n" +
"       |   ___  \\   |   | |    _____| |  |\\  \\|  |   \\  \\   /  /   |    ______| |  |\\  \\|  | |   | | |  | | | |  | |   \\  \\\n" +
"       |  |___|  |  |   | |   |_____  |  | \\     |    \\  \\_/  /    |   |______  |  | \\     | |   | |  --  | |  --  | ---   /\n" +
"       |________/   |___| |_________| |__|  \\____|     \\_____/     |__________| |__|  \\____| |___| |_____/   \\____/  \\____/\n" );
        
        System.out.println("Al sistema de colegio Hogwarts");
    }
    
    /**
    * Respectiva validacion de iniciar sesion o cerrar 
    * y en cuanto a si continuar o no
    */
    public static void Validacion(){
        //Creacion de objetos para leer el archivo de usuarios.txt
        archivo = new ReadWriter();
        lineas = new ArrayList<>();
        validacion_ingreso = 0;
        
        while(true){
            System.out.println("Iniciar sesión:\n1. Continuar\n2. Cerrar");
            int n = t.nextInt();
            t.nextLine();
            System.out.println();
            if(n==1){   //Inciando sesion
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
                        break;      //Cierro el ciclo for
                    }
                }
                break;      //Cierro el while
            }else if(n==2){validacion_ingreso=2;break;}     //Salir 
            else{System.out.println("Intente de nuevo.\n");}  //Intentar de nuevo
        }
    }
    
    /**
    * Aqui se recibe el resultado para planificador
    */
    public void opPlanificador(){
        int opcion;
        OUTER:
        while (true) {
            System.out.println("----------------------------------------------------------------------------");
            RolPlanificador planificador = new RolPlanificador();
            System.out.println("1. Crear Curso \n2. Crear Profesor \n3. Crear Estudiante \n4. Ver Horarios Planificados \n5. Listado de estudiantes\n6. Salir ");
            System.out.print("Ingrese una opcion: ");
            opcion = t.nextInt();
            t.nextLine();
            System.out.println("");
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
    * Aqui se recibe el resultado para estudiante
    */
    public void opEstudiante(){
        int opcion;
        OUTER_1:
        while (true) {
            System.out.println("----------------------------------------------------------------------------");
            RolEstudiantes estudiante = new RolEstudiantes();
            System.out.println("1. Ver cursos planificados\n2. Registro\n3. Descripcion de vuelo\n4. Salir ");
            opcion = t.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    estudiante.VerCurso();
                    break;
                case 2:
                    estudiante.registrar(usuario, contraseña);
                    break;
                case 3:
                    ;
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
}
