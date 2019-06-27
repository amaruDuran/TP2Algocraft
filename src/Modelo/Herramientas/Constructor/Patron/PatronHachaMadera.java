package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

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
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.completarPatron();
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
