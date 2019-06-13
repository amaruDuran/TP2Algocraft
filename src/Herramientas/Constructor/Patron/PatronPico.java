package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPico {
    private ArrayList<ArrayList<String>> patronesPico;
    private TableroDeConstruccion tableroConstructor;


    //Se podría Separar en sus clases Correspondientes de manera polimorfica ó
    // aplicando el patrón de diseño "Strategy" para la construccion.
    private ArrayList<String> cargarPatronPicoMadera(){
        ArrayList<String> patronPicoMadera = new ArrayList<>();
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("VACIO");
        patronPicoMadera.add("MADERA");
        patronPicoMadera.add("VACIO");

        return patronPicoMadera;
    }

    private boolean esPatronPicoMadera(TableroDeConstruccion tablero){
        ArrayList<String> patronPicoDeMadera = patronesPico.get(0);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronPicoDeMadera.size(); i++) {
            if (!(patronPicoDeMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> cargarPatronPicoPiedra(){
        ArrayList<String> patronPicoPiedra = new ArrayList<>();
        patronPicoPiedra.add("PIEDRA");
        patronPicoPiedra.add("PIEDRA");
        patronPicoPiedra.add("PIEDRA");
        patronPicoPiedra.add("VACIO");
        patronPicoPiedra.add("MADERA");
        patronPicoPiedra.add("VACIO");
        patronPicoPiedra.add("VACIO");
        patronPicoPiedra.add("MADERA");
        patronPicoPiedra.add("VACIO");

        return patronPicoPiedra;
    }

    private boolean esPatronPicoPiedra(TableroDeConstruccion tablero){
        ArrayList<String> patronPicoDeMadera = patronesPico.get(1);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronPicoDeMadera.size(); i++) {
            if (!(patronPicoDeMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> cargarPatronPicoMetal(){
        ArrayList<String> patronPicoMetal = new ArrayList<>();
        patronPicoMetal.add("METAL");
        patronPicoMetal.add("METAL");
        patronPicoMetal.add("METAL");
        patronPicoMetal.add("VACIO");
        patronPicoMetal.add("MADERA");
        patronPicoMetal.add("VACIO");
        patronPicoMetal.add("VACIO");
        patronPicoMetal.add("MADERA");
        patronPicoMetal.add("VACIO");

        return patronPicoMetal;
    }

    private boolean esPatronPicoMetal(TableroDeConstruccion tablero){
        ArrayList<String> patronPicoDeMadera = patronesPico.get(2);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronPicoDeMadera.size(); i++) {
            if (!(patronPicoDeMadera.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public TipoDeHerramienta construirPicoMadera(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta picoDeMadera = new Pico(madera);
        return picoDeMadera;
    }

    public TipoDeHerramienta construirPicoPiedra(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta picoDePiedra = new Pico(piedra);
        return picoDePiedra;
    }

    public TipoDeHerramienta construirPicoMetal(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta picoDeMetal = new Pico(metal);
        return picoDeMetal;
    }


    private void cargarPatronesPico(){
        ArrayList<String> patronPicoMadera = cargarPatronPicoMadera();
        ArrayList<String> patronPicoPiedra = cargarPatronPicoPiedra();
        ArrayList<String> patronPicoMetal = cargarPatronPicoMetal();

        patronesPico = new ArrayList<>();

        patronesPico.add(patronPicoMadera);
        patronesPico.add(patronPicoPiedra);
        patronesPico.add(patronPicoMetal);
    }


    public PatronPico(){
        cargarPatronesPico();

    }

    public PatronPico(TableroDeConstruccion tablero){
        cargarPatronesPico();
        tableroConstructor = tablero;
    }

    /*
    public void imprimirPatronPico(ArrayList<String> patronPico){
        for (int j = 0; j < patronPico.size(); j++) {
            System.out.println("" + patronPico.get(j));
        }
    }
    */

    /*
    public void imprimirPatronesPico(){
        //System.out.println("Cantidad De Patrones de Pico:" + cantidadDePatrones());
        for (int i = 0; i < patronesPico.size(); i++) {
            ArrayList<String> patronPico = patronesPico.get(i);
            for (int j = 0; j < patronPico.size(); j++) {
                System.out.println("" + patronPico.get(j));
            }
            System.out.println("******** OtroPatron *********");
        }
    }

     */



    private int cantidadDePatrones(){
        return patronesPico.size();
    }

    public boolean esPatronPico(){
        return ((esPatronPicoMadera(tableroConstructor)) ||
                (esPatronPicoPiedra(tableroConstructor)) ||
                (esPatronPicoMetal(tableroConstructor)));
    }

    public TipoDeHerramienta construirPico(){
        if (esPatronPicoMadera(tableroConstructor)){
            TipoDeHerramienta pico = construirPicoMadera();
            return pico;
        }
        else if(esPatronPicoPiedra(tableroConstructor)){
            TipoDeHerramienta picoPiedra = construirPicoPiedra();
            return picoPiedra;
        }
        else if(esPatronPicoMetal(tableroConstructor)){
            TipoDeHerramienta picoMetal = construirPicoMetal();
            return  picoMetal;
        }
        return null;
    }

}
