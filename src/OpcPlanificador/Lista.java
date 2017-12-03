package OpcPlanificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import proyectodepoo1par.Principal;
import proyectodepoo1par.ReadWriter;

//Declaracion de la clase

/**
 * Clase Lista
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */

public class Lista {
    Scanner t = new Scanner(System.in);
    ArrayList<ArrayList<String>> lineasRegistro = null;
    ArrayList<ArrayList<String>> lineasEstudiante = null;
    ArrayList<ArrayList<String>> Arraygeneral = new ArrayList<>();
    ArrayList<ArrayList<String>> ordenado = new ArrayList<>();
    ReadWriter archivo = new ReadWriter();

    int contadorM = 0, opc;

    //Declaracion de metodos
    
    /**
     * Metodo listar: permite ordenar a los estudiantes registrados de acuerdo a
     * el criterio que elija el usuario planificador ya sea por: edad, nombre o 
     * materias registradas
     * objecto archivo de la clase ReadWriter 
     */
    
    public void listar() {

        obtenerEstudiante();
        obtenerregistro();
        
        while (true) {
            System.out.println("/** LISTADO DE ESTUDIANTES **/");
            System.out.println("1. Edad \n2. Nombre \n3. Numero de materias registradas");
            System.out.println("");
            System.out.print("Elija el criterio para ordenar: ");
            opc = 0;
            while(opc == 0){
                String n1 = t.nextLine();
                opc = Integer.parseInt(new Principal().validarNumero(n1));
                if(opc == 0){System.out.print("Intente de nuevo!\n\nElija un profesor del listado de profesores: ");}
            }
            //Opcion 1 - Ordena por edad
            if (opc == 1) {
                ArrayList<String> contenedor = null;
                contenedor = ordenarNum(2);         //Representa la posicion de cantidad de materia
                ordenarArray(contenedor);
                ordenaSegunParametro(2);
                ordenaSegunApellido();
                
                break;
            }
            //Opcion 2 - Ordena por nombre
            if (opc == 2) {
                
                ArrayList<String> contenedor = null;
                contenedor = ordenarTex(0);        //Representa la posicion de nombre             
                
                ordenarArray(contenedor);
                ordenaSegunApellido();
                               
                break;
            }
            //Opcion 3 - Ordena por materias registradas
            if (opc == 3) {
                ArrayList<String> contenedor = null;
                contenedor = ordenarNum(4);         //Representa la posicion de cantidad de materia    
                ordenarArray(contenedor);
                ordenaSegunParametro(4);
                ordenaSegunApellido();
                break;
            }
            else{System.out.println("Error intente de nuevo.\n");}
        }
    }

    @Override
    public String toString() {
        for (ArrayList<String> linea : ordenado) {
            System.out.println(linea.get(0) + " " + linea.get(1) + " -- " + linea.get(2) + " años" + " -- " + linea.get(3) + " -- " + linea.get(4) + " materias");
        }
        return "";
    }
      
    public ArrayList<String> ordenarTex(int tipo){
        ArrayList<String> contenedor = new ArrayList<>();
        for (ArrayList<String> dato : Arraygeneral) {
            contenedor.add(dato.get(tipo));
        }
        Collections.sort(contenedor);
        return contenedor;
    }
        
    public ArrayList<String> ordenarNum(int tipo){
        ArrayList<String> contenedor = new ArrayList<>();
        for (ArrayList<String> dato : Arraygeneral) {
            contenedor.add(dato.get(tipo));
        }
        Collections.sort(contenedor, (String p1, String p2) -> new Integer(p1).compareTo(new Integer(p2)));    //lambda
        return contenedor;
    }
    
    public void ordenarArray(ArrayList<String> contenedor){
        //Recorremos la lista ordenada
        for (String dato : contenedor) {
            for (ArrayList<String> linea : Arraygeneral) {
                //Si esa edad esta en esa linea
                if (linea.indexOf(dato)!=-1){
                    if(!ordenado.contains(linea)){ordenado.add(linea);break;}
                }
            }
        }
    }
    
    /*
    * Creamos un nuevo arrayList para poder agregar el 
    * nùmero de materias y manejarlo de forma mas sencilla
    */
    public void obtenerEstudiante(){
        lineasEstudiante = archivo.leerArchivo("estudiantes.txt");

        for (ArrayList<String> dato : lineasEstudiante) {
            ArrayList<String> contenedor = new ArrayList<>();
            contenedor.add(dato.get(0));
            contenedor.add(dato.get(1));
            contenedor.add(dato.get(2));
            contenedor.add(dato.get(4));
            contenedor.add("0");
            Arraygeneral.add(contenedor);
        }
        lineasEstudiante.clear();           //liberar esa memoria
    }
    
    /*
    * Contamos en cuantas materias esta registrado cada alumno
    */
    public void obtenerregistro(){
        lineasRegistro = archivo.leerArchivo("registro.txt");
        
        for (int i = 0; i < Arraygeneral.size(); i++) {
            for (int j = 0; j < lineasRegistro.size(); j++) {
                if (Arraygeneral.get(i).get(0).equals(lineasRegistro.get(j).get(1)) && Arraygeneral.get(i).get(1).equals(lineasRegistro.get(j).get(2))) {
                    //Nos aseguramos de contar todos sus registros
                    int valor = (Integer.parseInt(Arraygeneral.get(i).get(4)));
                    Arraygeneral.get(i).set(4, String.valueOf(valor+=1));
                }
            }
        }
        lineasRegistro.clear();           //liberar esa memoria
    }
    /*
    * Permite ordenar por nombre si edad o materias son iguales
    */
    public void ordenaSegunParametro(int parametro) {
        for (int i = 0; i < ordenado.size(); i++) {
            int pos1 = i; //tiene la posicion del primer arraylist
            ArrayList<String> aux = ordenado.get(i); //primer arrayList
            String nombre1 = aux.get(0);
            while ((pos1 > 0) && ((Integer.parseInt(ordenado.get(pos1).get(parametro))) == (Integer.parseInt(ordenado.get(pos1 - 1).get(parametro))))) {
                ArrayList<String> espacio = new ArrayList<>();
                espacio.add(ordenado.get(pos1).get(0));
                espacio.add(ordenado.get(pos1-1).get(0));
                Collections.sort(espacio);
                if(nombre1.equals(espacio.get(0))){
                    ordenado.set(pos1, ordenado.get(pos1 - 1));
                    ordenado.set(pos1 - 1, aux);
                }
                pos1--;
            }
        }
    }
    
    /*
    *Ordena por apellido despues de ordenar por nombre
    */
    public void ordenaSegunApellido(){
        for (int i = 0; i < ordenado.size(); i++) {
            int pos1 = i; //tiene la posicion del  arraylist
            ArrayList<String> aux = ordenado.get(i); // arrayList
            String nombre1 = ordenado.get(i).get(0);
            while ((pos1 > 0) && (nombre1.equals(ordenado.get(i - 1).get(0)))) {
                int valor = ordenado.get(i - 1).get(1).compareTo(ordenado.get(i).get(1));
                if (valor >= 0) {
                    ordenado.set(pos1, ordenado.get(pos1 - 1));
                    ordenado.set(pos1 - 1, aux);
                }
                pos1--;
            }
        }
    }
}
