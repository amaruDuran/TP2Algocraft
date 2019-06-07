package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLineal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesgasteLinealTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeSuFuerza(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMadera();
        materialDeHerramienta.setAtributosDeHacha();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int fuerza = materialDeHerramienta.fuerza();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - fuerza;
        Desgaste desgasteLineal = new DesgasteLineal();

        int durabilidadFinal = desgasteLineal.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
