package Herramientas.Constructor.Patron;

import Herramientas.Constructor.CeldaDeConstruccion;
import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronHacha {
    private ArrayList<ArrayList<String>> patronesHacha;
    private TableroDeConstruccion tableroConstructor;

    private String materialMadera = "MADERA";
    private String materialPiedra = "PIEDRA";
    private String materialMetal = "METAL";
    private String materialVacio = "VACIO";

    //Se podría Separar en sus clases Correspondientes de manera polimorfica ó
    // aplicando el patrón de diseño "Strategy" para la construccion.
    private ArrayList<String> cargarPatronHachaMadera(){
        ArrayList<String> patronPicoMadera = new ArrayList<>();
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");

        return patronPicoMadera;
    }

    private boolean esPatronHachaMadera(TableroDeConstruccion tablero){
        ArrayList<String> patronHachaMadera = patronesHacha.get(0);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronHachaMadera.size(); i++) {
            //System.out.println("patronDePico: "+ patronHachaMadera.get(i));
            //System.out.println("patronDeTablero:" + patronDeTablero.get(i));
            if (!(patronHachaMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> cargarPatronHachaPiedra(){
        ArrayList<String> patronHachaPiedra = new ArrayList<>();
        patronHachaPiedra.add("PIEDRA");
        patronHachaPiedra.add("PIEDRA");
        patronHachaPiedra.add("VACIO");
        patronHachaPiedra.add("PIEDRA");
        patronHachaPiedra.add("MADERA");
        patronHachaPiedra.add("VACIO");
        patronHachaPiedra.add("VACIO");
        patronHachaPiedra.add("MADERA");
        patronHachaPiedra.add("VACIO");

        return patronHachaPiedra;
    }

    private boolean esPatronHachaPiedra(TableroDeConstruccion tablero){
        ArrayList<String> patronHachaDeMadera = patronesHacha.get(1);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronHachaDeMadera.size(); i++) {
            if (!(patronHachaDeMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> cargarPatronHachaMetal(){
        ArrayList<String> patronHachaMetal = new ArrayList<>();
        patronHachaMetal.add("METAL");
        patronHachaMetal.add("METAL");
        patronHachaMetal.add("VACIO");
        patronHachaMetal.add("METAL");
        patronHachaMetal.add("MADERA");
        patronHachaMetal.add("VACIO");
        patronHachaMetal.add("VACIO");
        patronHachaMetal.add("MADERA");
        patronHachaMetal.add("VACIO");

        return patronHachaMetal;
    }

    private boolean esPatronHachaMetal(TableroDeConstruccion tablero){
        ArrayList<String> patronHachaDeMadera = patronesHacha.get(2);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronHachaDeMadera.size(); i++) {
            if (!(patronHachaDeMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public TipoDeHerramienta construirHachaMadera(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hachaDeMadera = new Hacha(madera);
        return hachaDeMadera;
    }

    public TipoDeHerramienta construirHachaPiedra(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hachaDePiedra = new Hacha(piedra);
        return hachaDePiedra;
    }

    public TipoDeHerramienta construirHachaMetal(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hachaDeMetal = new Hacha(metal);
        return hachaDeMetal;
    }


    private void cargarPatronesHacha(){
        ArrayList<String> patronHachaMadera = cargarPatronHachaMadera();
        ArrayList<String> patronHachaPiedra = cargarPatronHachaPiedra();
        ArrayList<String> patronHachaMetal = cargarPatronHachaMetal();

        patronesHacha = new ArrayList<>();

        patronesHacha.add(patronHachaMadera);
        patronesHacha.add(patronHachaPiedra);
        patronesHacha.add(patronHachaMetal);
    }

    public PatronHacha(){
        cargarPatronesHacha();
    }

    public PatronHacha(TableroDeConstruccion tablero){
        cargarPatronesHacha();
        tableroConstructor = tablero;
    }

    /*
    public void imprimirPatronPico(ArrayList<String> patronPico){
        for (int j = 0; j < patronPico.size(); j++) {
            System.out.println("" + patronPico.get(j));
        }
    }


    public void imprimirPatronesPico(){
        //System.out.println("Cantidad De Patrones de Pico:" + cantidadDePatrones());
        for (int i = 0; i < patronesHacha.size(); i++) {
            ArrayList<String> patronPico = patronesHacha.get(i);
            for (int j = 0; j < patronPico.size(); j++) {
                System.out.println("" + patronPico.get(j));
            }
            System.out.println("******** OtroPatron *********");
        }
    }
    */

    private int cantidadDePatrones(){
        return patronesHacha.size();
    }

    public boolean esPatronHacha(){
        return ((esPatronHachaMadera(tableroConstructor)) ||
                (esPatronHachaPiedra(tableroConstructor)) ||
                (esPatronHachaMetal(tableroConstructor)));
    }

    public TipoDeHerramienta construirHacha(){
        if (esPatronHachaMadera(tableroConstructor)){
            TipoDeHerramienta hacha = construirHachaMadera();
            return hacha;
        }
        else if(esPatronHachaPiedra(tableroConstructor)){
            TipoDeHerramienta hachaPiedra = construirHachaPiedra();
            return hachaPiedra;
        }
        else if(esPatronHachaMetal(tableroConstructor)){
            TipoDeHerramienta hachaMetal = construirHachaMetal();
            return  hachaMetal;
        }
        return null;
    }

}
