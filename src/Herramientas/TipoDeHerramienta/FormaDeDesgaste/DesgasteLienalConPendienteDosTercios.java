package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteLienalConPendienteDosTercios implements FormaDeDesgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadPerdida = (material.fuerza() * 2) / 3;
        int durabilidadFinal = material.durabilidad() - durabilidadPerdida;
        return durabilidadFinal;
    }
}
