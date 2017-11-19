package proyectodepoo1par;

public class Profesor extends Miembros {
    
    private String fechaRegistro;

    public Profesor(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol, edad, casa, varita);
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
    public void TipoMago() {
        //Animagos, Metamorfomago y Normal
    }
}

