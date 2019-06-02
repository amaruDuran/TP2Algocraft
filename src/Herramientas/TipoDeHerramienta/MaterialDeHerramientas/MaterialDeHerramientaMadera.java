package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteLineal;

public class MaterialDeHerramientaMadera implements MaterialDeHerramienta {

    private int fuerza;
    private int durabilidad;
    private FormaDeDesgaste desgaste;

    public MaterialDeHerramientaMadera(){
        this.durabilidad = 100;
    }

    @Override
    public void setAtributosDeHacha() {
        this.fuerza = 2;
        this.desgaste = new FormaDeDesgasteLineal();
    }

    @Override
    public void setAtributosDePico() {
        this.fuerza = 2;
        this.desgaste = new FormaDeDesgasteLineal();
    }

    @Override
    public void setAtributosDePicoFino() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new FormaDeDesgasteLineal();
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
    public boolean usarLaHerramientaEn() {
        durabilidad = desgaste.desgastarElMaterialDeHerramienta(this);
        return true;
    }
}
