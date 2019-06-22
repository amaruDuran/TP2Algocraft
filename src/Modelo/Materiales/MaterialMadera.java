package Modelo.Materiales;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Materiales.UnidadElemental.UnidadElementalMadera;

public class MaterialMadera extends Material {

    public MaterialMadera(){
        durabilidad = 10;
        this.setUnidadElemental();
        this.identificador = "MADERA";
    }

    @Override
    public boolean recolectadoPor(Hacha herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalMadera();
    }


}
