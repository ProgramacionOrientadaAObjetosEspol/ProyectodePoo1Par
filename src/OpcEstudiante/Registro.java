package OpcEstudiante;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class Registro {
    //Atributos
    private String usuario, contraseña;
    public static String nombre, apellido, fecha;
    static Scanner t = new Scanner(System.in);
    ReadWriter archivo = null;
    static int op_materias, extraodinario= 0;
    static String op_crear;
    ArrayList<ArrayList<String>> lineas = null;             //lineas de cursos
    ArrayList<ArrayList<String>> lineas1 = null;            //lineas de estudiantes
    ArrayList<String> lineas2 = null;            //Lineas a registar
    static Object[] arr = Materias.values();                //Materias en array

    public Registro(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Metodos
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

    @Override
    public String toString() {
        if (op_crear.equals("S")) {
            return "Se ha registrado en la materia";
        } else {
            return "No se ha registrado en la materia";
        }
    }
    
    public void registrarArchivo(){
        lineas2 = new ArrayList<>();
//FECHA


        lineas2.add(fecha);
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
    
    //Obtener nombre y apellido
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

//Aumentar el numero ede registrados en ese curso
//REgistrar la fecha