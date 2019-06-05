package Materiales;

import Herramientas.TipoDeHerramienta.Pico;
import Materiales.UnidadElemental.UnidadElementalPiedra;

public class MaterialPiedra extends Material {

    public MaterialPiedra(){
        durabilidad = 30;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorPico(Pico herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalPiedra();
    }
}
