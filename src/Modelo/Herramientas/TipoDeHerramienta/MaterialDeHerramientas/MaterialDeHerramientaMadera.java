package Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLineal;
import Modelo.Materiales.Material;

import java.util.Objects;

public class MaterialDeHerramientaMadera implements MaterialDeHerramienta {

    private int fuerza;
    private int durabilidad;
    private Desgaste desgaste;

    public MaterialDeHerramientaMadera(){
        this.durabilidad = 100;
    }

    @Override
    public void setAtributosDeHacha() {
        this.fuerza = 2;
        this.desgaste = new DesgasteLineal();
    }

    @Override
    public void setAtributosDePico() {
        this.fuerza = 2;
        this.desgaste = new DesgasteLineal();
    }

    @Override
    public void setAtributosDePicoFino() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new DesgasteLineal();
    }

    @Override
    public int fuerza(){
        return this.fuerza;
    }

    @Override
    public int durabilidad() {
        return this.durabilidad;
    }

    @Override
    public boolean usarLaHerramientaEn(Material material) {
        this.durabilidad = desgaste.desgastarElMaterialDeHerramienta(this);
        return true;
    }

    @Override
    public String nombreDeMaterialDeHerramienta() {
        return "MADERA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialDeHerramientaMadera that = (MaterialDeHerramientaMadera) o;
        return durabilidad == that.durabilidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(durabilidad);
    }
}
