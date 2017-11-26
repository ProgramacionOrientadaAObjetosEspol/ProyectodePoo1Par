package proyectodepoo1par;

import OpcPlanificador.RolPlanificador;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        
        
        //objetos
        ReadWriter archivo = new ReadWriter();
        RolPlanificador planificador = new RolPlanificador();
        
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
                    System.out.println("1. Crear Curso \n2. Crear Profesor \n3. Crear Estudiante \n4. Ver Horarios Planificados \n5. Listado de estudiantes ");
                    opcion = t.nextInt();
                    t.nextLine();
                    if(opcion == 1){planificador.crearCurso();}
                }else{
                    System.out.println("estudiante");
                }
            }
            else{System.out.println("El usuario o la contraseña no son válidos. Por favor intente otra vez.");break;}
        }
    }    
}
