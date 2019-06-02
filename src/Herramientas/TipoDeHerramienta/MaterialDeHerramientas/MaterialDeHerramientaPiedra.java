package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteLienalConPendienteDosTercios;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteLineal;

public class MaterialDeHerramientaPiedra implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;
    private FormaDeDesgaste desgaste;

    public MaterialDeHerramientaPiedra(){
        this.durabilidad = 200;
    }

    @Override
    public void setAtributosDeHacha(){
        this.fuerza = 5;
        this.desgaste = new FormaDeDesgasteLineal();
    }

    @Override
    public void setAtributosDePico(){
        this.fuerza = 4;
        this.desgaste = new FormaDeDesgasteLienalConPendienteDosTercios();
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
    public boolean usarLaHerramientaEn() {
        durabilidad = desgaste.desgastarElMaterialDeHerramienta(this);
        return true;
    }
}
