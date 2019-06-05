package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteUnMedio;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesgasteLienalConPendienteUnMedioTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeLaMitadDeSuFuerza(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMadera();
        materialDeHerramienta.setAtributosDeHacha();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int fuerza = materialDeHerramienta.fuerza();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - (fuerza / 2);
        Desgaste desgasteLinealConPendienteUnMedio = new DesgasteLienalConPendienteUnMedio();

        int durabilidadFinal = desgasteLinealConPendienteUnMedio.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
