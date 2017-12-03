package IntefazPrin;

//Declaracion de la clase

/**
 * Clase Metamorfomago que implementa la interfaz Volador 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class Metamorfomago implements Volador {
    
    //Declaracion de atributos
    
    /**
     * variable privada: Almancenara el tipo de posion que toma el mago
     */
    private String posión;

    //Declaracion de constructores 
    
    /**
     * Constructor Metamorfomago
     * @param posión
     */
    public Metamorfomago(String posión) {
        this.posión = posión;
    }

    /**
     * Constructor Metamorfomago sin parametros 
    */
    public Metamorfomago() {
    }

     //Declaracion de metodos 
    
    /**
     * Metodo getPosión: devuelve el tipo de posión que toma el mago
     * @return posión 
     */
    public String getPosión() {
        return posión;
    }

    /**
     * Metodo setPosión: establece el tipo de posión que toma el mago a la variable 
     * del contructor
     */
    public void setPosión(String posión) {
        this.posión = posión;
    }

    /**
     * Metodo volar: metodo sobrescrito encargado de imprimir un mensaje
     */
    @Override
    public void volar() {
        System.out.println("Vuela solo con su poder, sin varita ni escoba");
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
        return ("Un metamorfomago, es un mago o bruja que tiene la capacidad innata de cambiar su apariencia física según su voluntad");
    }
}
