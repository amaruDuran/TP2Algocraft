package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteAbrupta implements FormaDeDesgaste{
    private int golpesAntesDeRomperse = 10;

    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        golpesAntesDeRomperse = golpesAntesDeRomperse - 1;
        int durabilidadFinal;
        if (golpesAntesDeRomperse > 0){
            durabilidadFinal = material.durabilidad();
        }
        durabilidadFinal = 0;
        return durabilidadFinal;
    }
}
