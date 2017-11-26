package IntefazPrin;

public class Metamorfomago implements Volador {
    private String posión;

    public Metamorfomago(String posión) {
        this.posión = posión;
    }

    public Metamorfomago() {
    }

    public String getPosión() {
        return posión;
    }

    public void setPosión(String posión) {
        this.posión = posión;
    }

    @Override
    public void volar() {
        System.out.println("Vuela solo con su poder, sin varita ni escoba");
    }

    @Override
    public void despegar() {
        //
    }
    
    @Override
    public String toString(){
        return ("Un metamorfomago, es un mago o bruja que tiene la capacidad innata de cambiar su apariencia física según su voluntad");
    }
}
