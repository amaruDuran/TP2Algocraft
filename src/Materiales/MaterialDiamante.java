package Materiales;

import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.UnidadElemental.UnidadElementalDiamante;

public class MaterialDiamante extends Material
{

    public MaterialDiamante(){
        durabilidad = 100;
        this.setUnidadElemental();
        this.identificador = "DIAMANTE";
    }

    @Override
    public boolean recolectadoPor(PicoFino herramienta) {
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
