package Herramientas.TipoDeHerramienta.FormaDeDesgaste;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;

public class FormaDeDesgastePicoFino implements FormaDeDesgaste {

    @Override
    public int desgastarElMaterialDeHerramienta(MaterialDeHerramienta material) {
        int durabilidad = material.durabilidad();
        int durabilidadFinal = durabilidad - (durabilidad / 10);
        return durabilidadFinal;
    }
}
