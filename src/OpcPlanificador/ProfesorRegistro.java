
package OpcPlanificador;

import IntefazPrin.*;
import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Profesor;
import proyectodepoo1par.ReadWriter;


public class ProfesorRegistro {
    Scanner datos = new Scanner(System.in);
    String op_crear ="";
    Profesor profesor = null;
    Object tipo = null;
    
    public void crearLista(String nombre,String apellido,String edad, String varita,String fechaIngreso, String tipo,String animal,String hechizo, String pocion, String deporte){
        ReadWriter archivo = new ReadWriter();
        
        ArrayList<String> listaDatos = new ArrayList<>();
        listaDatos.add(nombre);
        listaDatos.add(apellido);
        listaDatos.add(edad);
        listaDatos.add(varita);
        listaDatos.add(fechaIngreso);
        listaDatos.add(tipo);
        listaDatos.add(animal);
        listaDatos.add(hechizo);
        listaDatos.add(pocion);
        listaDatos.add(deporte);
        
        archivo.AgregarAlArchivo(listaDatos, "profesores.txt");
    }   
    
    public void pedirDatos(){
        System.out.println("CREAR PROFESOR");
        System.out.print("Ingrese nombre: ");
        String nombre = datos.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = datos.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = datos.nextInt();
        datos.nextLine();
        System.out.print("Varita: ");
        String varita = datos.nextLine();
        System.out.print("Fecha de ingreso: ");
        String fechaRegistro = datos.nextLine();
        
        profesor = new Profesor(fechaRegistro,edad, "null", varita, nombre, apellido);
    }
    
    public void crear(){
        pedirDatos();
        tipo = profesor.TipoMago();

        //crear
        System.out.print("\n¿Desea guardar los datos? (S/N) ");
        op_crear = datos.nextLine();
        System.out.println();
        
        if(op_crear.equals("S")){
            if(tipo instanceof Animagos){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "A", profesor.getAnimagoAnimal(), profesor.getAnimagoHechizo(),"null","null");
            }else if(tipo instanceof Metamorfomago){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "M", "null","null",profesor.getMetamorfoPocion(),"null");
            }else if(tipo instanceof Normal){
                crearLista(profesor.getNombre(), profesor.getApellido(), String.valueOf(profesor.getEdad()), profesor.getVarita(), profesor.getFechaRegistro(), "N", "null","null","null", profesor.getNormalDeporte());
            }
            System.out.println("Sus datos se han guardado correctamente\n");
        }
    }

    @Override
    public String toString() {
        if(op_crear.equals("S")){
            return("Sus datos se han guardado correctamente.\n");
        }else {
            return("No se han gurdado sus datos.\n");
        }   
    }
    
    
}
