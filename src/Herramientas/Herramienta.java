package Herramientas;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;

public class Herramienta {

    TipoDeHerramienta tipoDeHerramienta;

    public Herramienta (TipoDeHerramienta tipoDeHerramienta){
        this.tipoDeHerramienta = tipoDeHerramienta;
    }

    public Herramienta crearHacha(MaterialDeHerramienta materialDeHerramienta){
        /* el material de la herramienta viene del constructor */
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(materialDeHerramienta);
        return new Herramienta(hacha);
    }

    public Herramienta crearPico(MaterialDeHerramienta materialDeHerramienta){
        /* el material de la herramienta viene del constructor */
        TipoDeHerramienta pico = new TipoDeHerramientaPico(materialDeHerramienta);
        return new Herramienta(pico);
    }

    public Herramienta crearPicoFino(MaterialDeHerramienta materialDeHerramienta){
        /* el material de la herramienta viene del constructor */
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(materialDeHerramienta);
        return new Herramienta(picoFino);
    }
}
