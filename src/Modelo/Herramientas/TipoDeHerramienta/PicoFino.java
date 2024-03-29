package Modelo.Herramientas.TipoDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Materiales.Material;

public class PicoFino implements TipoDeHerramienta {
    private MaterialDeHerramienta materialDeHerramienta;


    public PicoFino(MaterialDeHerramienta material) {
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
    public boolean usarEn(Material material) {
        material.recolectadoPor(this);
        if (!material.desgastaPicoFino()){
            return true;
        }
        return materialDeHerramienta.usarLaHerramientaEn(material);
    }

    @Override
    public String nombreDeElemento() {
        return "PICOFINO";
    }
    @Override
    public Boolean equipable() {
        return true;
    }
}
