package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgasteLienalConPendienteUnMedio implements FormaDeDesgaste{
    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidadPerdida = material.fuerza() / 2;
        int durabilidadFinal = material.durabilidad() - durabilidadPerdida;
        return durabilidadFinal;
    }
}
