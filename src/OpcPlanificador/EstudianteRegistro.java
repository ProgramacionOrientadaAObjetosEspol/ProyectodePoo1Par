
package OpcPlanificador;

import IntefazPrin.*;
import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Estudiante;
import proyectodepoo1par.ReadWriter;


public class EstudianteRegistro {
    Scanner datos = new Scanner(System.in);
    String op_crear = "";
    Estudiante estudiante =null;
    Object tipo = null;
    
    public void crearLista(String nombre,String apellido,String edad, String varita,String casa,String tipo){
        ReadWriter archivo = new ReadWriter();
        
        ArrayList<String> listaDatos = new ArrayList<>();
        listaDatos.add(nombre);
        listaDatos.add(apellido);
        listaDatos.add(edad);
        listaDatos.add(varita);
        listaDatos.add(casa);
        listaDatos.add(tipo);
        
        archivo.AgregarAlArchivo(listaDatos, "estudiantes.txt");
    }   
    
    public void pedirDatos(){
        System.out.println("CREAR ESTUDIANTE");
        System.out.print("Ingrese nombre: ");
        String nombre = datos.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = datos.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = datos.nextInt();
        datos.nextLine();
        System.out.print("Varita: ");
        String varita = datos.nextLine();
        System.out.print("Casa: ");
        String casa = datos.nextLine();
        
        estudiante = new Estudiante(edad, casa, varita, nombre, apellido);
    }
    
    public void crear(){   
        pedirDatos();
        tipo = estudiante.TipoMago();
        
        //crear
        System.out.print("\n¿Desea guardar los datos? (S/N) ");
        op_crear = datos.nextLine();
        System.out.println();
        
        if(op_crear.equals("S")){
            if(tipo instanceof Animagos){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"A");
            }else if(tipo instanceof Metamorfomago){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"M");
            }else if(tipo instanceof Normal){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"N");
            }
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
