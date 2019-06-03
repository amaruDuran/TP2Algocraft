package Materiales;

import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.UnidadElemental.UnidadElementalPiedra;

public class MaterialPiedra extends Material {

    public MaterialPiedra(){
        durabilidad = 30;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorPico(TipoDeHerramientaPico herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalPiedra();
    }
}
