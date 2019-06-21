package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronHachaPiedra extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> cargarPatronHachaPiedra(){
        ArrayList<UnidadElemental> patronConstructorActual = new ArrayList<>();
        patronConstructorActual.add(materialPiedra);
        patronConstructorActual.add(materialPiedra);
        patronConstructorActual.add(materialVacio);
        patronConstructorActual.add(materialPiedra);
        patronConstructorActual.add(materialMadera);
        patronConstructorActual.add(materialVacio);
        patronConstructorActual.add(materialVacio);
        patronConstructorActual.add(materialMadera);
        patronConstructorActual.add(materialVacio);

        return patronConstructorActual;
    }

    public PatronHachaPiedra(){
        this.patronConstructorActual = cargarPatronHachaPiedra();
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
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hachaDePiedra = new Hacha(piedra);
        return hachaDePiedra;
    }
}
