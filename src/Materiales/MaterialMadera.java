package Materiales;

import Herramientas.TipoDeHerramienta.Hacha;
import Materiales.UnidadElemental.UnidadElementalMadera;

public class MaterialMadera extends Material {

    public MaterialMadera(){
        durabilidad = 10;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorHacha(Hacha herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalMadera();
    }
}
