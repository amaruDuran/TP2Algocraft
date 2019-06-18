package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPicoFino extends PatronMaterialTipoHerramienta{

    //Se podría Separar en sus clases Correspondientes de manera polimorfica (Ya Realizado)ó
    // aplicando el patrón de diseño "Strategy" para la construccion.
    private ArrayList<String> cargarPatronPicoFino(){
        ArrayList<String> patronPicoFino = new ArrayList<>();
        patronPicoFino.add(materialMetal);
        patronPicoFino.add(materialMetal);
        patronPicoFino.add(materialMetal);
        patronPicoFino.add(materialPiedra);
        patronPicoFino.add(materialMadera);
        patronPicoFino.add(materialVacio);
        patronPicoFino.add(materialVacio);
        patronPicoFino.add(materialMadera);
        patronPicoFino.add(materialVacio);

        return patronPicoFino;
    }

    public PatronPicoFino(){
        patronConstructorActual = cargarPatronPicoFino();
    }

    @Override
    public boolean esPatronValido(TableroDeConstruccion tablero) {
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TipoDeHerramienta construir() {
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        return picoFino;
    }
}
