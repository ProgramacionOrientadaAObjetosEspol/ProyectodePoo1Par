package IntefazPrin;

//Declaracion de la clase

/**
 * Clase Normal que implementa la interfaz Volador 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class Normal implements Volador{
    
     //Declaracion de atributos
    
    /**
     * variable privada: Almancenara el tipo de deporte que practica el mago
     */
    private String deporte;

    //Declaracion de constructores 
    
    /**
     * Constructor Normal
     * @param deporte
     */
    public Normal(String deporte) {
        this.deporte = deporte;
    }

    /**
     * Constructor Normal sin parametros 
    */
    public Normal() {
    }
    

    //Declaracion de metodos 
    
    /**
     * Metodo getDeporte: devuelve el tipo de deporte que practica el mago
     * @return deporte 
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * Metodo setDeporte: establece el tipo de deporte que toma el mago a la variable 
     * del contructor
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    /**
     * Metodo volar: metodo sobrescrito encargado de imprimir un mensaje
     */
    @Override
    public void volar() {
        System.out.println("Vuela solo con ayuda de su escoba de modelo Nimbus 2000");
    }
    
    /**
     * Metodo despegar: metodo sobrescrito 
     */
    @Override
    public void despegar() {
        //
    }
    
    /**
     * Metodo toString: metodo sobrescrito que retorna un mensaje 
     * @return mensaje 
     */
    @Override
    public String toString(){
        return ("Un mago normal es un mago que no es animago ni metamorfomago");
    }
}
