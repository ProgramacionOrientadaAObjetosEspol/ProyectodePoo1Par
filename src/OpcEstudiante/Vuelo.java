package OpcEstudiante;

import java.util.ArrayList;
import proyectodepoo1par.ReadWriter;
import IntefazPrin.*;

//Declaracion de la clase
/**
 * Clase Planificacion 
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 02/12/17
 */
public class Vuelo {
    
    //Declaracion de atributos
    
    /**
     * variable privada: Almancenara el tipo de animal
     */
    
    Object tipo = null;
    
    /**
     * variable privada: Almancenara el usuario
     */
    private String usuario;
    
    /**
     * variable privada: Almancenara la contraseña
     */
    private String  contraseña; 
    
    /**
     * variable estatica nombre: Almacena el nombre del usuario
     */
    static String nombre;
    
    /**
     * variable estatica apellido: Almacena la contraseña del usuario 
     */
    static String apellido; 
    
    /**
     * variable privada lineasEstudiante: Almacenara las lineas del archivo "estudiantes.txt"
     */
    private ArrayList<ArrayList<String>> lineasEstudiante = new ArrayList<>();
    
    /**
     * variable privada lineasUsuario: Almacenara las lineas del archivo "usuario.txt"
     */
    private ArrayList<ArrayList<String>> lineasUsuario = new ArrayList<>();
    
    /**
     * variable tipoMago: Almacenara el tipo de mago del estudiante
     */
    String tipoMago;
    
    /**
     * variable volar: Almacenara la breve descripcion del tipo de mago
     */
    String volar;
    
    ReadWriter archivo = new ReadWriter();
    
    /**
     * Constructor Vuelo
     * @param usuario
     * @param contraseña
     */
    public Vuelo(String usuario, String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;
        
    }
    
    /**
     * Metodo que permite leer el archivo "usuarios.txt" para establecer el
     * nombre y apellido del usuario que ingreso
     */
    public void getNomApe(){
        lineasUsuario=archivo.leerArchivo("usuarios.txt");
        for (ArrayList<String> linea: lineasUsuario){
            if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){
                nombre=linea.get(2);
                apellido=linea.get(3);
            }
        }
        lineasUsuario.clear();  //liberamos memoria
    }
    
    /**
     * Metodo que permite identificar que tipo de mago es el usuario e identificando
     * cual es su capacidad de volar
     */
    public void describir() {
        lineasEstudiante=archivo.leerArchivo("estudiantes.txt");
        getNomApe();
        
        for(ArrayList<String> lineaE: lineasEstudiante){
            if(nombre.equals(lineaE.get(0)) && apellido.equals(lineaE.get(1)) ){
                tipoMago = lineaE.get(5);
            }
        }
        lineasEstudiante.clear();   //liberamos memoria
        if(tipoMago.equals("A")){   
            tipoMago = "animago";
            volar = new Animagos().volar();
        }else if(tipoMago.equals("M")){
            tipoMago = "metamorfomago";
            volar = new Metamorfomago().volar();
        }else{
            tipoMago = "mago normal";
            volar = new Normal().volar();
        }
    }
    
   
    @Override
    public String toString() {
        return "Usted es un "+ tipoMago +", "+volar;
    }
}
