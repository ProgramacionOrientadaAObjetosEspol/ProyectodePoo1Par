package proyectodepoo1par;

public enum Materias {
    Pociones("Pociones"), DefensaContraLasArtesOscuras("Defensa contra las artes oscuras"), Adivinacion("Adivinacion"), Astronomia("Astronomia"), HistoriaDeLaMagia("HistoriaDeLaMagia"), Herbologia("Herbologia"), Encantamientos("Encantamientos"), Vuelo("Vuelo");
    private String nom;
    private Materias(String nom){this.nom = nom;}

    @Override
    public String toString(){
        return nom;
    }
    
    
}   
