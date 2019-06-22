package Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgastePicoFino;
import Modelo.Materiales.Material;

public class MaterialDeHerramientaMetalPiedra implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;
    private Desgaste desgaste;

    public MaterialDeHerramientaMetalPiedra(){
        this.durabilidad = 1000;
    }

    @Override
    public void setAtributosDeHacha() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new DesgastePicoFino();
    }

    @Override
    public void setAtributosDePico() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new DesgastePicoFino();
    }

    @Override
    public void setAtributosDePicoFino() {
        this.fuerza = 20;
        this.desgaste = new DesgastePicoFino();
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
        return "PIEDRA";
    }
}
