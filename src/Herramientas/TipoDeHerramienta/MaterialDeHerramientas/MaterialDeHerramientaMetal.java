package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteAbrupta;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteLienalConPendienteUnMedio;
import Materiales.Material;

public class MaterialDeHerramientaMetal implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;
    private FormaDeDesgaste desgaste;

    public MaterialDeHerramientaMetal(){
        this.durabilidad = 400;
    }

    @Override
    public void setAtributosDeHacha() {
        this.fuerza = 10;
        this.desgaste = new FormaDeDesgasteLienalConPendienteUnMedio();
    }

    @Override
    public void setAtributosDePico() {
        this.fuerza = 12;
        this.desgaste = new FormaDeDesgasteAbrupta();
    }

    @Override
    public void setAtributosDePicoFino() {
        //No existe esta herramienta hacha de este material el metodo esta por el polimorfismo
        this.fuerza = 0;
        this.desgaste = new FormaDeDesgasteLienalConPendienteUnMedio();
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
