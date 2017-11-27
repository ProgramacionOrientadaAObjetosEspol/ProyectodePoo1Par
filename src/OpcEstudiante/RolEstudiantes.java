package OpcEstudiante;

public class RolEstudiantes {
    
    public void VerCurso() {
        Planificacion p = new Planificacion();
        p.planificar();
        System.out.println(p.toString()+"\n");
    }

    public void registrar(String usuario, String contraseña) {
        Registro r = new Registro(usuario, contraseña);
        r.registrar();
        System.out.println(r.toString());
    }

    public void describir(String usuario, String contraseña) {
        Vuelo v= null; 
        v.getNomApe();
        v.describir();
    }

}
