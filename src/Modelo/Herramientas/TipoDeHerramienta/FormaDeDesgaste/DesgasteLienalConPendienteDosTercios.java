package Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class DesgasteLienalConPendienteDosTercios implements Desgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadPerdida = (material.fuerza() * 2) / 3;
        int durabilidadFinal = material.durabilidad() - durabilidadPerdida;
        return durabilidadFinal;
    }
}
