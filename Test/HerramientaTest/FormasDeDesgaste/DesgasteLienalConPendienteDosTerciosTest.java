package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteLienalConPendienteDosTercios;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesgasteLienalConPendienteDosTerciosTest {
    @Test
    public void seGastaUnMaterialDeUnaHerramientaDeReduciendoSuDurabilidadEnLaCantidadDeLosDosTerciosDeSuFuerza(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        materialDeHerramienta.setAtributosDePico();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        int fuerza = materialDeHerramienta.fuerza();
        int durabilidadQueDeveriaTenerLuegoDeGastarse = durabilidadInicial - ((fuerza * 2) / 3);
        Desgaste desgasteLinealConPendienteDosTercios = new DesgasteLienalConPendienteDosTercios();

        int durabilidadFinal = desgasteLinealConPendienteDosTercios.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadQueDeveriaTenerLuegoDeGastarse, durabilidadFinal);
    }
}
