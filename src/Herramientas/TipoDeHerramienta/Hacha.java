package Herramientas.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Materiales.Material;

public class Hacha implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;

    public Hacha(MaterialDeHerramienta materialDeHerramienta){
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
    public boolean usarEn(Material material) {
        material.recolectadoPorHacha(this);
        return materialDeHerramienta.usarLaHerramientaEn(material);
    }
}
