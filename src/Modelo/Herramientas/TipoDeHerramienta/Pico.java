package Modelo.Herramientas.TipoDeHerramienta;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Materiales.Material;

public class Pico implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;

    public Pico(MaterialDeHerramienta materialDeHerramienta) {
        this.materialDeHerramienta = materialDeHerramienta;
        this.materialDeHerramienta.setAtributosDePico();
    }

    public int durabilidad() {
        return this.materialDeHerramienta.durabilidad();
    }

    public int fuerza() {
        return this.materialDeHerramienta.fuerza();
    }
    @Override
    public boolean usarEn(Material material) {
        material.recolectadoPor(this);
        return materialDeHerramienta.usarLaHerramientaEn(material);
    }

    @Override
    public String nombreDeElemento() {
        return "PICO DE " + materialDeHerramienta.nombreDeMaterialDeHerramienta();
    }

    @Override
    public Boolean equipable() {
        return true;
    }
}
