package HerramientaTest.FormasDeDesgaste;

import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Modelo.Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgastePicoFino;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesgastePicoFinoTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeUnDecimoDeSuAntiguaDurabilidad(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramienta.setAtributosDeHacha();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - (durabilidadInicial / 10);
        Desgaste desgasteDePicoFino = new DesgastePicoFino();

        int durabilidadFinal = desgasteDePicoFino.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
