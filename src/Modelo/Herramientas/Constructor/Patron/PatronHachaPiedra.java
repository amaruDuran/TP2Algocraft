package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

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
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.cargarPatronHachaPiedra();
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
