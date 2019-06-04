package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.FormaDeDesgasteAbrupta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormaDeDesgasteAbruptaTest {
    @Test
    public void seGastaUnMaterialDeHerramientaYSuDurabilidadPermaneceIntacta(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        FormaDeDesgaste desgasteAbrupto = new FormaDeDesgasteAbrupta();

        int durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(materialDeHerramienta);

        assertEquals(durabilidadInicial, durabilidadFinal);
    }
    @Test
    public void seGasta9VecesUnMaterialDeHerramientaYSuDurabilidadPermaneceIntacta(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        FormaDeDesgaste desgasteAbrupto = new FormaDeDesgasteAbrupta();
        int durabilidadFinal = -1;

        for (int i = 0; i < 9; i++){
            durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(materialDeHerramienta);
        }

        assertEquals(durabilidadInicial, durabilidadFinal);
    }
    @Test
    public void seGasta10VecesUnMaterialDeHerramientaYSuDurabilidadEsCero(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        FormaDeDesgaste desgasteAbrupto = new FormaDeDesgasteAbrupta();
        int durabilidadFinal = -1;
        for (int i = 0; i < 10; i++){
            durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(materialDeHerramienta);
        }

        assertEquals(0, durabilidadFinal);
    }
}
