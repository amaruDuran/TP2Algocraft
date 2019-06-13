package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPicoFino {

    private ArrayList<ArrayList<String>> patronesPicoFino;
    private TableroDeConstruccion tableroConstructor;

    private String materialMadera = "MADERA";
    private String materialPiedra = "PIEDRA";
    private String materialMetal = "METAL";
    private String materialVacio = "VACIO";

    //Se podría Separar en sus clases Correspondientes de manera polimorfica ó
    // aplicando el patrón de diseño "Strategy" para la construccion.
    private ArrayList<String> cargarPatronPicoFino(){
        ArrayList<String> patronPicoFino = new ArrayList<>();
        patronPicoFino.add("METAL");
        patronPicoFino.add("METAL");
        patronPicoFino.add("METAL");
        patronPicoFino.add("PIEDRA");
        patronPicoFino.add("MADERA");
        patronPicoFino.add("VACIO");
        patronPicoFino.add("VACIO");
        patronPicoFino.add("MADERA");
        patronPicoFino.add("VACIO");

        return patronPicoFino;
    }

    private boolean _esPatronPicoFino(TableroDeConstruccion tablero){
        ArrayList<String> patronPicoFino = patronesPicoFino.get(0);
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronPicoFino.size(); i++) {
            if (!(patronPicoFino.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public boolean esPatronPicoFino(){
        return _esPatronPicoFino(tableroConstructor);
    }

    public TipoDeHerramienta construirPicoFino(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        return picoFino;
    }

    private void cargarPatronesPicoFino(){
        ArrayList<String> patronPicoFino = cargarPatronPicoFino();

        patronesPicoFino = new ArrayList<>();

        patronesPicoFino.add(patronPicoFino);

    }

    public PatronPicoFino(TableroDeConstruccion tablero){
        cargarPatronesPicoFino();
        tableroConstructor = tablero;
    }

}
