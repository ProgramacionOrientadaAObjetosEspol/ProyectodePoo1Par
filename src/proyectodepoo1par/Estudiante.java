package proyectodepoo1par;

public class Estudiante extends Miembros {
    
    public Estudiante(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
    }
    
    @Override
    public void TipoMago() {
        //Animagos, Metamorfomago y Normal
    }
}
