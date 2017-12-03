package proyectodepoo1par;

//Declaracion de la clase

/**
 * Clase Miembros que hereda de la clase Rol 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class Miembros extends Rol {

    //Declaracion de atributos
    
    /**
     * variable privada: Almancenara la edad del usuario
     */
    private int edad;
    
    /**
     * variable privada: Almancenara la casa a la que pertenece el usuario
     */
    private String casa;
    
    /**
     * variable privada: Almancenara el tipo de varita del usuario
     */
    private String varita;

    //Declaracion de contructores
    
    /**
     * Constructor Miembros
     * @param usuario
     * @param contraseña
     * @param nombre
     * @param apellido
     * @param rol
     */
    public Miembros(String usuario, String contraseña, String nombre, String apellido, String rol, int edad, String casa, String varita) {
        super(usuario, contraseña, nombre, apellido, rol);
        this.edad = edad;
        this.casa = casa;
        this.varita = varita;
    }

    /**
     * Constructor Miembros
    * @param edad
     * @param casa
     * @param varita 
     */
    public Miembros(int edad, String casa, String varita, String nombre, String apellido) {
        super(nombre, apellido);
        this.edad = edad;
        this.casa = casa;
        this.varita = varita;
    }
    
    //Declaracion de metodos 
    
     /**
     * Metodo setEdad: establece el valor de edad a la variable del contructor
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
     /**
     * Metodo setCasa: establece el valor de casa a la variable del contructor
     */
    public void setCasa(String casa) {
        this.casa = casa;
    }

    
    /**
     * Metodo setVarita: establece el tipo de varita a la variable del contructor
     */
    public void setVarita(String varita) {
        this.varita = varita;
    }

    /**
     * Metodo getEdad: devuelve el valor de la edad 
     * @return edad 
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo getEdad: devuelve el tipo de casa 
     * @return casa 
     */
    public String getCasa() {
        return casa;
    }

    /**
     * Metodo getVarita: devuelve el tipo de varita 
     * @return varita 
     */
    public String getVarita() {
        return varita;
    }

    /**
     * Metodo TipoMago: devuelve el tipo de mago 
     * @return tipo de mago
     *         o null en caso de que no se asigne ningun valor 
     */
    @Override
    public Object TipoMago() {
        //Animagos, Metamorfomago y Normal
        return null;
    }

}
