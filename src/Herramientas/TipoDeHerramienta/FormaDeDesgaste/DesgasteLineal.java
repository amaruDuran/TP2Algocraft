package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteLineal implements FormaDeDesgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadFinal = material.durabilidad() - material.fuerza();
        return durabilidadFinal;
    }
}
