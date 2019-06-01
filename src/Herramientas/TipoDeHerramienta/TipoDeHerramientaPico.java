package Herramientas.TipoDeHerramienta;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class TipoDeHerramientaPico implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;

    public TipoDeHerramientaPico(MaterialDeHerramienta materialDeHerramienta) {
        this.materialDeHerramienta = materialDeHerramienta;
        this.materialDeHerramienta.setFuerzaDePico();
    }

    /*public int durabilidad() {
        return this.materialDeHerramienta.durabilidad();
    }*/

    public int fuerza() {
        return this.materialDeHerramienta.fuerza();
    }
}
