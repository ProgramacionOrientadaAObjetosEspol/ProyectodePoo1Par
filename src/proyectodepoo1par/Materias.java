package proyectodepoo1par;

//Declaracion del Enum 

/**
 * Enum Materias 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public enum Materias {
    Pociones("Pociones"), DefensaContraLasArtesOscuras("Defensa contra las artes oscuras"), Adivinacion("Adivinacion"), Astronomia("Astronomia"), HistoriaDeLaMagia("HistoriaDeLaMagia"), Herbologia("Herbologia"), Encantamientos("Encantamientos"), Vuelo("Vuelo");
    
    //Declaracion de atributos
    
    /**
     * variable privada: Almancenara el nombre de la materia  
     */
    private String nom;
    
    //Declaracion del contructor
    
    /**
     * Constructor HechiceroPlanificador
     * @param nom nombre de la materia 
     */
    private Materias(String nom){this.nom = nom;}

    
    /**
     * Metodo toString: metodo sobrescrito que permite mostrar el nombre de la materia
     * con el formato de los espacios por palabra 
     * @return nombre de la materia seleccionada por el usuario 
     */
    @Override
    public String toString(){
        return nom;
    }
}   
