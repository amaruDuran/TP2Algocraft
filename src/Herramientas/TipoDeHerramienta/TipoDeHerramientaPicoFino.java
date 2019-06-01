package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;

public class TipoDeHerramientaPicoFino implements TipoDeHerramienta {
    private MaterialDeHerramientaMetalPiedra material;


    public TipoDeHerramientaPicoFino(MaterialDeHerramientaMetalPiedra material) {
        this.material = material;
        this.material.setFuerzaDePicoFino();
    }

    public int durabilidad() {
        return this.material.durabilidad();
    }

    public int fuerza(){
        return this.material.fuerza();
    }
}
