package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteLienalConPendienteUnMedio implements FormaDeDesgaste{
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadFinal = material.durabilidad() - material.fuerza();
        durabilidadFinal = durabilidadFinal / 2;
        return durabilidadFinal;
    }
}
