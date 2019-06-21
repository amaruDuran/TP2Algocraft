package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronPicoMetal extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> cargarPatronPicoMetal(){
        ArrayList<UnidadElemental> patronPicoMetal = new ArrayList<>();
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialMadera);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialMadera);
        patronPicoMetal.add(materialVacio);

        return patronPicoMetal;
    }


    public PatronPicoMetal(){
        patronConstructorActual = cargarPatronPicoMetal();
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
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta picoDeMetal = new Pico(metal);
        return picoDeMetal;
    }
}
