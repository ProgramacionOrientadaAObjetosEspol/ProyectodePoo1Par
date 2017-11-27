package OpcEstudiante;

public class RolEstudiantes {
    
    public void VerCurso() {
        Planificacion p = new Planificacion();
        p.planificar();
        System.out.println(p.toString()+"\n");
    }

    public void registrar() {

    }

    public void describir(String usuario, String contraseña) {
        Vuelo v= null; 
        v.getNomApe();
        v.describir();
    }

}
