package Materiales;

import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.UnidadElemental.UnidadElementalDiamante;

public class MaterialDiamante extends Material {

    public MaterialDiamante(){
        durabilidad = 100;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorPicoFino(TipoDeHerramientaPicoFino herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalDiamante();
    }
}
