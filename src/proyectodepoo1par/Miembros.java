package proyectodepoo1par;

public class Miembros extends Rol {

    private int edad;
    private String casa;
    private String varita;

    public Miembros(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol);
        this.edad = edad;
        this.casa = casa;
        this.varita = varita;
    }

    public Miembros(int edad, String casa, String varita, String nombre, String apellido) {
        super(nombre, apellido);
        this.edad = edad;
        this.casa = casa;
        this.varita = varita;
    }
    
    

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void setVarita(String varita) {
        this.varita = varita;
    }

    public int getEdad() {
        return edad;
    }

    public String getCasa() {
        return casa;
    }

    public String getVarita() {
        return varita;
    }

    @Override
    public Object TipoMago() {
        //Animagos, Metamorfomago y Normal
        return null;
    }

}
