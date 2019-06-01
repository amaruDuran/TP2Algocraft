package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteLienalConPendienteDosTercios implements FormaDeDesgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadFinal = material.durabilidad() - material.fuerza();
        durabilidadFinal = (durabilidadFinal * 2) / 3;
        return durabilidadFinal;
    }
}
