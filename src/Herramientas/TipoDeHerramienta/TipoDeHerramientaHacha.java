package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Materiales.Material;

public class TipoDeHerramientaHacha implements TipoDeHerramienta{
    private MaterialDeHerramienta materialDeHerramienta;

    public TipoDeHerramientaHacha(MaterialDeHerramienta materialDeHerramienta){
        this.materialDeHerramienta = materialDeHerramienta;
        this.materialDeHerramienta.setAtributosDeHacha();
    }

    public int durabilidad() {
        return this.materialDeHerramienta.durabilidad();
    }

    public int fuerza() {
        return this.materialDeHerramienta.fuerza();
    }
    @Override
    public boolean usarLaHerramientaEn(Material material) {
        return materialDeHerramienta.usarLaHerramientaEn(/* sedebe enviar el material actualizar */);
    }
}
