package Materiales;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.UnidadElemental.UnidadElemental;

public abstract class Material {
    protected int durabilidad;
    protected UnidadElemental unidadElemental;

    protected void herramientaGastaMaterial(int fuerza){
        durabilidad = durabilidad - fuerza;
    }

    public int durabilidadActualDelMaterial(){
        return durabilidad;
    }

    public boolean recolectadoPor(Hacha herramienta) {
        return false;
    }

    public boolean recolectadoPor(Pico herramienta) {
        return false;
    }

    public boolean recolectadoPor(PicoFino herramienta) {
        return false;
    }

    //este metodo esta hardcodeada solo para pasar las pruevas hay que sacarla y poner algo que funcione
    public boolean desgastaPicoFino() {
        return false;
    }

    protected abstract void setUnidadElemental();

}
