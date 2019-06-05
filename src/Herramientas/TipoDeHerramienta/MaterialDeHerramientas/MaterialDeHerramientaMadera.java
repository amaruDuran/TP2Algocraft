package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLineal;
import Materiales.Material;

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
}
