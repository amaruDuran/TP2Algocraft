package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

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
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.cargarPatronHachaMetal();
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
