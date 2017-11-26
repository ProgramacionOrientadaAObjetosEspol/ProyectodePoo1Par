
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.ReadWriter;


public class ProfesorRegistro {
    
    private String fechaRegistro;
    
    
    public ArrayList<String> crearLista(String nombre,String apellido,String edad, String varita,String fechaIngreso, String tipo,String animal,String hechizo, String pocion, String deporte){
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
        
        
        return listaDatos;
    }   
    
    
    public void crear(){
        
        ArrayList<String> informacion = new ArrayList<>();
        ProfesorRegistro ob = new ProfesorRegistro();
        
        
        System.out.println("CREAR PROFESOR");
        Scanner datos = new Scanner(System.in);
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
        String fecha = datos.nextLine();

        System.out.println("Tipos de Magos/Brujas");
        System.out.println("1. Animago \n2. Metamorfomago \n3. Normal ");
        System.out.println("");
        System.out.print("Elija el tipo de mago/bruja que es: ");
        int opc = datos.nextInt();
        datos.hasNextLine();
        while (true) {
            Scanner val = new Scanner(System.in);
            if (opc == 1) {
                System.out.print("En que clase de animal puede convertirse?: ");
                String animal = val.nextLine();
                               
                System.out.print("Ingrese su hechizo: ");
                String hechizo = val.nextLine();
                //Animagos animago = new Animagos(animal, null);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,fecha,"A",animal,hechizo,"null","null");
                
                break;
            }
            if (opc == 2) {
                System.out.print("Ingrese su pocion: ");
                String pocion = val.nextLine();
                
                //Metamorfomago metamorfomago = new Metamorfomago(pocion);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,fecha,"M","null","null",pocion,"null");
                break;
            }
            if (opc == 3) {
                System.out.print("Que clase de deporte practica: ");
                String deporte = val.nextLine();
                
                //Normal normal = new Normal(deporte);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,fecha,"N","null","null","null",deporte);
                break;
            }
            else{
                System.out.println("Opcion incorrecta! ");
        }
    }   
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
