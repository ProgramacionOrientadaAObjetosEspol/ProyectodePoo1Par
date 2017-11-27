
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class Curso {

    //atributos
    static Scanner t = new Scanner(System.in);
    int op = 0;
    ArrayList<String> datos = new ArrayList<>();
    static int op_materias, n = 1;;
    static Object[] arr = Materias.values();                //Materias en array

    
    //metodos
    public void crear() {
        //lineas de profesores
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        //lineas de cursos
        ArrayList<ArrayList<String>> lineas1 = new ArrayList<>();
        String nombres, apellidos;
        ReadWriter archivo = new ReadWriter();

        //variables
        int op_profesor, op_capacidad;
        String op_dia, op_horario, op_crear, profesor;
        lineas = archivo.leerArchivo("profesores.txt");
        lineas1 = archivo.leerArchivo("cursos.txt");

        //Elegir las materias
        eligirMateria();
        op = 0;
        
        for (ArrayList<String> linea : lineas1) {
            if (linea.get(0).equals(arr[op_materias - 1].toString())) {
                op++;
            }
        }
        
        if(op == 0){
                //Profesores
            System.out.println("/** Profesores **/ \n");
            n = 0;
            for (ArrayList<String> linea : lineas) {
                if (n != 0) {
                    System.out.println(n + ". " + linea.get(0) + " " + linea.get(1));
                }
                n++;
            }
            System.out.print("Elija un profesor del listado de profesores: ");
            op_profesor = t.nextInt();
            t.nextLine();

            //Capacidad
            System.out.print("\nIngrese la capacidad del curso para " + arr[op_materias - 1] + ": ");
            op_capacidad = t.nextInt();
            t.nextLine();

            //dia
            System.out.print("\nIngrese el dia: ");
            op_dia = t.nextLine();

            //horario
            System.out.print("\nIngrese el horario del curso: ");
            op_horario = t.nextLine();

            //crear
            System.out.print("\nDesea crear el curso con la informacion establecida? (S/N) ");
            op_crear = t.nextLine();
            System.out.println();

            //condicion
            nombres = lineas.get(op_profesor).get(0);
            apellidos = lineas.get(op_profesor).get(1);

            if (op_crear.equals("S")) {
                lineas.clear();
                for (ArrayList<String> linea : lineas1) {
                    if (((linea.get(3).equals(op_horario)) && (linea.get(2).equals(op_dia))) || (linea.get(0).equals(arr[op_materias - 1].toString()))) {
                        op++;
                    }
                }
            } else {
                op++;
            }

            //Guardando los datos
            if (op == 0) { 
                lineas1.clear();
                datos.add(arr[op_materias - 1].toString());
                datos.add(nombres + " " + apellidos);
                datos.add(op_dia);
                datos.add(op_horario);
                datos.add(String.valueOf(op_capacidad));

                archivo.AgregarAlArchivo(datos, "cursos.txt");
            }
        }else{ System.out.println("La materia ya tiene un curso");}
    }
    

    @Override
    public String toString() {
        if (op == 0) {
            return("Se ha creado el curso:\nMateria: " + datos.get(0) + "\nProfesor: " + datos.get(1) + "\nCapacidad: " + datos.get(4)+ "\nHorario: " + datos.get(3));
        } else {
            return("No se ha creado el cursos\n");
        }
    }

    public static void eligirMateria(){
        //Materias
        n =1;
        System.out.println("\n/** MATERIAS **/ \n");
        for (Object i : arr) {
            System.out.println(n + ". " + i);
            n++;
        }
        System.out.print("Elija una materia del listado de materias: ");
        op_materias = t.nextInt();
        t.nextLine();
        System.out.println("\n");
    }
}
