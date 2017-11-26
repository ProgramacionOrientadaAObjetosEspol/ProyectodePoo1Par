package proyectodepoo1par;

import OpcEstudiante.RolEstudiantes;
import OpcPlanificador.RolPlanificador;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        
        //objetos
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        ReadWriter archivo = new ReadWriter();
        RolPlanificador planificador = null;
        RolEstudiantes estudiante = null;
        
        //Variables
        String usuario,contraseña;
        
        System.out.println("        _________\n" +
"       |   ___   \\   ___   _________   ___     __  ___         ___  __________   ___     __   ___   _____     ____     ______\n" +
"       |  |___|  |  |   | |    _____| |    \\  |  | \\  \\       /  / |    ______| |    \\  |  | |   | |     \\   /    \\   /  ___/\n" +
"       |        /   |   | |   |_____  |     \\ |  |  \\  \\     /  /  |   |______  |     \\ |  | |   | |  --  | |  --  |  \\  \\\n" +
"       |   ___  \\   |   | |    _____| |  |\\  \\|  |   \\  \\   /  /   |    ______| |  |\\  \\|  | |   | | |  | | | |  | |   \\  \\\n" +
"       |  |___|  |  |   | |   |_____  |  | \\     |    \\  \\_/  /    |   |______  |  | \\     | |   | |  --  | |  --  | ---   /\n" +
"       |________/   |___| |_________| |__|  \\____|     \\_____/     |__________| |__|  \\____| |___| |_____/   \\____/  \\____/\n" );
        
        System.out.println("Al sistema de colegio Hogwarts");
        
        while(true){
            int opcion;
            String validacion="";
            
            System.out.print("Ingrese su usuario: ");
            usuario = t.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contraseña = t.nextLine();

            lineas = archivo.leerArchivo("usuarios.txt");
            
            int validacion_ingreso = 0;
            
            for(ArrayList<String> linea: lineas){
                if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){validacion_ingreso++;}
                if (validacion_ingreso == 1){
                    validacion = linea.get(4);
                    break;
                }
            }
            
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
                        else if(opcion == 5){planificador.verHorarios();}
                        else if(opcion == 6){
                            System.out.println("Sesion cerrada.\nGracias por usar el programa.");
                            System.out.println("----------------------------------------------------------------------------");
                            break;
                        }else{System.out.println("Opcion incorrecta intente de nuevo");}
                    }
                    
                }else{
                    while(true){
                        System.out.println("----------------------------------------------------------------------------");
                        estudiante = new RolEstudiantes();
                        System.out.println("1. Ver cursos planificados\n2. Registro\n3. Descripcion de vuelo\n4. Salir ");
                        opcion = t.nextInt();
                        if(opcion == 1){estudiante.VerCurso();}
                        else if(opcion == 2){;}
                        else if(opcion == 3){;}
                        else if(opcion == 4){
                            System.out.println("Sesion cerrada.\nGracias por usar el programa.");
                            System.out.println("----------------------------------------------------------------------------");
                            break;
                        }else{System.out.println("Opcion incorrecta intente de nuevo");}
                    }
                }
            }
            else{System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.");}
            if (validacion_ingreso == 1){break;}
        }
    }    
}
