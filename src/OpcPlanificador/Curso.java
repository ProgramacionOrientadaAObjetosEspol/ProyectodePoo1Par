
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;

public class Curso {

    //atributos
    Scanner t = new Scanner(System.in);
    int op = 0;
    ArrayList<String> datos = new ArrayList<>();

    //metodos
    public void crear() {
        //lineas de profesores
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        //lineas de cursos
        ArrayList<ArrayList<String>> lineas1 = new ArrayList<>();
        String nombres, apellidos;
        ReadWriter archivo = new ReadWriter();

        //variables
        int op_materias, op_profesor, op_capacidad;
        String op_dia, op_horario, op_crear, profesor;
        lineas = archivo.leerArchivo("profesores.txt");
        lineas1 = archivo.leerArchivo("cursos.txt");

        Object[] arr = Materias.values();        //Materias en array

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

        //Para verificar que ya está esa materia
        //Ya que solo se puede crear un curso por materia
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
        System.out.println();
        //borramos las lineas en la memoria

        //Capacidad
        System.out.print("Ingrese la capacidad del curso para " + arr[op_materias - 1] + ": ");
        op_capacidad = t.nextInt();
        t.nextLine();
        System.out.println();

        //dia
        System.out.print("Ingrese el dia: ");
        op_dia = t.nextLine();
        System.out.println();

        //horario
        System.out.print("Ingrese el horario del curso: ");
        op_horario = t.nextLine();
        System.out.println();

        //crear
        System.out.print("Desea crear el curso con la informacion establecida? (S/N) ");
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

        if (op == 0) { //Guardando los datos
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

}
