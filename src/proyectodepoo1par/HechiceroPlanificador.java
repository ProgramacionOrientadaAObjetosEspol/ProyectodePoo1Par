package proyectodepoo1par;

public class HechiceroPlanificador extends Rol {

    public HechiceroPlanificador(String usuario, String contraseña, String nombre, String apellido, String rol) {
        super(usuario, contraseña, nombre, apellido, rol);
    }

    @Override
    public Object TipoMago() {
        //Animagos, Metamorfomago y Normal
        return null;
    }
}
