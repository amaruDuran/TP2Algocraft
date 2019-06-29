package Modelo.Materiales;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Juego.ObjetoDelTablero;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

import java.util.Objects;

public abstract class Material implements ObjetoDelTablero {
    protected int durabilidad;
    protected UnidadElemental unidadElemental;
    protected String identificador;

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

    //este metodo esta hardcodeada solo para pasar las pruebas hay que sacarla y poner algo que funcione
    public boolean desgastaPicoFino() {
        return false;
    }

    protected abstract void setUnidadElemental();

    public String indentificador() {
        return identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return durabilidad == material.durabilidad &&
                Objects.equals(identificador, material.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durabilidad, identificador);
    }

    public UnidadElemental getUnidadElemental(){
        return this.unidadElemental;
    }
}
