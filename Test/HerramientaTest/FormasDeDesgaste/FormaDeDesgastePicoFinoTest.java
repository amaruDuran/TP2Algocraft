package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgastePicoFino;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormaDeDesgastePicoFinoTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeUnDecimoDeSuAntiguaDurabilidad(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramienta.setAtributosDeHacha();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - (durabilidadInicial / 10);
        FormaDeDesgaste desgasteDePicoFino = new FormaDeDesgastePicoFino();

        int durabilidadFinal = desgasteDePicoFino.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
