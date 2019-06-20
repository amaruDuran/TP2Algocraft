package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteDosTercios;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLineal;
import Materiales.Material;

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
}
