package OpcEstudiante;

import IntefazPrin.*;
import java.util.ArrayList;
import proyectodepoo1par.ReadWriter;
//import proyectodepoo1par.Rol;
import proyectodepoo1par.Estudiante;

public class Vuelo {

    //Rol rol = null; 
    Estudiante estudiante= null;
    Object tipo = null;
    private String usuario;
    private String  contraseña; 
    static String nombre;
    static String apellido; 
    private ArrayList<ArrayList<String>> lineasEstudiante = new ArrayList<>();
    private ArrayList<ArrayList<String>> lineasUsuario = new ArrayList<>();
    
    ReadWriter archivo = new ReadWriter();
    
    public Vuelo(String usuario, String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;
        
    }
    
    public void getNomApe(){
        lineasUsuario=archivo.leerArchivo("usuarios.txt");
        for (ArrayList<String> linea: lineasUsuario){
            if(linea.get(0).equals(usuario) && linea.get(1).equals(contraseña)){
                nombre=linea.get(2);
                apellido=linea.get(3);
            }
        }
    }
    
    public void describir() {
        
        lineasEstudiante=archivo.leerArchivo("estudiantes.txt");
        
        //String apellido=linea.get(3);
        
        for(ArrayList<String> lineaE: lineasEstudiante){
            if(nombre.equals(lineaE.get(0)) && apellido.equals(lineaE.get(1)) ){
                tipo= estudiante.TipoMago();
            }
        }
        if(tipo instanceof Animagos){
                System.out.println("Usted es un mago Animago, para volar necesita una varita");
            }else if(tipo instanceof Metamorfomago){
                System.out.println("Usted es un mago Metamorfomago, para volar necesita su poder");
            }else if(tipo instanceof Normal){
                System.out.println("Usted es un mago Normal, para volar necesita una Nimbus 2000");
            }
    }
    
   
    @Override
    public String toString() {
        return "";
    }
}
