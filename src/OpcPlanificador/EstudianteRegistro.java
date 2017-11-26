
package OpcPlanificador;

import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.ReadWriter;


public class EstudianteRegistro {
    
    public ArrayList<String> crearLista(String nombre,String apellido,String edad, String varita,String casa,String tipo){
        ReadWriter archivo = new ReadWriter();
        
        ArrayList<String> listaDatos = new ArrayList<>();
        listaDatos.add(nombre);
        listaDatos.add(apellido);
        listaDatos.add(edad);
        listaDatos.add(varita);
        listaDatos.add(casa);
        listaDatos.add(tipo);
        
        archivo.AgregarAlArchivo(listaDatos, "estudiantes.txt");
        
        
        return listaDatos;
    }   
    public void crear(){   
        ArrayList<String> informacion = new ArrayList<>();
        EstudianteRegistro ob = new EstudianteRegistro();
        
        
        System.out.println("CREAR ESTUDIANTE");
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
        System.out.print("Casa: ");
        String casa = datos.nextLine();

        System.out.println("Tipos de Magos/Brujas");
        System.out.println("1. Animago \n2. Metamorfomago \n3. Normal ");
        System.out.println("");
        System.out.print("Elija el tipo de mago/bruja que es: ");
        int opc = datos.nextInt();
        datos.hasNextLine();
        while (true) {
            Scanner val = new Scanner(System.in);
            if (opc == 1) {
                //Animagos animago = new Animagos(animal, null);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,casa,"A");
                
                break;
            }
            if (opc == 2) {
                //Metamorfomago metamorfomago = new Metamorfomago(pocion);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,casa,"M");
                break;
            }
            if (opc == 3) {
                //Normal normal = new Normal(deporte);
                ob.crearLista(nombre,apellido,String.valueOf(edad),varita,casa,"N");
                break;
            }
            else{
                System.out.println("Opcion incorrecta! ");
    }
    
}}}
