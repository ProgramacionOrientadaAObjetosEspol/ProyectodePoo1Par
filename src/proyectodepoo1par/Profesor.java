package proyectodepoo1par;

import IntefazPrin.*;
import java.util.Scanner;

public class Profesor extends Miembros {
    Scanner datos = new Scanner(System.in);
    Normal normal = null;
    Metamorfomago metamorfomago = null;
    Animagos animago = null;
    private String fechaRegistro;

    public Profesor(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }

    public Profesor(String fechaRegistro, int edad, String casa, String varita, String nombre, String apellido) {
        super(edad, casa, varita, nombre, apellido);
        this.fechaRegistro = fechaRegistro;
    }
    
    public void tipoMago(){ 
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public Object TipoMago() {
        System.out.println("Tipos de Magos/Brujas");
        System.out.println("1. Animago \n2. Metamorfomago \n3. Normal ");
        System.out.print("Elija el tipo de mago/bruja que es: ");
        int opc = datos.nextInt();
        datos.nextLine();
        while (true) {

            if (opc == 1) {
                System.out.print("En que clase de animal puede convertirse?: ");
                String animal = datos.nextLine();
                               
                System.out.print("Ingrese su hechizo: ");
                String hechizo = datos.nextLine();
                animago = new Animagos(animal, hechizo);
                return animago;
            }
            else if (opc == 2) {
                System.out.print("Ingrese su pocion: ");
                String pocion = datos.nextLine();
                
                metamorfomago = new Metamorfomago(pocion);
                return metamorfomago;
            }
            else if (opc == 3) {
                System.out.print("Que clase de deporte practica: ");
                String deporte = datos.nextLine();
                
                normal = new Normal(deporte);
                return normal;
            }
            else{
                System.out.println("Opcion incorrecta! ");
                return null;
            }
        }
    }
    
    public String getAnimagoAnimal(){
        return (animago.getAnimal());
    }
    public String getAnimagoHechizo(){
        return (animago.getHechizo());
    }
    public String getMetamorfoPocion(){
        return (metamorfomago.getPosión());
    }
    public String getNormalDeporte(){
        return (normal.getDeporte());
    }
}

