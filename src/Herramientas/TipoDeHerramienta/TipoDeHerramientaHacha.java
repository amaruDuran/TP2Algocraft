package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class TipoDeHerramientaHacha implements TipoDeHerramienta{
    private MaterialDeHerramienta materialDeHerramienta;

    public TipoDeHerramientaHacha(MaterialDeHerramienta materialDeHerramienta){
        this.materialDeHerramienta = materialDeHerramienta;
        this.materialDeHerramienta.setFuerzaDeHacha();
    }

    public int durabilidad() {
        return this.materialDeHerramienta.durabilidad();
    }

    public int fuerza() {
        return this.materialDeHerramienta.fuerza();
    }
}
