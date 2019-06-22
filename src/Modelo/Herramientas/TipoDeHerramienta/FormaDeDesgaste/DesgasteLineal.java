package Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class DesgasteLineal implements Desgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadFinal = material.durabilidad() - material.fuerza();
        return durabilidadFinal;
    }
}
