package IntefazPrin;

public class Animagos implements Volador{
    private String animal;
    private String hechizo;

    public Animagos(String animal, String hechizo) {
        this.animal = animal;
        this.hechizo = hechizo;
    }

    public Animagos() {
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getHechizo() {
        return hechizo;
    }

    public void setHechizo(String hechizo) {
        this.hechizo = hechizo;
    }

    @Override
    public void volar() {
        System.out.println("Vuela con ayuda de la varita");
    }

    @Override
    public void despegar() {
        //
    }
    
    @Override
    public String toString(){
        return ("Un animago es una bruja o mago con la capacidad de transformarse en un animal");
    }
}
