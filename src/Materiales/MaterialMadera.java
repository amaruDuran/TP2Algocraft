package Materiales;

import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.UnidadElemental.UnidadElementalMadera;

public class MaterialMadera extends Material {

    public MaterialMadera(){
        durabilidad = 10;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorHacha(TipoDeHerramientaHacha herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalMadera();
    }
}
