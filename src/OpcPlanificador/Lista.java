package OpcPlanificador;

import static OpcPlanificador.Curso.t;
import java.util.ArrayList;
import proyectodepoo1par.ReadWriter;

public class Lista {

    ArrayList<ArrayList<String>> lineasRegistro = new ArrayList<>();
    ArrayList<ArrayList<String>> lineasEstudiante = new ArrayList<>();
    ArrayList<ArrayList<String>> Arraygeneral = new ArrayList<>();

    int contadorM = 0, opc;

    public void listar() {

        ReadWriter archivo = new ReadWriter();

        lineasRegistro = archivo.leerArchivo("registro.txt");
        lineasEstudiante = archivo.leerArchivo("estudiantes.txt");

        //Creamos un nuevo arrayList para poder agregar el ...
        //... nùmero de materias y manejarlo de forma mas sencilla
        for (ArrayList<String> dato : lineasEstudiante) {
            Arraygeneral.add(dato);
        }
        //agregamos la opcion de materias al nuevo arraylist, inicializandolo con 0
        for (int k = 0; k < Arraygeneral.size(); k++) {
            Arraygeneral.get(k).set(5, String.valueOf(0));
        }
        //Contamos en cuantas materias esta registrado cada alumno
        for (int i = 0; i < Arraygeneral.size(); i++) {
            for (int j = 0; j < lineasRegistro.size(); j++) {
                if (Arraygeneral.get(i).get(0).equals(lineasRegistro.get(j).get(1))) {
                    //Nos aseguramos de contar todos sus registros
                    if (Integer.parseInt(Arraygeneral.get(i).get(5)) > 0) {
                        int valor = (Integer.parseInt(Arraygeneral.get(i).get(5))) + 1;
                        Arraygeneral.get(i).set(5, String.valueOf(valor));
                    } else {
                        contadorM++;
                        Arraygeneral.get(i).set(5, String.valueOf(contadorM));
                        contadorM = 0;
                    }
                }
            }
        }
        System.out.println("/** LISTADO DE ESTUDIANTES **/");
        System.out.println("1. Edad \n2. Nombre \n3. Numero de materias registradas");
        System.out.println("");
        System.out.print("Elija el criterio para ordenar: ");
        opc = t.nextInt();
        t.nextLine();

        while (true) {
            //Opcion 1 - Ordena por edad
            if (opc == 1) {
                for (int i = 0; i < Arraygeneral.size(); i++) {
                    int pos = i; //tiene la posicion del arraylist
                    ArrayList<String> aux = Arraygeneral.get(i); //arrayList
                    int valor = Integer.parseInt(Arraygeneral.get(i).get(2));  //valor de edad del arraylist
                    while ((pos > 0) && ((Integer.parseInt(Arraygeneral.get(pos - 1).get(2))) > valor)) {
                        Arraygeneral.set(pos, Arraygeneral.get(pos - 1));
                        Arraygeneral.set(pos - 1, aux);
                        pos--;
                    }
                } //Ordena por nombre si la edad es igual
                for (int i = 0; i < Arraygeneral.size(); i++) {
                    int pos1 = i; //tiene la posicion del primer arraylist
                    ArrayList<String> aux = Arraygeneral.get(i); //primer arrayList
                    String nombre1 = Arraygeneral.get(i).get(0);
                    while ((pos1 > 0) && ((Integer.parseInt(Arraygeneral.get(pos1).get(2))) == (Integer.parseInt(Arraygeneral.get(pos1 - 1).get(2))))) {
                        int valor = Arraygeneral.get(i - 1).get(0).compareTo(nombre1);
                        if (valor >= 0) {
                            Arraygeneral.set(pos1, Arraygeneral.get(pos1 - 1));
                            Arraygeneral.set(pos1 - 1, aux);
                        }
                        pos1--;
                    }
                }
                for (ArrayList<String> linea : Arraygeneral) {
                    System.out.println(linea.get(0) + " " + linea.get(1) + " -- " + linea.get(2) + " años" + " -- " + linea.get(4) + " -- " + linea.get(5) + " materias");
                }
                return;
            }
            //Opcion 2 - Ordena por nombre
            if (opc == 2) {
                System.out.println("");
                for (int i = 0; i < Arraygeneral.size(); i++) {
                    int pos1 = i; //tiene la posicion del  arraylist
                    ArrayList<String> aux = Arraygeneral.get(i); // arrayList
                    String nombre1 = Arraygeneral.get(i).get(0);
                    while ((pos1 > 0) && (nombre1.compareTo(Arraygeneral.get(pos1 - 1).get(0)) < 0)) {
                        Arraygeneral.set(pos1, Arraygeneral.get(pos1 - 1));
                        Arraygeneral.set(pos1 - 1, aux);
                        pos1--;
                    }
                }
                for (ArrayList<String> linea : Arraygeneral) {
                    System.out.println(linea.get(0) + " " + linea.get(1) + " -- " + linea.get(2) + " años" + " -- " + linea.get(4) + " -- " + linea.get(5) + " materias");
                }
                return;
            }
            //Opcion 3 - Ordena por materias registradas
            if (opc == 3) {
                System.out.println("");
                for (int i = 0; i < Arraygeneral.size(); i++) {
                    int pos2 = i; //tiene la posicion del primer arraylist
                    ArrayList<String> aux = Arraygeneral.get(i); //primer arrayList
                    int valor = Integer.parseInt(Arraygeneral.get(i).get(5));  //valor de edad del primer arraylist
                    while ((pos2 > 0) && ((Integer.parseInt(Arraygeneral.get((pos2 - 1)).get(5))) > valor)) {
                        Arraygeneral.set(pos2, Arraygeneral.get(pos2 - 1));
                        Arraygeneral.set(pos2 - 1, aux);
                        pos2--;
                    }
                } //Ordena por nombre si las materias registradas son iguales
                for (int i = 0; i < Arraygeneral.size(); i++) {
                    int pos1 = i; //tiene la posicion del primer arraylist
                    ArrayList<String> aux = Arraygeneral.get(i); //primer arrayList
                    String nombre1 = Arraygeneral.get(i).get(0);
                    while ((pos1 > 0) && ((Integer.parseInt(Arraygeneral.get(pos1).get(5))) == (Integer.parseInt(Arraygeneral.get(pos1 - 1).get(5))))) {
                        int valor = Arraygeneral.get(i - 1).get(0).compareTo(nombre1);
                        if (valor >= 0) {
                            Arraygeneral.set(pos1, Arraygeneral.get(pos1 - 1));
                            Arraygeneral.set(pos1 - 1, aux);
                        }
                        pos1--;
                    }
                }
                for (ArrayList<String> linea : Arraygeneral) {
                    System.out.println(linea.get(0) + " " + linea.get(1) + " -- " + linea.get(2) + " años" + " -- " + linea.get(4) + " -- " + linea.get(5) + " materias");
                }
                return;
            }
        }
    }

//    @Override
//    public String toString() {
//        for (ArrayList<String> linea : Arraygeneral) {
//            return (linea.get(0) + " " + linea.get(1) + " -- " + linea.get(2) + " años" + " -- " + linea.get(4) + " -- " + linea.get(5) + " materias");
//        }
//        return null;
//
//    }
}
