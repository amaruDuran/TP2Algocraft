package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronPicoFino extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> cargarPatronPicoFino(){
        ArrayList<UnidadElemental> patronPicoFino = new ArrayList<>();
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
        ArrayList<UnidadElemental> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equivalenteA(patronDeTablero.get(i)))) {
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
