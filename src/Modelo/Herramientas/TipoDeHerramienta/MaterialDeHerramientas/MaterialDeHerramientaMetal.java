package Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteAbrupta;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteUnMedio;
import Modelo.Materiales.Material;

import java.util.Objects;

public class MaterialDeHerramientaMetal implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;
    private Desgaste desgaste;

    public MaterialDeHerramientaMetal(){
        this.durabilidad = 400;
    }

    @Override
    public void setAtributosDeHacha() {
        this.fuerza = 10;
        this.desgaste = new DesgasteLienalConPendienteUnMedio();
    }

    @Override
    public void setAtributosDePico() {
        this.fuerza = 12;
        this.desgaste = new DesgasteAbrupta();
    }

    @Override
    public void setAtributosDePicoFino() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new DesgasteLienalConPendienteUnMedio();
    }

    @Override
    public int fuerza(){
        return this.fuerza;
    }

    @Override
    public int durabilidad() {
        return durabilidad;
    }

    @Override
    public boolean usarLaHerramientaEn(Material material) {
        durabilidad = desgaste.desgastarElMaterialDeHerramienta(this);
        return true;
    }

    @Override
    public String nombreDeMaterialDeHerramienta() {
        return "METAL";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialDeHerramientaMetal that = (MaterialDeHerramientaMetal) o;
        return durabilidad == that.durabilidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durabilidad);
    }
}
