package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronHachaMadera extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> completarPatron(){
        ArrayList<UnidadElemental> patronHachaMadera = new ArrayList<>();
        patronHachaMadera.add(materialMadera);
        patronHachaMadera.add(materialMadera);
        patronHachaMadera.add(materialVacio);
        patronHachaMadera.add(materialMadera);
        patronHachaMadera.add(materialMadera);
        patronHachaMadera.add(materialVacio);
        patronHachaMadera.add(materialVacio);
        patronHachaMadera.add(materialMadera);
        patronHachaMadera.add(materialVacio);
        return patronHachaMadera;
    }

    public PatronHachaMadera(){
        this.patronConstructorActual = completarPatron();
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
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hachaDeMadera = new Hacha(madera);
        return hachaDeMadera;
    }
}
