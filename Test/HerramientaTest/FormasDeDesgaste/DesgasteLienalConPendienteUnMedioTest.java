package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteLienalConPendienteUnMedio;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormaDeDesgasteLienalConPendienteUnMedioTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeLaMitadDeSuFuerza(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMadera();
        materialDeHerramienta.setAtributosDeHacha();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int fuerza = materialDeHerramienta.fuerza();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - (fuerza / 2);
        FormaDeDesgaste desgasteLinealConPendienteUnMedio = new FormaDeDesgasteLienalConPendienteUnMedio();

        int durabilidadFinal = desgasteLinealConPendienteUnMedio.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
