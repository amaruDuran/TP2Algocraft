package Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteDosTercios;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLineal;
import Modelo.Materiales.Material;

import java.util.Objects;

public class MaterialDeHerramientaPiedra implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;
    private Desgaste desgaste;

    public MaterialDeHerramientaPiedra(){
        this.durabilidad = 200;
    }

    @Override
    public void setAtributosDeHacha(){
        this.fuerza = 5;
        this.desgaste = new DesgasteLineal();
    }

    @Override
    public void setAtributosDePico(){
        this.fuerza = 4;
        this.desgaste = new DesgasteLienalConPendienteDosTercios();
    }

    @Override
    public void setAtributosDePicoFino() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
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
        return "DIAMANTE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialDeHerramientaPiedra that = (MaterialDeHerramientaPiedra) o;
        return durabilidad == that.durabilidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durabilidad);
    }
}
