package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Materiales.Material;

public class TipoDeHerramientaPicoFino implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;


    public TipoDeHerramientaPicoFino(MaterialDeHerramienta material) {
        this.materialDeHerramienta = material;
        this.materialDeHerramienta.setAtributosDePicoFino();
    }

    public int durabilidad() {
        return this.materialDeHerramienta.durabilidad();
    }

    public int fuerza(){
        return this.materialDeHerramienta.fuerza();
    }

    @Override
    public boolean usarLaHerramientaEn(Material material) {
        return materialDeHerramienta.usarLaHerramientaEn(material);
    }
}
