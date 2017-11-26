package proyectodepoo1par;

import IntefazPrin.*;
import java.util.Scanner;

public class Estudiante extends Miembros {
    Scanner datos = new Scanner(System.in);
    Normal normal = null;
    Metamorfomago metamorfomago = null;
    Animagos animago = null;
    
    public Estudiante(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }

    public Estudiante(int edad, String casa, String varita, String nombre, String apellido) {
        super(edad, casa, varita, nombre, apellido);
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
                animago = new Animagos();
                return animago;
            }
            else if (opc == 2) {
                metamorfomago = new Metamorfomago();
                return metamorfomago;
            }
            else if (opc == 3) {
                normal = new Normal();
                return normal;
            }
            else{
                System.out.println("Opcion incorrecta! ");
                return null;
            }
        }
    }
}
