package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronHachaMetal extends PatronMaterialTipoHerramienta{


    private ArrayList<UnidadElemental> cargarPatronHachaMetal(){
        ArrayList<UnidadElemental> patronHachaMetal = new ArrayList<>();
        patronHachaMetal.add(materialMetal);
        patronHachaMetal.add(materialMetal);
        patronHachaMetal.add(materialVacio);
        patronHachaMetal.add(materialMetal);
        patronHachaMetal.add(materialMadera);
        patronHachaMetal.add(materialVacio);
        patronHachaMetal.add(materialVacio);
        patronHachaMetal.add(materialMadera);
        patronHachaMetal.add(materialVacio);

        return patronHachaMetal;
    }


    public PatronHachaMetal(){
        patronConstructorActual = cargarPatronHachaMetal();
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
        TipoDeHerramienta hachaDeMetal = new Hacha(metal);
        return hachaDeMetal;
    }
}
