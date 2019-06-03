package Materiales;

import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
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

    public boolean recolectadoPorHacha(TipoDeHerramientaHacha herramienta) {
        return false;
    }

    public boolean recolectadoPorPico(TipoDeHerramientaPico herramienta) {
        return false;
    }

    public boolean recolectadoPorPicoFino(TipoDeHerramientaPicoFino herramienta) {
        return false;
    }

    protected abstract void setUnidadElemental();
}
