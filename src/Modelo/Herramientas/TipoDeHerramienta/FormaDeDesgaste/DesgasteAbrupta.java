package Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class DesgasteAbrupta implements Desgaste {
    private int golpesAntesDeRomperse = 10;

    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        this.golpesAntesDeRomperse = this.golpesAntesDeRomperse - 1;
        int durabilidadFinal;
        if (golpesAntesDeRomperse > 0){
            durabilidadFinal = material.durabilidad();
        }
        else {
            durabilidadFinal = 0;
        }
        return durabilidadFinal;
    }
}
