package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

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
