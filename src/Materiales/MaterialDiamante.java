package Materiales;

import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.UnidadElemental.UnidadElementalDiamante;

public class MaterialDiamante extends Material {

    public MaterialDiamante(){
        durabilidad = 100;
        this.setUnidadElemental();
    }

    @Override
    public boolean recolectadoPorPicoFino(PicoFino herramienta) {
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalDiamante();
    }

    @Override//borrar este metodo
    public boolean desgastaPicoFino() {
        return true;
    }
}
