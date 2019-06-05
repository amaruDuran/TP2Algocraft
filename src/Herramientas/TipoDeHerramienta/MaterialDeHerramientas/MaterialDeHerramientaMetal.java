package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteAbrupta;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteUnMedio;
import Materiales.Material;

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
}
