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
        //objetos
        RolPlanificador planificador = null;
        RolEstudiantes estudiante = null;
        
        Bienvenida();
        
        while(true){
            //variable
            int opcion;
            Validacion();
            
            if (validacion_ingreso == 1){
                System.out.println("Ingreso exitoso\n");
                if(validacion.equals("planificador")){
                    while(true){
                        System.out.println("----------------------------------------------------------------------------");
                        planificador = new RolPlanificador();
                        System.out.println("1. Crear Curso \n2. Crear Profesor \n3. Crear Estudiante \n4. Ver Horarios Planificados \n5. Listado de estudiantes\n6. Salir ");
                        System.out.print("Ingrese una opcion: ");
                        opcion = t.nextInt();
                        t.nextLine();
                        System.out.println("");
                        if(opcion == 1){planificador.crearCurso();}
                        else if(opcion == 2){planificador.crearProfesor();}
                        else if(opcion == 3){planificador.crearEstudiante();}
                        else if(opcion == 4){planificador.verHorarios();}
                        else if(opcion == 5){planificador.listadorEstudiante();}
                        else if(opcion == 6){
                            System.out.println("Sesion cerrada.\nGracias por usar el programa.\n----------------------------------------------------------------------------");
                            break;
                        }else{System.out.println("Opcion incorrecta intente de nuevo");}
                    }
                    
                }else{
                    while(true){
                        System.out.println("----------------------------------------------------------------------------");
                        estudiante = new RolEstudiantes();
                        System.out.println("1. Ver cursos planificados\n2. Registro\n3. Descripcion de vuelo\n4. Salir ");
                        opcion = t.nextInt();
                        System.out.println("");
                        if(opcion == 1){estudiante.VerCurso();}
                        else if(opcion == 2){estudiante.registrar(usuario, contraseña);}
                        else if(opcion == 3){;}
                        else if(opcion == 4){
                            System.out.println("Sesion cerrada.\nGracias por usar el programa.\n----------------------------------------------------------------------------");
                            break;
                        }else{System.out.println("Opcion incorrecta intente de nuevo");}
                    }
                }
            }else if(validacion_ingreso == 2){
                System.out.println("Adios.");
                break;
            }else{System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.\n");}
        }
    }    
    
    
    //Metodos estaticos
    public static void Bienvenida(){
        System.out.println("        _________\n" +
"       |   ___   \\   ___   _________   ___     __  ___         ___  __________   ___     __   ___   _____     ____     ______\n" +
"       |  |___|  |  |   | |    _____| |    \\  |  | \\  \\       /  / |    ______| |    \\  |  | |   | |     \\   /    \\   /  ___/\n" +
"       |        /   |   | |   |_____  |     \\ |  |  \\  \\     /  /  |   |______  |     \\ |  | |   | |  --  | |  --  |  \\  \\\n" +
"       |   ___  \\   |   | |    _____| |  |\\  \\|  |   \\  \\   /  /   |    ______| |  |\\  \\|  | |   | | |  | | | |  | |   \\  \\\n" +
"       |  |___|  |  |   | |   |_____  |  | \\     |    \\  \\_/  /    |   |______  |  | \\     | |   | |  --  | |  --  | ---   /\n" +
"       |________/   |___| |_________| |__|  \\____|     \\_____/     |__________| |__|  \\____| |___| |_____/   \\____/  \\____/\n" );
        
        System.out.println("Al sistema de colegio Hogwarts");
    }
    
    public static void Validacion(){
        
        //Creacion de objetos para leer el archivo de usuarios.txt
        archivo = new ReadWriter();
        lineas = new ArrayList<>();
        
        while(true){
            System.out.println("Iniciar sesión:\n1. Continuar\n2. Cerrar");
            int n = t.nextInt();
            t.nextLine();
            System.out.println();
            if(n==1){   //Inciando sesion
                System.out.print("Ingrese su usuario: ");
                usuario = t.nextLine();
                System.out.print("Ingrese su contraseña: ");
                contraseña = t.nextLine();

                lineas = archivo.leerArchivo("usuarios.txt");

                for(ArrayList<String> linea: lineas){
                    if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){validacion_ingreso++;}
                    if (validacion_ingreso == 1){
                        validacion = linea.get(4);
                        break;
                    }
                }
                break;
            }else if(n==2){validacion_ingreso=2;break;}     //SAlir 
            else{System.out.println("Intente de nuevo.\n");break;}  //Intentar de nuevo
        }
    }
}
