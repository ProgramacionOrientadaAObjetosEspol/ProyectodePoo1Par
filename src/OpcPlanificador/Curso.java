/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Materias;
import proyectodepoo1par.ReadWriter;
public class Curso {
    
    private String fechaRegistro;
    Scanner t = new Scanner(System.in);

    public void crear(){   
        ArrayList<ArrayList<String>> lineas = new ArrayList<>();
        ArrayList<String> datos = new ArrayList<>();
        String nombres, apellidos;
        ReadWriter archivo = new ReadWriter();

        //variables
        int op_materias, op_profesor, op_capacidad;
        String op_dia, op_horario, op_crear, profesor;
        lineas = archivo.leerArchivo("profesores.txt");

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

        //Profesores
        System.out.println("/** Profesores **/ \n");
        n = 0;
        for (ArrayList<String> linea : lineas) {
            if (n != 0) {
                System.out.println(n + ". " + linea.get(0) + " " + linea.get(1));
            }
            n++;
        }
        System.out.print("Elija una profesor del listado de profesores: ");
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

        int op = 0;
        if (op_crear.equals("S")) {
            lineas.clear();
            lineas = archivo.leerArchivo("cursos.txt");
            for (ArrayList<String> linea : lineas) {
                if (((linea.get(3).equals(op_horario)) && (linea.get(2).equals(op_dia))) || (linea.get(0).equals(arr[op_materias - 1].toString()))) {
                    op++;
                }
            }
        } else {
            op++;
        }

        if (op == 0) {
            lineas.clear();
            System.out.println("Se ha creado el curso:");
            System.out.println("Materia:" + arr[op_materias - 1]);
            System.out.println("Profesor:" + nombres + " " + apellidos);
            System.out.println("Capacidad:" + op_capacidad);
            System.out.println("Horario:" + op_horario);
            System.out.println();

            datos.add(arr[op_materias - 1].toString());
            datos.add(nombres + " " + apellidos);
            datos.add(op_dia);
            datos.add(op_horario);
            datos.add(String.valueOf(op_capacidad));

            archivo.AgregarAlArchivo(datos, "cursos.txt");
        } else {
            System.out.println("No se ha creado el cursos\n");
        }
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
