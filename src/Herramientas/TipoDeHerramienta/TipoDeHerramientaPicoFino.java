package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Materiales.Material;
import Materiales.MaterialDiamante;

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
        if (!material.desgastaPicoFino()){
            return true;
        }
        return materialDeHerramienta.usarLaHerramientaEn(material);
    }
}
