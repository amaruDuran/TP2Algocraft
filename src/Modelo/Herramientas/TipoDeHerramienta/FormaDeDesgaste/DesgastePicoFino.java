package Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class DesgastePicoFino implements Desgaste {

    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidad = material.durabilidad();
        int durabilidadFinal = durabilidad - (durabilidad / 10);
        return durabilidadFinal;
    }
}
