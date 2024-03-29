package Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class DesgasteLienalConPendienteUnMedio implements Desgaste {
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadPerdida = material.fuerza() / 2;
        int durabilidadFinal = material.durabilidad() - durabilidadPerdida;
        return durabilidadFinal;
    }
}
