package Modelo.Herramientas.TipoDeHerramienta;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Materiales.Material;

public class Pico implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;
    private final String nombreDeTipo = "PICO DE ";

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
        return nombreDeTipo + materialDeHerramienta.nombreDeMaterialDeHerramienta();
    }

    @Override
    public boolean equipable(ObjeosDelInventario objeto) {
        return true;
    }
}
