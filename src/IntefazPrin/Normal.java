package IntefazPrin;

public class Normal implements Volador{
    private String deporte;

    public Normal(String deporte) {
        this.deporte = deporte;
    }

    public Normal() {
    }
    

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public void volar() {
        System.out.println("Vuela solo con ayuda de su escoba de modelo Nimbus 2000");
    }

    @Override
    public void despegar() {
        //
    }
    
    @Override
    public String toString(){
        return ("Un mago normal es un mago que no es animago ni metamorfomago");
    }
}
