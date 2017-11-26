package proyectodepoo1par;

public class Rol {
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String rol; //Estudiante y Hechicero Planificador

    public Rol(String usuario, String contraseña, String nombre, String apellido, String rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public Rol(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public Object TipoMago(){
        //Animagos, Metamorfomago y Normal
        return null;
    }
}
