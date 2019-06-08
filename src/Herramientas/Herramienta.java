package Herramientas;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

public class Herramienta {

    TipoDeHerramienta tipoDeHerramienta;

    public Herramienta (TipoDeHerramienta tipoDeHerramienta){
        this.tipoDeHerramienta = tipoDeHerramienta;
    }
/*
    public Herramienta crearHacha(MaterialDeHerramienta materialDeHerramienta){
        TipoDeHerramienta hacha = new Hacha(materialDeHerramienta);
        return new Herramienta(hacha);
    }

    public Herramienta crearPico(MaterialDeHerramienta materialDeHerramienta){
        TipoDeHerramienta pico = new Pico(materialDeHerramienta);
        return new Herramienta(pico);
    }

    public Herramienta crearPicoFino(MaterialDeHerramienta materialDeHerramienta){
        TipoDeHerramienta picoFino = new PicoFino(materialDeHerramienta);
        return new Herramienta(picoFino);
    }*/
}
