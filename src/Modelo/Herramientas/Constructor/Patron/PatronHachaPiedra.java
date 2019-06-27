package Modelo.Herramientas.Constructor.Patron;

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

    public PatronHachaPiedra(){
        this.patronConstructorActual = cargarPatronHachaPiedra();
    }


    @Override
    public TipoDeHerramienta construir() {
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hachaDePiedra = new Hacha(piedra);
        return hachaDePiedra;
    }
}
